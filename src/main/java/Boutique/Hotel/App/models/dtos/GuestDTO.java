package Boutique.Hotel.App.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GuestDTO {

    private Long guestId;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 30, message = "must be between 2 and 30 characters")
    private String firstName;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 30, message = "must be between 2 and 30 characters")
    private String lastName;

    @Min(value = 0, message = "Age must not be less than 0")
    private int age;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Invalid email format")
    private String email;
}