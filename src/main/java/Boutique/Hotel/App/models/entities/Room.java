package Boutique.Hotel.App.models.entities;
import Boutique.Hotel.App.enums.RoomType;
import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "room_number")
    private int roomNumber;

    @Column(name = "room_type")
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "price")
    private Double price;

    @ManyToMany
    @JoinTable(name = "room_amenity",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private Set<Amenity> amenities = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
}