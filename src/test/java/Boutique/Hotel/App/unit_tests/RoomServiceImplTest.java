package Boutique.Hotel.App.unit_tests;

import Boutique.Hotel.App.enums.RoomType;
import Boutique.Hotel.App.models.dtos.RoomDTO;
import Boutique.Hotel.App.models.entities.Room;
import Boutique.Hotel.App.repositories.RoomRepository;
import Boutique.Hotel.App.services.room.RoomServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoomServiceImplTest {

    @Mock
    private RoomRepository roomRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private RoomServiceImpl roomService;

    @Test
    void testCreateRoom() {
        // GIVEN
        Room room = new Room();
        room.setRoomNumber(101);
        room.setRoomType(RoomType.SINGLE);
        room.setAvailability(true);
        room.setPrice(150.0);

        Room savedRoom = new Room();
        savedRoom.setRoomId(1L);
        savedRoom.setRoomNumber(101);
        savedRoom.setRoomType(RoomType.SINGLE);
        savedRoom.setAvailability(true);
        savedRoom.setPrice(150.0);

        RoomDTO roomdDTO = new RoomDTO();
        roomdDTO.setRoomNumber(101);
        roomdDTO.setRoomType(RoomType.SINGLE);
        roomdDTO.setAvailability(true);
        roomdDTO.setPrice(150.0);

        when(modelMapper.map(any(RoomDTO.class), eq(Room.class))).thenReturn(room);
        when(roomRepository.save(room)).thenReturn(savedRoom);
        when(modelMapper.map(any(Room.class), eq(RoomDTO.class))).thenReturn(roomdDTO);


        // WHEN
        RoomDTO savedRoomDTO = roomService.createRoom(roomdDTO);

        // THEN
        verify(roomRepository, times(1)).save(room);
        verify(modelMapper, times(1)).map(any(RoomDTO.class), eq(Room.class));
        verify(modelMapper, times(1)).map(any(Room.class), eq(RoomDTO.class));
        assertEquals(roomdDTO, savedRoomDTO);
    }
}