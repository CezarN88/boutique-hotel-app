package Boutique.Hotel.App.unit_tests;

import Boutique.Hotel.App.enums.AmenityType;
import Boutique.Hotel.App.models.dtos.AmenityDTO;
import Boutique.Hotel.App.models.entities.Amenity;
import Boutique.Hotel.App.repositories.AmenityRepository;
import Boutique.Hotel.App.services.amenity.AmenityServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AmenityServiceImplTest {

    @Mock
    private AmenityRepository amenityRepository;
    private ModelMapper modelMapper;

    @InjectMocks
    private AmenityServiceImpl amenityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper = new ModelMapper();
        amenityService = new AmenityServiceImpl(amenityRepository, modelMapper);
    }

    @Test
    void testCreateAmenity () {
        //GIVEN
        AmenityDTO amenityDTO = new AmenityDTO();
        amenityDTO.setAmenityType(AmenityType.SPA);
        amenityDTO.setDescription("Luxury Spa");

        Amenity amenity = new Amenity();
        amenity.setAmenityType(AmenityType.SPA);
        amenity.setDescription("Luxury Spa");

        when(amenityRepository.save(any(Amenity.class))).thenReturn(amenity);

        //WHEN
        AmenityDTO createdAmenity = amenityService.createAmenity(amenityDTO);

        //THEN
        assertNotNull(createdAmenity);
        assertEquals(AmenityType.SPA, createdAmenity.getAmenityType());
        assertEquals("Luxury Spa", createdAmenity.getDescription());
    }
}