package com.villalta.turismoapi.config;

import com.villalta.turismoapi.model.event.Event;
import com.villalta.turismoapi.model.flight.Flight;
import com.villalta.turismoapi.model.hotel.Hotel;
import com.villalta.turismoapi.model.poi.PointOfInterest;
import com.villalta.turismoapi.model.user.Role;
import com.villalta.turismoapi.model.user.User;
import com.villalta.turismoapi.repository.event.EventRepository;
import com.villalta.turismoapi.repository.flight.FlightRepository;
import com.villalta.turismoapi.repository.hotel.HotelRepository;
import com.villalta.turismoapi.repository.poi.PointOfInterestRepository;
import com.villalta.turismoapi.repository.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(
            HotelRepository hotelRepository,
            PointOfInterestRepository poiRepository,
            FlightRepository flightRepository,
            EventRepository eventRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {
            // Cargar datos de hoteles (solo si no hay hoteles en la base de datos)
            if (hotelRepository.count() == 0) {
                hotelRepository.saveAll(Arrays.asList(
                        new Hotel("Hotel Plaza", "Un hotel de lujo en el centro de Madrid.", "Madrid", 5, 250.0),
                        new Hotel("Hotel Sol", "Un hotel acogedor en el corazón de Sevilla.", "Sevilla", 4, 150.0),
                        new Hotel("Hotel Mar", "Un hotel frente al mar en Barcelona.", "Barcelona", 4, 200.0),
                        new Hotel("Hotel Montaña", "Un hotel en la montaña con vistas increíbles.", "Granada", 3, 120.0),
                        new Hotel("Hotel Río", "Un hotel junto al río en Valencia.", "Valencia", 4, 180.0)
                ));
                System.out.println("Datos de hoteles cargados.");
            }

            // Cargar datos de POIs (solo si no hay POIs en la base de datos)
            if (poiRepository.count() == 0) {
                poiRepository.saveAll(Arrays.asList(
                        new PointOfInterest("Museo del Prado", "Uno de los museos más importantes del mundo.", "Museo", 40.4138, -3.6921),
                        new PointOfInterest("Alhambra", "Un palacio y fortaleza de la época nazarí.", "Monumento", 37.1760, -3.5889),
                        new PointOfInterest("Sagrada Familia", "Una basílica diseñada por Gaudí.", "Monumento", 41.4036, 2.1744),
                        new PointOfInterest("Park Güell", "Un parque con obras de Gaudí.", "Parque", 41.4145, 2.1527),
                        new PointOfInterest("Acueducto de Segovia", "Un impresionante acueducto romano.", "Monumento", 40.9481, -4.1184)
                ));
                System.out.println("Datos de POIs cargados.");
            }

            // Cargar datos de vuelos (solo si no hay vuelos en la base de datos)
            if (flightRepository.count() == 0) {
                flightRepository.saveAll(Arrays.asList(
                        new Flight("AA123", "JFK", "LAX", LocalDateTime.of(2023, 12, 25, 8, 0), LocalDateTime.of(2023, 12, 25, 11, 0), 299.99),
                        new Flight("BA456", "LHR", "CDG", LocalDateTime.of(2023, 12, 26, 9, 0), LocalDateTime.of(2023, 12, 26, 11, 30), 199.99),
                        new Flight("LH789", "FRA", "MAD", LocalDateTime.of(2023, 12, 27, 10, 0), LocalDateTime.of(2023, 12, 27, 12, 0), 149.99),
                        new Flight("IB321", "MAD", "BCN", LocalDateTime.of(2023, 12, 28, 7, 0), LocalDateTime.of(2023, 12, 28, 8, 0), 99.99),
                        new Flight("VY654", "BCN", "AMS", LocalDateTime.of(2023, 12, 29, 12, 0), LocalDateTime.of(2023, 12, 29, 14, 0), 129.99)
                ));
                System.out.println("Datos de vuelos cargados.");
            }

            // Cargar datos de eventos (solo si no hay eventos en la base de datos)
            if (eventRepository.count() == 0) {
                eventRepository.saveAll(Arrays.asList(
                        new Event("Concierto de Rock", "Un concierto increíble con las mejores bandas de rock.", LocalDateTime.of(2023, 12, 25, 20, 0), LocalDateTime.of(2023, 12, 25, 23, 0), "Estadio Nacional", 50.0),
                        new Event("Feria de Abril", "La feria más famosa de Sevilla.", LocalDateTime.of(2023, 4, 15, 12, 0), LocalDateTime.of(2023, 4, 22, 12, 0), "Sevilla", 0.0),
                        new Event("Festival de Cine", "Un festival de cine internacional.", LocalDateTime.of(2023, 10, 1, 10, 0), LocalDateTime.of(2023, 10, 10, 22, 0), "San Sebastián", 20.0),
                        new Event("Carnaval de Cádiz", "El carnaval más famoso de España.", LocalDateTime.of(2023, 2, 20, 12, 0), LocalDateTime.of(2023, 2, 28, 12, 0), "Cádiz", 0.0),
                        new Event("Nochevieja en Madrid", "Celebración de Nochevieja en la Puerta del Sol.", LocalDateTime.of(2023, 12, 31, 22, 0), LocalDateTime.of(2024, 1, 1, 2, 0), "Madrid", 0.0)
                ));
                System.out.println("Datos de eventos cargados.");
            }

            // Cargar datos de usuarios (solo si no hay usuarios en la base de datos)
            if (userRepository.count() == 0) {
                userRepository.saveAll(Arrays.asList(
                        new User("user1", "user1@example.com", passwordEncoder.encode("password123"), Role.USER),
                        new User("user2", "user2@example.com", passwordEncoder.encode("password456"), Role.USER),
                        new User("admin", "admin@example.com", passwordEncoder.encode("admin123"), Role.ADMIN)
                ));
                System.out.println("Datos de usuarios cargados.");
            }
        };
    }
}
