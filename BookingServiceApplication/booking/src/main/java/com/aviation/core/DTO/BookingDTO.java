package com.aviation.core.DTO;

public class BookingDTO {
        /*public class BookingDTO {
    private Long id;
    private String passengerName;
    private String passengerSurname;
    private String ticketNumber;
    private String flightNumber;
    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public String getPassengerSurname() {
        return passengerSurname;
    }
    public void setPassengerSurname(String passengerSurname) {
        this.passengerSurname = passengerSurname;
    }
    public String getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
*/
}
/*Мапперы для преобразования моделей в DTO и наоборот: создание мапперов для преобразования сущностей в DTO и обратно может быть выполнено с использованием библиотеки, такой как MapStruct, или вручную.
Пример маппера с использованием MapStruct:
java
@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightDTO toDTO(Flight flight);
    Flight toEntity(FlightDTO flightDTO);
}
@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingDTO toDTO(Booking booking);
    Booking toEntity(BookingDTO bookingDTO);
}
Контроллеры для обработки запросов с использованием DTO: Используйте DTO в контроллерах для обмена данными между клиентом и сервером.
java
@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightMapper flightMapper;
    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return flightService.getAllFlights().stream()
            .map(flightMapper::toDTO)
            .collect(Collectors.toList());
    }
    @PostMapping
    public FlightDTO createFlight(@RequestBody FlightDTO flightDTO) {
        Flight flight = flightMapper.toEntity(flightDTO);
        return flightMapper.toDTO(flightService.saveFlight(flight));
    }
}
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingMapper bookingMapper;
    @GetMapping("/{ticketNumber}")
    public BookingDTO getBookingByTicketNumber(@PathVariable String ticketNumber) {
        Booking booking = bookingService.getBookingByTicketNumber(ticketNumber);
        return bookingMapper.toDTO(booking);
    }
    @PostMapping
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        return bookingMapper.toDTO(bookingService.saveBooking(booking));
    }
    @DeleteMapping("/{ticketNumber}")
    public void deleteBooking(@PathVariable String ticketNumber) {
        bookingService.deleteBooking(ticketNumber);
    }
}*/

