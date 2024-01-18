package Boutique.Hotel.App.services.amenity;

import Boutique.Hotel.App.exceptions.amenity.AmenityNotFoundException;
import Boutique.Hotel.App.models.dtos.AmenityDTO;
import Boutique.Hotel.App.models.entities.Amenity;
import Boutique.Hotel.App.repositories.AmenityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmenityServiceImpl implements AmenityService {

    private final AmenityRepository amenityRepository;
    private final ModelMapper modelMapper;

    public AmenityServiceImpl(AmenityRepository amenityRepository, ModelMapper modelMapper) {
        this.amenityRepository = amenityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AmenityDTO getAmenityById(Long amenityId) {
        Amenity amenity = amenityRepository.findById(amenityId)
                .orElseThrow(() -> new AmenityNotFoundException(amenityId));
        return modelMapper.map(amenity, AmenityDTO.class);
    }

    @Override
    public List<AmenityDTO> getAllAmenities() {
        List<Amenity> amenities = amenityRepository.findAll();
        return amenities.stream()
                .map(amenity -> modelMapper.map(amenity, AmenityDTO.class))
                .toList();
    }

    @Override
    public AmenityDTO createAmenity(AmenityDTO amenityDTO) {
        Amenity amenity = modelMapper.map(amenityDTO, Amenity.class);
        Amenity savedAmenity = amenityRepository.save(amenity);
        return modelMapper.map(savedAmenity, AmenityDTO.class);
    }

    @Override
    public AmenityDTO updateAmenity(Long amenityId, AmenityDTO amenityDTO) {
        Amenity existingAmenity = amenityRepository.findById(amenityId)
                .orElseThrow(() -> new AmenityNotFoundException(amenityId));
        modelMapper.map(amenityDTO, existingAmenity);
        Amenity updatedAmenity = amenityRepository.save(existingAmenity);
        return modelMapper.map(updatedAmenity, AmenityDTO.class);
    }

    @Override
    public void deleteAmenity(Long amenityId) {
        Amenity amenity = amenityRepository.findById(amenityId)
                .orElseThrow(() -> new AmenityNotFoundException(amenityId));
        amenityRepository.delete(amenity);
    }
}