package com.villalta.turismoapi.repository.hotel;

import com.villalta.turismoapi.model.hotel.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

    List<Hotel> findByLocation(String location);


    List<Hotel> findByStars(int stars);
}
