package Boutique.Hotel.App.services.room;

import Boutique.Hotel.App.enums.RoomType;
import Boutique.Hotel.App.models.dtos.RoomDTO;
import Boutique.Hotel.App.models.entities.Guest;

import java.util.List;

public interface RoomService {

    RoomDTO getRoomById(Long roomId);

    List<RoomDTO> getAllRooms();

    RoomDTO createRoom(RoomDTO roomDTO);

    RoomDTO updateRoom(Long roomId, RoomDTO roomDTO);

    void deleteRoom(Long roomId);
    List<RoomDTO> getFilteredRooms(Integer roomNumber, RoomType roomType, Double price);
    RoomDTO markRoomAsReserved(Long roomId, Guest guest);
}