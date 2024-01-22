package Boutique.Hotel.App.repositories;

import Boutique.Hotel.App.enums.RoomType;
import Boutique.Hotel.App.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>, FilterRoomRepository {

    List<Room> findByRoomNumberAndRoomTypeAndPrice(Integer roomNumber, RoomType roomType, Double price);
}