package com.example.proyectotesting.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManufacturerListTest extends BaseTest{

    private static final String URL = "http://localhost:8080/manufacturers";

    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        driver.get(URL);
    }

    @Test
    @DisplayName("Titulo de la pagina")
    void CheckTitle() {
        assertEquals("Listado de fabricantes", driver.
        findElement(By.cssSelector("h1")).getText());
        assertEquals("Manufacturer List | Awesome App", driver.getTitle());

    }
    @Test
    @DisplayName("Elementos en la tabla")
    void checkTable() {
        driver.manage().window().maximize();
        assertEquals(3,
                driver.findElements(By.cssSelector(".table tr")).size());
    }

}
