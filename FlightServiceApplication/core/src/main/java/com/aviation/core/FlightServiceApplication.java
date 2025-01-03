package com.aviation.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"com.aviation.core"})
public class FlightServiceApplication {
	public static void main(String[] args) {

		ApplicationContext ctx=SpringApplication.run(FlightServiceApplication.class, args);

	}

}
