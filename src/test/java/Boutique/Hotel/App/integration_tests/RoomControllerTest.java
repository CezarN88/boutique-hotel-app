package Boutique.Hotel.App.integration_tests;

import Boutique.Hotel.App.enums.RoomType;
import Boutique.Hotel.App.models.dtos.RoomDTO;
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
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateRoomShouldPass() throws Exception {
        //GIVEN
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomNumber(102);
        roomDTO.setRoomType(RoomType.DOUBLE);
        roomDTO.setAvailability(true);
        roomDTO.setPrice(200.0);

        //WHEN
        MvcResult result = mockMvc.perform(post("/api/rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(roomDTO)))
                .andExpect(status().isOk())
                .andReturn();

        String resultAsString = result.getResponse().getContentAsString();
        RoomDTO roomDTOConverted = objectMapper.readValue(resultAsString, RoomDTO.class);

        //THEN
        assertEquals(roomDTO.getRoomNumber(), roomDTOConverted.getRoomNumber());
        assertEquals(roomDTO.getRoomType(), roomDTOConverted.getRoomType());
        assertEquals(roomDTO.isAvailability(), roomDTOConverted.isAvailability());
        assertEquals(roomDTO.getPrice(), roomDTOConverted.getPrice());
    }
}