package com.example.proyectotesting.selenium;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


@Disabled
public class ManufacturerEditTest extends BaseTest{


    private static final String URL = "http://localhost:8080/manufacturers/1/edit";



    @Test
    @DisplayName("Titulo del fabricante")
    void CheckTitle() {

        driver.get(URL);

        assertEquals("Fabricante 1", driver.
                findElement(By.cssSelector("h2")).getText());
        assertEquals("Manufacturer Edition | Aswesome App", driver.getTitle());

    }

    @Test
    @DisplayName("Click boton guardar/salir ")
    void buttonSaveAndExit() {
        driver.get(URL);
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.submit();
        assertEquals("Manufacturer List | Awesome App", driver.getTitle());
    }


    @Test
    @DisplayName("Seleccionar todos productos del menu")
    void SelectAllProducts(){

        driver.get(URL);
        driver.manage().window().maximize();

        List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"products\"]"));
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));

        //metodo propio para hacer scroll y esperar
        scrollTo(button);

        for (WebElement option: options) {
            Actions action = new Actions(driver);
                action.keyDown(Keys.CONTROL).click(option).perform();
        }

        button.submit();

    }

    @Test
    @DisplayName("comprobar los titulos de el manufacturer")
    void Titles() {
        driver.get(URL);
        driver.manage().window().maximize();

        List<WebElement> data = driver.findElements(By.cssSelector("h2"));
        assertEquals("Fabricante 1",data.get(0).getText());
        List<WebElement> dataTitle = driver.findElements(By.cssSelector("h3"));
        assertEquals("Datos de fabricante",dataTitle.get(0).getText());
        assertEquals("Datos de dirección",dataTitle.get(1).getText());
        assertEquals("Productos disponibles",dataTitle.get(2).getText());
    }
}








