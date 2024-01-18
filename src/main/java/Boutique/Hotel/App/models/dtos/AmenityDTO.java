package Boutique.Hotel.App.models.dtos;

import Boutique.Hotel.App.enums.AmenityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AmenityDTO {

    private Long amenityId;

    @NotBlank
    @Size(min = 2, max = 30, message = "must be between 2 and 30 characters")
    private AmenityType amenityType;

    @NotBlank
    @Size(min = 2, max = 250, message = "must be between 2 and 250 characters")
    private String description;
}