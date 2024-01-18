package Boutique.Hotel.App.services.guest;

import Boutique.Hotel.App.models.dtos.GuestDTO;
import Boutique.Hotel.App.models.dtos.RoomDTO;

import java.util.List;

public interface GuestService {
    GuestDTO getGuestById(Long guestId);

    List<GuestDTO> getAllGuests();

    GuestDTO createGuest(GuestDTO guestDTO);

    GuestDTO updateGuest(Long guestId, GuestDTO guestDTO);

    void deleteGuest(Long guestId);

    List<GuestDTO> searchGuests(String firstName, Integer age, String email);

    RoomDTO reserveRoom(Long guestId, Long roomId);

}