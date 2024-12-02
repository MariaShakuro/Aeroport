package com.aviation.core.controller;

import com.aviation.core.entity.Display;
import com.aviation.core.repository.DisplayRepository;
import com.aviation.core.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/display")
public class DisplayController {
    @Autowired
    private DisplayRepository displayRepository;
    @Autowired
    private Display display;

    @GetMapping("/{flightId}")
    public ResponseEntity<Display>getDisplayInfo(@PathVariable Long flightId){
        display=displayRepository.findById(flightId).orElseThrow(()->new RuntimeException("Flight not found"));
        return ResponseEntity.ok(display);
    }
}
