package Boutique.Hotel.App.repositories;

import Boutique.Hotel.App.enums.RoomType;
import Boutique.Hotel.App.models.entities.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class FilterRoomRepositoryImpl  implements FilterRoomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Room> findFilteredRooms(Integer roomNumber, RoomType roomType, Double price) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Room> cq = cb.createQuery(Room.class);
        Root<Room> roomRoot = cq.from(Room.class);
        List<Predicate> predicates = new ArrayList<>();

        if (roomNumber != null) {
            Path<Integer> roomNumberPath = roomRoot.get("roomNumber");
            predicates.add(cb.equal(roomNumberPath, roomNumber));
        }
        if (roomType != null) {
            predicates.add(cb.equal(roomRoot.get("roomType"), roomType));
        }
        if (price != null) {
            predicates.add(cb.equal(roomRoot.get("price"), price));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}