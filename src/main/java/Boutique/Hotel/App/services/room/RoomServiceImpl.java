package Boutique.Hotel.App.services.room;

import Boutique.Hotel.App.enums.RoomType;
import Boutique.Hotel.App.exceptions.room.RoomNotFoundException;
import Boutique.Hotel.App.exceptions.room.RoomUnavailableException;
import Boutique.Hotel.App.models.dtos.RoomDTO;
import Boutique.Hotel.App.models.entities.Guest;
import Boutique.Hotel.App.models.entities.Room;
import Boutique.Hotel.App.repositories.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

    public RoomServiceImpl(RoomRepository roomRepository, ModelMapper modelMapper) {
        this.roomRepository = roomRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoomDTO getRoomById(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));
        return modelMapper.map(room, RoomDTO.class);
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(room -> modelMapper.map(room, RoomDTO.class))
                .toList();
    }

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room room = modelMapper.map(roomDTO, Room.class);
        Room savedRoom = roomRepository.save(room);
        return modelMapper.map(savedRoom, RoomDTO.class);
    }

    @Override
    public RoomDTO updateRoom(Long roomId, RoomDTO roomDTO) {
        Room existingRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));
        modelMapper.map(roomDTO, existingRoom);
        Room updatedRoom = roomRepository.save(existingRoom);
        return modelMapper.map(updatedRoom, RoomDTO.class);
    }

    @Override
    public void deleteRoom(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));
        roomRepository.delete(room);
    }

    @Override
    public List<RoomDTO> searchRooms(Integer roomNumber, RoomType roomType, Double price) {
        List<Room> rooms = roomRepository.findByRoomNumberAndRoomTypeAndPrice(roomNumber, roomType, price);
        return rooms.stream()
                .map(room -> modelMapper.map(room, RoomDTO.class))
                .toList();
    }

    @Override
    public RoomDTO markRoomAsReserved(Long roomId, Guest guest) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException(roomId));

        if (room.isAvailability()) {
            room.setGuest(guest);
            room.setAvailability(false);
            Room updatedRoom = roomRepository.save(room);
            return modelMapper.map(updatedRoom, RoomDTO.class);
        } else {
            throw new RoomUnavailableException(roomId);
        }
    }
}