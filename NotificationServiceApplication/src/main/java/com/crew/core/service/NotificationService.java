package com.crew.core.service;

@Service
public class NotificationService {

    @Autowired
    private FlightRepository flightRepository;

    public void notifyPassengersAboutChanges(Long flightId, String message) {
        FlightEntity flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));
        List<Passenger> passengers = flight.getPassengers();
        for (Passenger passenger : passengers) {
            // Логика для отправки уведомления пассажиру
            sendNotification(passenger, message);
        }
    }

    private void sendNotification(Passenger passenger, String message) {
        // Реализация отправки уведомления (например, по email или SMS)
    }
}
