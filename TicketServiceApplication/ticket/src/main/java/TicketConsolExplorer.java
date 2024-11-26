import com.aviation.core.archiencrypt.Encryption;
import com.aviation.core.archiencrypt.FileProcessor;
import com.aviation.core.service.TicketSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


@Component
public class TicketConsolExplorer implements CommandLineRunner {
    @Autowired
    private TicketSevice ticketSevice;
    @Override
    public void run(String[] args) throws Exception {
        Scanner in=new Scanner(System.in);
        PrintWriter out =new PrintWriter(System.out);
        String outputFilePath="";
        ///////////////////////////////////////////////////////
        String sourceFilePath = "input.txt";
        String destFilePath = "output";
        String inputFilePath = "input.txt";
        String archiveFormat = "zip";//можно заменить на джар
        String encryptedFilePath = "encrypted.enc";
        String decryptedFilePath = "decrypted.txt";
        String key="1234567890123456";//16-байтовый для ES
        //Архивация jar и zip
        // Сначала шифрование, затем архивирование
        FileProcessor.processFile(sourceFilePath, destFilePath, key, true, true, archiveFormat);
        // Сначала архивирование, затем шифрование
         FileProcessor.processFile(sourceFilePath, destFilePath, key, false, true, archiveFormat);
        // Сначала шифрование, затем архивирование
         FileProcessor.processFile(sourceFilePath, destFilePath, key, true, false, archiveFormat);
        // Сначала архивирование, затем шифрование
         FileProcessor.processFile(sourceFilePath, destFilePath, key, false, false, archiveFormat);
        // Шифрование
        File inputFile = new File(inputFilePath);
        File encryptedFile = new File(encryptedFilePath);
        Encryption.encryptFile(inputFile, encryptedFile,key);
        System.out.println("Файл зашифрован: " + encryptedFilePath);
        // Дешифрование
        File decryptedFile = new File(decryptedFilePath);
        Encryption.decryptFile(encryptedFile, decryptedFile,key);
        System.out.println("Файл расшифрован: " + decryptedFilePath);
        ////////////////////////////////////////////////////////////////
        out.println("Enter format:json,xml,yaml,txt:");
        String format=in.nextLine();
        out.println("Enter filename:");
        String filename=in.nextLine();
        ticketSevice.exportTicketsToFile(format,filename);
        out.println("Tickets are written successfully in"+filename);
    }
}
