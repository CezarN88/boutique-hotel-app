package Boutique.Hotel.App.services.amenity;

import Boutique.Hotel.App.models.dtos.AmenityDTO;

import java.util.List;

public interface AmenityService {

    AmenityDTO getAmenityById(Long amenityId);

    List<AmenityDTO> getAllAmenities();

    AmenityDTO createAmenity(AmenityDTO amenityDTO);

    AmenityDTO updateAmenity(Long amenityId, AmenityDTO amenityDTO);

    void deleteAmenity(Long amenityId);
}