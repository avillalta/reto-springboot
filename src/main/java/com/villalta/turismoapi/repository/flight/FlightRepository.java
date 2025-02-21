package com.villalta.turismoapi.repository.flight;

import com.villalta.turismoapi.model.flight.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {

    List<Flight> findByDepartureAirport(String departureAirport);


    List<Flight> findByArrivalAirport(String arrivalAirport);


    List<Flight> findByDepartureTimeBetween(LocalDateTime start, LocalDateTime end);
}
