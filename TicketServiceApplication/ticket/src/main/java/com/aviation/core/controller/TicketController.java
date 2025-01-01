package com.aviation.core.controller;


import com.aviation.core.DTO.TicketDTO;
import com.aviation.core.entity.TicketEntity;
import com.aviation.core.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<String> createTicket(@RequestBody TicketEntity ticket) {
        try {
            ticketService.createTicket(ticket);
            return new ResponseEntity<>("Ticket created successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error creating ticket: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{ticketNumber}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long ticketNumber) {
        try {
            ticketService.deleteTicket(ticketNumber);
            return new ResponseEntity<>("Ticket deleted successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error deleting ticket: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/read")
    public ResponseEntity<String> readData(@RequestParam String filePath, @RequestParam String fileType) {
        try {
            ticketService.readData(filePath, fileType);
            return new ResponseEntity<>("Data read successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error reading data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/write")
    public ResponseEntity<String> writeData(@RequestParam String filePath, @RequestParam String fileType, @RequestBody TicketEntity ticket) {
        try {
            ticketService.writeData(filePath, fileType,ticket);
            return new ResponseEntity<>("Data written successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error writing data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/process")
    public ResponseEntity<String> processData(@RequestParam String passengerSurname, @RequestParam String promoCode,
                                              @RequestParam boolean useMiles,@RequestParam int miles) {
        try {
           TicketEntity updatedTicket= ticketService.updateTicketPrice(passengerSurname, promoCode, useMiles, miles);
           if(updatedTicket != null) return new ResponseEntity<>("Data processed successfully.Updated ticket price"+ updatedTicket.getTicketPrice(),HttpStatus.OK);
           else return new ResponseEntity<>("Ticket not found for passenger surname:"+ passengerSurname,HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/archive-encrypt")
    public ResponseEntity<String> archiveAndEncrypt(@RequestParam String sourceFilePath,
                                                    @RequestParam String destFilePath,
                                                    @RequestParam String key,
                                                    @RequestParam String archiveFormat,
                                                    @RequestParam boolean encryptFirst,
                                                    @RequestParam boolean archiveFirst) {
        try {
            ticketService.archiveAndEncrypt(sourceFilePath, destFilePath, key, archiveFormat, encryptFirst, archiveFirst);
            return new ResponseEntity<>("Data archived and encrypted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error archiving and encrypting data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Метод для асинхронной обработки данных (если потребуется)
    // @PostMapping("/process-async")
    // public ResponseEntity<String> processAsync() {
    //     try {
    //         ticketService.processAsync();
    //         return new ResponseEntity<>("Data processed asynchronously successfully", HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>("Error processing data asynchronously: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
}


