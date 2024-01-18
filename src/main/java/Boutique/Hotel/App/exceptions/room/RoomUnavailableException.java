package Boutique.Hotel.App.exceptions.room;

public class RoomUnavailableException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Room is unavailable for reservation with id: ";

    public RoomUnavailableException(Long roomId) {
        super(DEFAULT_MESSAGE + roomId);
    }
}