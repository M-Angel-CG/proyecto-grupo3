package com.example.proyectotesting.controller.mvc;

import com.example.proyectotesting.entities.Manufacturer;
import com.example.proyectotesting.service.ManufacturerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Tests de ManufacturerController")
public class ManufacturerControllerTest {

    @Autowired
    MockMvc mvc;
    ManufacturerService manufacturerservice;

    @Test
    @DisplayName("Tests de la función 'view'")
    void viewTest() throws Exception {
        mvc.perform(get("/manufacturers/1/view"))
                .andExpect(model().attributeExists("manufacturer"))
                .andExpect(forwardedUrl("/WEB-INF/views/manufacturer-view.jsp"));

        mvc.perform(get("/manufacturers/999/view"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/manufacturers"));
    }

    @Test
    @DisplayName("Tests de la función 'list'")
    void listTest() throws Exception {
        mvc.perform(get("/manufacturers")).andExpect(status().isOk())
                .andExpect(model().attributeExists("manufacturers"))
                .andExpect(forwardedUrl("/WEB-INF/views/manufacturer-list.jsp"));

        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturerservice = mock(ManufacturerService.class);

        when(manufacturerservice.findAll()).thenReturn(manufacturers);
    }

    @Test
    @DisplayName("Tests de la función 'loadForm'")
    void loadFormTest() throws Exception {
        manufacturerservice = mock(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Lorem Ipsum", "12345678A", 99, 1994);
        manufacturerservice.save(manufacturer);

        mvc.perform(get("/manufacturers/3/edit"))
                .andExpect(model().attributeExists("manufacturer"))
                .andExpect(model().attributeExists("products"))
                .andExpect(forwardedUrl("/WEB-INF/views/manufacturer-edit.jsp"));

        mvc.perform(get("/manufacturers/90/edit"))
                .andExpect(model().attributeExists("NOTIFICATION"))
                .andExpect(model().attributeExists("manufacturers"))
                .andExpect(forwardedUrl("/WEB-INF/views/manufacturer-list.jsp"));
    }

    @Test
    @DisplayName("Tests de la función 'showForm'")
    void showFormTest() throws Exception {
        mvc.perform(get("/manufacturers/new"))
                .andExpect(model().attributeExists("manufacturer"))
                .andExpect(model().attributeExists("products"))
                .andExpect(forwardedUrl("/WEB-INF/views/manufacturer-edit.jsp"));
    }

    @Test
    @DisplayName("Tests de la función 'save'")
    void saveTest() throws Exception {
        mvc.perform(post("/manufacturers"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/manufacturers"));
    }

    @Test
    @DisplayName("Tests de la función 'delete'")
    void deleteTest() throws Exception {
        mvc.perform(get("/manufacturers/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/manufacturers"));
    }
}
