package com.crew.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class ScheduleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleServiceApplication.class, args);
	}
	@PostMapping("/schedule-maintenance")
	public ResponseEntity<String > scheduleMaintenance(@RequestParam Long planeId){
		flightService.scheduleMaintenance(planeId);
		return new ResponseEntity<>("Maintenance scheduled successfully", HttpStatus.OK);
	}
}
