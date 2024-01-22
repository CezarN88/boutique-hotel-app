package Boutique.Hotel.App.repositories;

import Boutique.Hotel.App.enums.RoomType;
import Boutique.Hotel.App.models.entities.Room;

import java.util.List;

public interface FilterRoomRepository {

    List<Room> findFilteredRooms(Integer roomNumber, RoomType roomType, Double price);
}
