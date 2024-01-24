package Boutique.Hotel.App.repositories;

import Boutique.Hotel.App.models.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>, FilterGuestRepository {

}