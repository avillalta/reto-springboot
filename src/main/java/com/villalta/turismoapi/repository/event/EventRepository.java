package com.villalta.turismoapi.repository.event;

import com.villalta.turismoapi.model.event.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    List<Event> findByLocation(String location);


    List<Event> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);


    List<Event> findByNameContainingIgnoreCase(String name);
}
