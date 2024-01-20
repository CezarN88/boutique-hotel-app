package Boutique.Hotel.App.repositories;

import Boutique.Hotel.App.models.entities.Guest;

import java.util.List;

public interface FilterGuestRepository {

    List<Guest> findFilteredGuests(Integer age, String city, String email);
}
