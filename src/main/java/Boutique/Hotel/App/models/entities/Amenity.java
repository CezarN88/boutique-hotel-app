package Boutique.Hotel.App.models.entities;

import Boutique.Hotel.App.enums.AmenityType;
import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "amenities")
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amenity_id")
    private Long amenityId;

    @Enumerated(EnumType.STRING)
    @Column(name = "amenity_type")
    private AmenityType amenityType;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "amenities")
    private Set<Room> rooms = new HashSet<>();

}