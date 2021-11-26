package com.example.proyectotesting.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManufacturerViewTest extends BaseTest {

    private static final String URL = "http://localhost:8080/manufacturers/1/view";

    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        driver.get(URL);
    }

    @Test
    @DisplayName("Tests de los titulos de la página")
    void checkTitle() {
        assertEquals("Fabricante 1",
                driver.findElement(By.cssSelector("h2")).getText());

        assertEquals("Manufacturer View | Aswesome App", driver.getTitle());
    }

    @Disabled
    @Test
    @DisplayName("Test de parámetros de la página")
    void checkParams() {
        assertEquals("Nombre: Adidas",
                driver.findElement(By.cssSelector("div > p:nth-child(1)")).getText());

        assertEquals("CIF: 2343235325G",
                driver.findElement(By.cssSelector("div > p:nth-child(2)")).getText());

        assertEquals("Nº Empleados: 60000",
                driver.findElement(By.cssSelector("div > p:nth-child(3)")).getText());

        assertEquals("Año: 1949",
                driver.findElement(By.cssSelector("div > p:nth-child(4)")).getText());

        assertEquals("Dirección",
                driver.findElement(By.cssSelector("div > h3:nth-child(5)")).getText());

        assertEquals("Calle: Calle falsa",
                driver.findElement(By.cssSelector("div > p:nth-child(6)")).getText());

        assertEquals("Código postal: 33010",
                driver.findElement(By.cssSelector("div > p:nth-child(7)")).getText());

        assertEquals("Ciudad: León",
                driver.findElement(By.cssSelector("div > p:nth-child(8)")).getText());

        assertEquals("País: Spain",
                driver.findElement(By.cssSelector("div > p:nth-child(9)")).getText());

        assertEquals("Productos fabricados",
                driver.findElement(By.cssSelector("div > h3:nth-child(10)")).getText());
    }

    @Disabled
    @Test
    @DisplayName("Test del botón 'Volver'")
    void checkReturnButton() {
        List<WebElement> returnButton = driver.findElements(By.className("btn-info"));
        returnButton.get(0).click();

        assertEquals("Manufacturer List | Awesome App"
                , driver.getTitle());
    }

    @Test
    @DisplayName("Test del botón 'Editar'")
    void checkEditButton() {
        List<WebElement> editButton = driver.findElements(By.className("btn-success"));
        editButton.get(0).click();

        assertEquals("Manufacturer Edition | Aswesome App"
                , driver.getTitle());
    }

    @Disabled
    @Test
    @DisplayName("Test del botón 'Crear producto'")
    void checkCreateProductButton() {
        List<WebElement> createButton = driver.findElements(By.className("btn-info"));
        createButton.get(1).click();

        assertEquals("Product Edition | Aswesome App"
                , driver.getTitle());
    }

    @Test
    @DisplayName("Test del botón 'Borrar'")
    void checkDeleteButton() {
        List<WebElement> deleteButton = driver.findElements(By.className("btn-danger"));
        deleteButton.get(0).click();

        assertEquals("Manufacturer List | Awesome App"
                , driver.getTitle());
    }
}
