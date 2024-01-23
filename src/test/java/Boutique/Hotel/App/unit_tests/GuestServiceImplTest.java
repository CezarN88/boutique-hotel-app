package Boutique.Hotel.App.unit_tests;

import Boutique.Hotel.App.models.dtos.AmenityDTO;
import Boutique.Hotel.App.models.dtos.GuestDTO;
import Boutique.Hotel.App.models.entities.Guest;
import Boutique.Hotel.App.repositories.GuestRepository;
import Boutique.Hotel.App.services.guest.GuestService;
import Boutique.Hotel.App.services.guest.GuestServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class GuestServiceImplTest {

    @Mock
    private GuestRepository guestRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GuestServiceImpl guestService;

    @Test
    void testCreateGuest() {
        // GIVEN
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setFirstName("John");
        guestDTO.setLastName("Doe");
        guestDTO.setAge(28);
        guestDTO.setEmail("john@gmail.com");

        Guest guest = new Guest();
        guest.setFirstName("John");
        guest.setLastName("Doe");
        guest.setAge(28);
        guest.setEmail("john@gmail.com");

        when(modelMapper.map(guestDTO, Guest.class)).thenReturn(guest);
        when(guestRepository.save(guest)).thenReturn(guest);
        when(modelMapper.map(guest, GuestDTO.class)).thenReturn(guestDTO);

        // WHEN
        GuestDTO createdGuestDTO = guestService.createGuest(guestDTO);

        // THEN
        verify(guestRepository, times(1)).save(guest);
        assertEquals(guestDTO, createdGuestDTO);
    }
}