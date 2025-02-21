package com.villalta.turismoapi.controller.poi;

import com.villalta.turismoapi.model.poi.PointOfInterest;
import com.villalta.turismoapi.service.poi.PointOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pois")
public class PointOfInterestController {

    @Autowired
    private PointOfInterestService poiService;

    // Obtener todos los POIs
    @GetMapping
    public List<PointOfInterest> getAllPOIs() {
        return poiService.getAllPOIs();
    }

    // Obtener un POI por ID
    @GetMapping("/{id}")
    public PointOfInterest getPOIById(@PathVariable String id) {
        return poiService.getPOIById(id);
    }

    // Crear un nuevo POI
    @PostMapping
    public PointOfInterest createPOI(@RequestBody PointOfInterest poi) {
        return poiService.createPOI(poi);
    }

    // Actualizar un POI existente
    @PutMapping("/{id}")
    public PointOfInterest updatePOI(@PathVariable String id, @RequestBody PointOfInterest poiDetails) {
        return poiService.updatePOI(id, poiDetails);
    }

    // Eliminar un POI
    @DeleteMapping("/{id}")
    public void deletePOI(@PathVariable String id) {
        poiService.deletePOI(id);
    }

    // Buscar POIs por categoría
    @GetMapping("/category/{category}")
    public List<PointOfInterest> getPOIsByCategory(@PathVariable String category) {
        return poiService.getPOIsByCategory(category);
    }

    // Buscar POIs por nombre
    @GetMapping("/search")
    public List<PointOfInterest> getPOIsByName(@RequestParam String name) {
        return poiService.getPOIsByName(name);
    }
}
