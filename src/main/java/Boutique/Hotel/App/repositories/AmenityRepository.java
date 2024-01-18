package Boutique.Hotel.App.repositories;

import Boutique.Hotel.App.models.entities.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity,Long> {

}
