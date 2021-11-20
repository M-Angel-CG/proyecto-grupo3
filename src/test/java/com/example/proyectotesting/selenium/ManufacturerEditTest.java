package com.example.proyectotesting.selenium;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class ManufacturerEditTest extends BaseTest{

    private static final String URL="http://localhost:8080/products";

    @Test
    @DisplayName("Titulo Manufacturer")
    void Titulotest(){

        driver.get(URL);
        String title=driver.getTitle();
        assertEquals("Product List | Awesome App",title);
    }
}








