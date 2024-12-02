package com.aviation.core.service;

import com.aviation.core.entity.TicketEntity;
import com.aviation.core.format.FileFormat;
import com.aviation.core.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TicketSevice {
    @Autowired
    private TicketRepository ticketRepository;
    //достали данные из бд
    public List<TicketEntity>getAllTickets(){
        return ticketRepository.findAll();
    }
    public TicketEntity saveTicket(TicketEntity ticketEntity){
        return ticketRepository.save(ticketEntity);
    }
    public void deleteTicket(Long ticketNumber){
        TicketEntity ticketEntity =ticketRepository.findByTicketNumber(ticketNumber);
        ticketRepository.delete(ticketEntity);
    }
    public void exportTicketsToFile(String format,String filename)throws IOException {
        List<TicketEntity>tickets=getAllTickets();
        switch(format.toLowerCase()){
            case "json":
                FileFormat.writeToJson(tickets,filename);
                break;
            case "xml":
                FileFormat.writeToXml(tickets,filename);
                break;
            case "yaml":
                FileFormat.writeToYaml(tickets,filename);
                break;
            case "txt":
                FileFormat.writeToTxt(tickets,filename);
                break;
            default:
                throw new IllegalArgumentException("Error in format:"+ format);
        }
    }
}
