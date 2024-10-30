package com.aviation.core.controller;

import com.aviation.core.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/display")
public class DisplayController {
    @Autowired
    private DisplayService displayService;
  //  @GetMapping
 //   public List<Display> getFlightDisplay() {
   //     return displayService.getFlightDisplay();
  //  }
}
