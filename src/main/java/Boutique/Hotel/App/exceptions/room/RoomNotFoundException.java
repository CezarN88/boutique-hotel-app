package Boutique.Hotel.App.exceptions.room;

public class RoomNotFoundException extends RuntimeException {


    private static final String DEFAULT_MESSAGE = "Room not found with id: ";
    public RoomNotFoundException(Long roomId) {
        super(DEFAULT_MESSAGE + roomId);
    }
}