package Boutique.Hotel.App.repositories;

import Boutique.Hotel.App.models.entities.Guest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class FilterGuestRepositoryImpl implements FilterGuestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Guest> findFilteredGuests(Integer age, String city, String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Guest> cq = cb.createQuery(Guest.class);

        Root<Guest> guestRoot = cq.from(Guest.class);
        List<Predicate> predicates = new ArrayList<>();

        if (age != null) {
            Path<Integer> agePath = guestRoot.get("age");
            predicates.add(cb.equal(agePath, age));
        }
        if (city != null) {
            predicates.add(cb.equal(guestRoot.get("city"), city));
        }
        if (email != null) {
            predicates.add(cb.equal(guestRoot.get("email"), email));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}