package Boutique.Hotel.App.integration_tests;

import Boutique.Hotel.App.enums.AmenityType;
import Boutique.Hotel.App.models.dtos.AmenityDTO;
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
@Slf4j
@Transactional
@AutoConfigureTestDatabase
public class AmenityControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateAmenityShouldPass() throws Exception {
        //GIVEN
        AmenityDTO amenityDTO = new AmenityDTO();
        amenityDTO.setAmenityType(AmenityType.GYM.GYM);
        amenityDTO.setDescription("Fully-equipped gym");
        //WHEN
        MvcResult result = mockMvc.perform(post("/api/amenities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(amenityDTO)))
                .andExpect(status().isOk())
                .andReturn();

        String resultAsString = result.getResponse().getContentAsString();
        AmenityDTO amenityDTOConverted = objectMapper.readValue(resultAsString, AmenityDTO.class);

        log.info("AmenityDTO result:" + amenityDTOConverted);
        //THEN
        assertEquals(amenityDTO.getAmenityType(), amenityDTOConverted.getAmenityType());
        assertEquals(amenityDTO.getDescription(), amenityDTOConverted.getDescription());
    }
}