package Boutique.Hotel.App.exceptions.amenity;

public class AmenityNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Amenity not found with id: ";

    public AmenityNotFoundException(Long amenityId) {
        super(DEFAULT_MESSAGE + amenityId);
    }
}