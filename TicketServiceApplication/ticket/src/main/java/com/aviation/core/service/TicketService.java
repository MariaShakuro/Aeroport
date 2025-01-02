package com.aviation.core.service;

import com.aviation.core.DTO.TicketDTO;
import com.aviation.core.archiveAndEncrypt.ArchiveUtils;
import com.aviation.core.archiveAndEncrypt.EncryptionUtils;
import com.aviation.core.entity.TicketEntity;
import com.aviation.core.fileUtil.FileReaderUtil;
import com.aviation.core.fileUtil.FileWriterUtil;
import com.aviation.core.repository.TicketRepository;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import com.aviation.core.arithmeticAdds.DataProcessor;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketDTO ticketDTO;

    public TicketEntity createTicket(TicketEntity ticket) throws WriterException, IOException, NoSuchAlgorithmException {
        // Генерация уникального штрихкода
        String barcodeHash = BarcodeGenerator.generateBarcode(ticket.getBookingCode(), "barcodes/" + ticket.getBookingCode() + ".png");
        ticket.setBookingCode(barcodeHash);
        // Сохранение билета в базу данных
        return ticketRepository.save(ticket);
    }
    public void deleteTicket(Long ticketNumber) {
        ticketRepository.deleteById(ticketNumber);
    }
    public void readData(String filePath, String fileType) throws IOException {
        switch (fileType.toLowerCase()) {
            case "txt":
                List<String> textData = FileReaderUtil.readTextFile(filePath);
                // Обработка данных
                break;
            case "xml":
                Document xmlData = FileReaderUtil.readXmlFile(filePath);
                // Обработка данных
                break;
            case "json":
                TicketDTO ticketData = FileReaderUtil.readJsonFile(filePath, TicketDTO.class);
                break;
                // Обработка данных
            case "yaml":
                TicketDTO ticketInfo=FileReaderUtil.readYamlFile(filePath,TicketDTO.class);
                break;
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }
    }

    public void writeData(String filePath, String fileType, TicketEntity ticket) throws IOException {
        switch (fileType.toLowerCase()) {
            case "txt":
                FileWriterUtil.writeTextFile(filePath,ticket);
                break;
            case "xml":
                FileWriterUtil.writeXmlFile(filePath,ticket);
                break;
            case "json":
                FileWriterUtil.writeJsonFile(filePath,ticket);
                break;
            case "yaml":
                FileWriterUtil.writeYamlFile(filePath,ticket);
                break;
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }
    }

    public void processData(String filePath, String fileType,TicketEntity ticket) throws IOException {
        switch (fileType.toLowerCase()) {
            case "txt":
              FileWriterUtil.writeTextFile(filePath, ticket);
                break;
            case "xml":
                FileWriterUtil.writeXmlFile(filePath,ticket);
                break;
            case "json":
                FileWriterUtil.writeJsonFile(filePath, ticket);
                break;
            case "yaml":
                FileWriterUtil.writeYamlFile(filePath,ticket);
                break;
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }
    }

    public TicketEntity updateTicketPrice(String passengerSurname,String passengerName, String promoCode, boolean useMiles, int miles) {
        TicketEntity ticket = getTicketBySurnameAndName(passengerSurname,passengerName);
        if (ticket != null) {
            double updatedPrice = DataProcessor.calculateTotalCost(ticket, promoCode, useMiles, miles);
            ticket.setTicketPrice(updatedPrice);
            return ticketRepository.save(ticket);
        }
        return null;
    }
   /* public void processAsync() {
        // Настройка Kafka
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>("ticket_topic", "key", "value");
        producer.send(record);
        producer.close();
    }*/

    public void archiveAndEncrypt(String sourceFilePath, String destFilePath, String key, String archiveFormat, boolean encryptFirst,boolean archiveFirst) throws Exception {
        boolean isZip = "zip".equalsIgnoreCase(archiveFormat);
        boolean isRar = "rar".equalsIgnoreCase(archiveFormat);

        if (archiveFirst) {
            if (encryptFirst) {
                if (isZip) {
                    ArchiveUtils.archiveFileToZip(sourceFilePath, destFilePath + ".zip");
                    String encryptedData = EncryptionUtils.encrypt(readFileAsString(destFilePath + ".zip"), key);
                    writeFile(destFilePath, encryptedData);
                } else if (isRar) {
                    ArchiveUtils.archiveFileToRar(sourceFilePath, destFilePath + ".rar");
                    String encryptedData = EncryptionUtils.encrypt(readFileAsString(destFilePath + ".rar"), key);
                    writeFile(destFilePath, encryptedData);
                }
            } else {
                String encryptedData = EncryptionUtils.encrypt(readFileAsString(sourceFilePath), key);
                writeFile(sourceFilePath + ".enc", encryptedData);
                if (isZip) {
                    ArchiveUtils.archiveFileToZip(sourceFilePath + ".enc", destFilePath + ".zip");
                } else if (isRar) {
                    ArchiveUtils.archiveFileToRar(sourceFilePath + ".enc", destFilePath + ".rar");
                }
            }
        } else {
            if (encryptFirst) {
                String encryptedData = EncryptionUtils.encrypt(readFileAsString(sourceFilePath), key);
                writeFile(sourceFilePath + ".enc", encryptedData);
                if (isZip) {
                    ArchiveUtils.archiveFileToZip(sourceFilePath + ".enc", destFilePath + ".zip");
                } else if (isRar) {
                    ArchiveUtils.archiveFileToRar(sourceFilePath + ".enc", destFilePath + ".rar");
                }
            } else {
                if (isZip) {
                    ArchiveUtils.archiveFileToZip(sourceFilePath, destFilePath + ".zip");
                    String encryptedData = EncryptionUtils.encrypt(readFileAsString(destFilePath + ".zip"), key);
                    writeFile(destFilePath, encryptedData);
                } else if (isRar) {
                    ArchiveUtils.archiveFileToRar(sourceFilePath, destFilePath + ".rar");
                }
            }
        }
    }
    // Новый метод для чтения данных из базы и записи в файл
    public void exportDataToFile(String fileType,TicketEntity ticket) throws IOException {
        List<TicketEntity> tickets = ticketRepository.findAll();
        File outputDir = new File("output");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        String fileName = "output/ticket." + fileType;
        switch (fileType.toLowerCase()) {
            case "txt":
                FileWriterUtil.writeTextFile(fileName, ticket);
                 break;
            case "xml":
                FileWriterUtil.writeXmlFile(fileName, ticket);
                break;
            case "json":
                FileWriterUtil.writeJsonFile(fileName, ticket);
                break;
            case "yaml":
                FileWriterUtil.writeYamlFile(fileName,ticket);
                break;
                default:
                    throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }
    }
    // Вспомогательные методы
    private String readFileAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    private void writeFile(String filePath, String data) throws IOException {
        Files.write(Paths.get(filePath), data.getBytes());
    }
    public TicketEntity getTicketBySurnameAndName(String passengerSurname,String passengerName) { return ticketRepository.findByPassengerSurnameAndPassengerName(passengerSurname,passengerName); }
}