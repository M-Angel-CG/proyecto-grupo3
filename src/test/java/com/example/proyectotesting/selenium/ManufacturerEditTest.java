package com.example.proyectotesting.selenium;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


public class ManufacturerEditTest extends BaseTest{


    private static final String URL = "http://localhost:8080/manufacturers/1/edit";



    @Test
    @DisplayName("Titulo del fabricante")
    void CheckTitleAdidasTextTest() {

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
    @DisplayName("Seleccionar producto del menu")
    void selectProduct() {

        driver.get(URL);

        WebElement input = driver.findElement(By.xpath("//option[@value='13']"));
        input.click();

        assertTrue(driver.findElement(By.xpath("//option[@value='13']")).isSelected());


    }
    public void scrollTo(WebElement element){
        js.executeScript("arguments[0].scrollIntoView();", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    @DisplayName("Seleccionar todos productos del menu")
    void SelectAllProducts(){

        driver.get(URL);
        driver.manage().window().maximize();

        List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"products\"]"));
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        scrollTo(button);

        for (WebElement option: options) {
            Actions action = new Actions(driver);
                action.keyDown(Keys.CONTROL).click(option).perform();
        }

        button.submit();

    }
}








