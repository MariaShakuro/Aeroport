package com.aviation.core.service;

import com.aviation.core.entity.Booking;
import com.aviation.core.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private WebClient webClient;
    @Autowired
    private Booking booking;
    @Autowired
    private BookingRepository bookingRepository;
   /* public List<Booking>getAllBookings(){
        return bookingRepository.findAll();
    }*/
    public Mono<Booking> createBooking(Booking bookingRequest){
        return webClient.get()
                .uri("http://localhost:8082/api/display/"+bookingRequest.getId())
                .retrieve()
                .bodyToMono(DisplayInfo.class)
                .flatMap(displayInfo->{
                    booking.setId(displayInfo.getId());
                    booking.setAge(displayInfo.getAge());
                    booking.setDate(displayInfo.getDate());
                    booking.setCategory(displayInfo.getCategory());
                    booking.setFlightNumber(displayInfo.);
                    booking.setPassengerName(displayInfo.);
                    booking.setPassergerSurname(displayInfo.);
                    booking.setPassengerPatronymic(displayInfo.);
                    booking.setTicketNumber(displayInfo.);
                    return Mono.just(bookingRepository.save(booking));
                });
    }
}
