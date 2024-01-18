package Boutique.Hotel.App.exceptions;

import Boutique.Hotel.App.exceptions.amenity.AmenityNotFoundException;
import Boutique.Hotel.App.exceptions.guest.GuestNotFoundException;
import Boutique.Hotel.App.exceptions.room.RoomNotFoundException;
import Boutique.Hotel.App.exceptions.room.RoomUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RoomUnavailableException.class)
    public ResponseEntity<String> handleRoomUnavailable(RoomUnavailableException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<String> handleRoomNotFound(RoomNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GuestNotFoundException.class)
    public ResponseEntity<String> handleGuestNotFound(GuestNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AmenityNotFoundException.class)
    public ResponseEntity<String> handleAmenityNotFound(AmenityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}