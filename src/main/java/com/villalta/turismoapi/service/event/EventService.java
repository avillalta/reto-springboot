package com.villalta.turismoapi.service.event;

import com.villalta.turismoapi.model.event.Event;
import com.villalta.turismoapi.repository.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Obtener todos los eventos
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Obtener un evento por ID
    public Event getEventById(String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con id: " + id));
    }

    // Crear un nuevo evento
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Actualizar un evento existente
    public Event updateEvent(String id, Event eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con id: " + id));

        event.setName(eventDetails.getName());
        event.setDescription(eventDetails.getDescription());
        event.setStartTime(eventDetails.getStartTime());
        event.setEndTime(eventDetails.getEndTime());
        event.setLocation(eventDetails.getLocation());
        event.setPrice(eventDetails.getPrice());

        return eventRepository.save(event);
    }

    // Eliminar un evento
    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

    // Buscar eventos por ubicación
    public List<Event> getEventsByLocation(String location) {
        return eventRepository.findByLocation(location);
    }


    // Buscar eventos por nombre
    public List<Event> getEventsByName(String name) {
        return eventRepository.findByNameContainingIgnoreCase(name);
    }
}
