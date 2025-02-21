package com.villalta.turismoapi.controller.hotel;

import com.villalta.turismoapi.model.hotel.Hotel;
import com.villalta.turismoapi.service.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Obtener todos los hoteles
    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    // Obtener un hotel por ID
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable String id) {
        return hotelService.getHotelById(id);
    }

    // Crear un nuevo hotel
    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }

    // Actualizar un hotel existente
    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable String id, @RequestBody Hotel hotelDetails) {
        return hotelService.updateHotel(id, hotelDetails);
    }

    // Eliminar un hotel
    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable String id) {
        hotelService.deleteHotel(id);
    }

    // Buscar hoteles por ubicación
    @GetMapping("/location/{location}")
    public List<Hotel> getHotelsByLocation(@PathVariable String location) {
        return hotelService.getHotelsByLocation(location);
    }

    // Buscar hoteles por número de estrellas
    @GetMapping("/stars/{stars}")
    public List<Hotel> getHotelsByStars(@PathVariable int stars) {
        return hotelService.getHotelsByStars(stars);
    }
}