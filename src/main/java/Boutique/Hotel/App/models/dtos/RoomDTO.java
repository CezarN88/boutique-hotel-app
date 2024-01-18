package Boutique.Hotel.App.models.dtos;

import Boutique.Hotel.App.enums.RoomType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomDTO {

    private Long roomId;

    @NotBlank
    @Size(min = 1, max = 3, message = "must be between 1 and 3 characters")
    private int roomNumber;

    @NotBlank
    @Size(min = 2, max = 30, message = "must be between 2 and 30 characters")
    private RoomType roomType;

    private boolean availability;

    private Double price;
}