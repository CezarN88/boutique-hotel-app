package Boutique.Hotel.App.integration_tests;

import Boutique.Hotel.App.models.dtos.GuestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase
public class GuestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateGuestShouldPass() throws Exception {
        //GIVEN
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setFirstName("Alice");
        guestDTO.setLastName("Smith");
        guestDTO.setAge(25);
        guestDTO.setEmail("alice.smith@example.com");

        //WHEN
        MvcResult result = mockMvc.perform(post("/api/guests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(guestDTO)))
                .andExpect(status().isOk())
                .andReturn();

        String resultAsString = result.getResponse().getContentAsString();
        GuestDTO guestDTOConverted = objectMapper.readValue(resultAsString, GuestDTO.class);

        //THEN
        assertEquals(guestDTO.getFirstName(), guestDTOConverted.getFirstName());
        assertEquals(guestDTO.getLastName(), guestDTOConverted.getLastName());
        assertEquals(guestDTO.getAge(), guestDTOConverted.getAge());
        assertEquals(guestDTO.getEmail(), guestDTOConverted.getEmail());
    }
}