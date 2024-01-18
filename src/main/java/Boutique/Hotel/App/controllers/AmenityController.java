package Boutique.Hotel.App.controllers;

import Boutique.Hotel.App.models.dtos.AmenityDTO;
import Boutique.Hotel.App.services.amenity.AmenityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
public class AmenityController {

    private AmenityService amenityService;

    public AmenityController(AmenityService amenityService) {
        this.amenityService = amenityService;
    }

    @GetMapping("/{amenityId}")
    public ResponseEntity<AmenityDTO> getAmenityById(@PathVariable Long amenityId) {
        AmenityDTO amenity = amenityService.getAmenityById(amenityId);
        return ResponseEntity.ok(amenity);
    }

    @GetMapping
    public ResponseEntity<List<AmenityDTO>> getAllAmenities() {
        List<AmenityDTO> amenities = amenityService.getAllAmenities();
        return ResponseEntity.ok(amenities);
    }

    @PostMapping
    public ResponseEntity<AmenityDTO> createAmenity(@RequestBody AmenityDTO amenityDTO) {
        AmenityDTO createdAmenity = amenityService.createAmenity(amenityDTO);
        return ResponseEntity.ok(createdAmenity);
    }

    @PutMapping("/{amenityId}")
    public ResponseEntity<AmenityDTO> updateAmenity(@PathVariable Long amenityId, @RequestBody AmenityDTO amenityDTO) {
        AmenityDTO updatedAmenity = amenityService.updateAmenity(amenityId, amenityDTO);
        return ResponseEntity.ok(updatedAmenity);
    }

    @DeleteMapping("/{amenityId}")
    public ResponseEntity<Void> deleteAmenity(@PathVariable Long amenityId) {
        amenityService.deleteAmenity(amenityId);
        return ResponseEntity.noContent().build();
    }
}