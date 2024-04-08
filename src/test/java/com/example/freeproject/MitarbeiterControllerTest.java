package com.example.freeproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;


@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
class MitarbeiterControllerTest {

    @Autowired
    private MockMvc Mvc;

    @Autowired
    private MitarbeiterRepository mitarbeiterRepository;

    @Test
    void getAllMitarbeiter_shouldReturnEmptyList_whenCalled() throws Exception {
        Mvc.perform(MockMvcRequestBuilders.get("/api/mitarbeiter"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    void foreWorker_shouldDeleteEmployee_whenMitarbeiterIdIsCalled() throws Exception {
        Mitarbeiter mitarbeiter = new Mitarbeiter("test", 1, "test", 22, "nix");
        mitarbeiterRepository.save(mitarbeiter);

        Mvc.perform(MockMvcRequestBuilders.delete("/api/remove/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Mitarbeiter test wurde gefeuert!"));


    }
}