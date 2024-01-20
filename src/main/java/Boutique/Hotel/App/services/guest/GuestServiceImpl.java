package Boutique.Hotel.App.services.guest;

import Boutique.Hotel.App.exceptions.guest.GuestNotFoundException;
import Boutique.Hotel.App.models.dtos.GuestDTO;
import Boutique.Hotel.App.models.dtos.RoomDTO;
import Boutique.Hotel.App.models.entities.Guest;
import Boutique.Hotel.App.repositories.GuestRepository;
import Boutique.Hotel.App.services.room.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;
    private final RoomService roomService;
    private final ModelMapper modelMapper;

    public GuestServiceImpl(GuestRepository guestRepository, RoomService roomService, ModelMapper modelMapper) {
        this.guestRepository = guestRepository;
        this.roomService = roomService;
        this.modelMapper = modelMapper;
    }

    @Override
    public GuestDTO getGuestById(Long guestId) {
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new GuestNotFoundException(guestId));
        return modelMapper.map(guest, GuestDTO.class);
    }

    @Override
    public List<GuestDTO> getAllGuests() {
        List<Guest> guests = guestRepository.findAll();
        return guests.stream()
                .map(guest -> modelMapper.map(guest, GuestDTO.class))
                .toList();
    }

    @Override
    public GuestDTO createGuest(GuestDTO guestDTO) {
        Guest guest = modelMapper.map(guestDTO, Guest.class);
        Guest savedGuest = guestRepository.save(guest);
        return modelMapper.map(savedGuest, GuestDTO.class);
    }

    @Override
    public GuestDTO updateGuest(Long guestId, GuestDTO guestDTO) {
        Guest existingGuest = guestRepository.findById(guestId)
                .orElseThrow(() -> new GuestNotFoundException(guestId));
        modelMapper.map(guestDTO, existingGuest);
        Guest updatedGuest = guestRepository.save(existingGuest);
        return modelMapper.map(updatedGuest, GuestDTO.class);
    }

    @Override
    public void deleteGuest(Long guestId) {
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new GuestNotFoundException(guestId));
        guestRepository.delete(guest);
    }

    @Override
    public List<GuestDTO> getFilteredGuests(Integer age, String city, String email) {
        List<Guest> guests = guestRepository.findFilteredGuests(age, city, email);

        return guests.stream()
                .map(guest -> modelMapper.map(guest, GuestDTO.class))
                .toList();
    }

    @Override
    public RoomDTO reserveRoom(Long guestId, Long roomId) {
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new GuestNotFoundException(guestId));

        return roomService.markRoomAsReserved(roomId, guest);
    }
}