package com.villalta.turismoapi.service.hotel;

import com.villalta.turismoapi.model.hotel.Hotel;
import com.villalta.turismoapi.repository.hotel.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    // Obtener todos los hoteles
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Obtener un hotel por ID
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado con id: " + id));
    }

    // Crear un nuevo hotel
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Actualizar un hotel existente
    public Hotel updateHotel(String id, Hotel hotelDetails) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado con id: " + id));

        hotel.setName(hotelDetails.getName());
        hotel.setDescription(hotelDetails.getDescription());
        hotel.setLocation(hotelDetails.getLocation());
        hotel.setStars(hotelDetails.getStars());
        hotel.setPricePerNight(hotelDetails.getPricePerNight());

        return hotelRepository.save(hotel);
    }

    // Eliminar un hotel
    public void deleteHotel(String id) {
        hotelRepository.deleteById(id);
    }

    // Buscar hoteles por ubicación
    public List<Hotel> getHotelsByLocation(String location) {
        return hotelRepository.findByLocation(location);
    }

    // Buscar hoteles por número de estrellas
    public List<Hotel> getHotelsByStars(int stars) {
        return hotelRepository.findByStars(stars);
    }
}