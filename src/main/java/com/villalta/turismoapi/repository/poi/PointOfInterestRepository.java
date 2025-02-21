package com.villalta.turismoapi.repository.poi;

import com.villalta.turismoapi.model.poi.PointOfInterest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointOfInterestRepository extends MongoRepository<PointOfInterest, String> {

    List<PointOfInterest> findByCategory(String category);


    List<PointOfInterest> findByNameContainingIgnoreCase(String name);
}
