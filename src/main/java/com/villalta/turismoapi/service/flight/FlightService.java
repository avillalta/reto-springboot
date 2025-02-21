package com.villalta.turismoapi.service.flight;

import com.villalta.turismoapi.model.flight.Flight;
import com.villalta.turismoapi.repository.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Obtener todos los vuelos
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Obtener un vuelo por ID
    public Flight getFlightById(String id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado con id: " + id));
    }

    // Crear un nuevo vuelo
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Actualizar un vuelo existente
    public Flight updateFlight(String id, Flight flightDetails) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado con id: " + id));

        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setDepartureAirport(flightDetails.getDepartureAirport());
        flight.setArrivalAirport(flightDetails.getArrivalAirport());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setArrivalTime(flightDetails.getArrivalTime());
        flight.setPrice(flightDetails.getPrice());

        return flightRepository.save(flight);
    }

    // Eliminar un vuelo
    public void deleteFlight(String id) {
        flightRepository.deleteById(id);
    }

    // Buscar vuelos por aeropuerto de salida
    public List<Flight> getFlightsByDepartureAirport(String departureAirport) {
        return flightRepository.findByDepartureAirport(departureAirport);
    }

    // Buscar vuelos por aeropuerto de llegada
    public List<Flight> getFlightsByArrivalAirport(String arrivalAirport) {
        return flightRepository.findByArrivalAirport(arrivalAirport);
    }

    // Buscar vuelos por rango de fechas de salida
    public List<Flight> getFlightsByDepartureTimeRange(LocalDateTime start, LocalDateTime end) {
        return flightRepository.findByDepartureTimeBetween(start, end);
    }
}
