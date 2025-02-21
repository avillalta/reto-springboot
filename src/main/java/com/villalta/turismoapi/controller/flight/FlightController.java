package com.villalta.turismoapi.controller.flight;

import com.villalta.turismoapi.model.flight.Flight;
import com.villalta.turismoapi.service.flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Obtener todos los vuelos
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // Obtener un vuelo por ID
    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable String id) {
        return flightService.getFlightById(id);
    }

    // Crear un nuevo vuelo
    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    // Actualizar un vuelo existente
    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable String id, @RequestBody Flight flightDetails) {
        return flightService.updateFlight(id, flightDetails);
    }

    // Eliminar un vuelo
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable String id) {
        flightService.deleteFlight(id);
    }

    // Buscar vuelos por aeropuerto de salida
    @GetMapping("/departure/{departureAirport}")
    public List<Flight> getFlightsByDepartureAirport(@PathVariable String departureAirport) {
        return flightService.getFlightsByDepartureAirport(departureAirport);
    }

    // Buscar vuelos por aeropuerto de llegada
    @GetMapping("/arrival/{arrivalAirport}")
    public List<Flight> getFlightsByArrivalAirport(@PathVariable String arrivalAirport) {
        return flightService.getFlightsByArrivalAirport(arrivalAirport);
    }

    // Buscar vuelos por rango de fechas de salida
    @GetMapping("/search")
    public List<Flight> getFlightsByDepartureTimeRange(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return flightService.getFlightsByDepartureTimeRange(start, end);
    }
}
