package com.villalta.turismoapi.service.poi;

import com.villalta.turismoapi.model.poi.PointOfInterest;
import com.villalta.turismoapi.repository.poi.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointOfInterestService {

    @Autowired
    private PointOfInterestRepository poiRepository;

    // Obtener todos los POIs
    public List<PointOfInterest> getAllPOIs() {
        return poiRepository.findAll();
    }

    // Obtener un POI por ID
    public PointOfInterest getPOIById(String id) {
        return poiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("POI no encontrado con id: " + id));
    }

    // Crear un nuevo POI
    public PointOfInterest createPOI(PointOfInterest poi) {
        return poiRepository.save(poi);
    }

    // Actualizar un POI existente
    public PointOfInterest updatePOI(String id, PointOfInterest poiDetails) {
        PointOfInterest poi = poiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("POI no encontrado con id: " + id));

        poi.setName(poiDetails.getName());
        poi.setDescription(poiDetails.getDescription());
        poi.setCategory(poiDetails.getCategory());
        poi.setLatitude(poiDetails.getLatitude());
        poi.setLongitude(poiDetails.getLongitude());

        return poiRepository.save(poi);
    }

    // Eliminar un POI
    public void deletePOI(String id) {
        poiRepository.deleteById(id);
    }

    // Buscar POIs por categoría
    public List<PointOfInterest> getPOIsByCategory(String category) {
        return poiRepository.findByCategory(category);
    }

    // Buscar POIs por nombre
    public List<PointOfInterest> getPOIsByName(String name) {
        return poiRepository.findByNameContainingIgnoreCase(name);
    }
}
