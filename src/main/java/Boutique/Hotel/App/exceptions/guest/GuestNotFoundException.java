package Boutique.Hotel.App.exceptions.guest;

public class GuestNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Guest not found with id: ";

    public GuestNotFoundException(Long guestId) {
        super(DEFAULT_MESSAGE + guestId);
    }
}