package Boutique.Hotel.App.controllers;

import Boutique.Hotel.App.models.dtos.GuestDTO;
import Boutique.Hotel.App.models.dtos.RoomDTO;
import Boutique.Hotel.App.services.guest.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/{guestId}")
    public ResponseEntity<GuestDTO> getGuestById(@PathVariable Long guestId) {
        GuestDTO guest = guestService.getGuestById(guestId);
        return ResponseEntity.ok(guest);
    }

    @GetMapping
    public ResponseEntity<List<GuestDTO>> getAllGuests() {
        List<GuestDTO> guests = guestService.getAllGuests();
        return ResponseEntity.ok(guests);
    }

    @PostMapping
    public ResponseEntity<GuestDTO> createGuest(@RequestBody GuestDTO guestDTO) {
        GuestDTO createdGuest = guestService.createGuest(guestDTO);
        return ResponseEntity.ok(createdGuest);
    }

    @PutMapping("/{guestId}")
    public ResponseEntity<GuestDTO> updateGuest(@PathVariable Long guestId, @RequestBody GuestDTO guestDTO) {
        GuestDTO updatedGuest = guestService.updateGuest(guestId, guestDTO);
        return ResponseEntity.ok(updatedGuest);
    }

    @DeleteMapping("/{guestId}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long guestId) {
        guestService.deleteGuest(guestId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<GuestDTO>> searchGuests(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "email", required = false) String email) {
        return ResponseEntity.ok(guestService.searchGuests(firstName, age, email));
    }

    @PostMapping("/{guestId}/reserveRoom/{roomId}")
    public ResponseEntity<RoomDTO> reserveRoom(
            @PathVariable Long guestId,
            @PathVariable Long roomId) {
        RoomDTO roomDTO = guestService.reserveRoom(guestId, roomId);
        return ResponseEntity.ok(roomDTO);
    }
}