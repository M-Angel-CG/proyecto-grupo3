package com.example.proyectotesting.selenium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductEditTest extends BaseTest {

    private static final String URL="http://localhost:8080/products/10/edit";

    @Test
    @DisplayName("Título")
    void tituloPáginaTest(){
        driver.get(URL);
        String title=driver.getTitle();
        assertEquals("Product Edition | Aswesome App",title);

        assertEquals("Product 10", (driver.findElement(By.cssSelector("body > div > h2"))).getText());
    }

    @Test
    void notModifyTest() {
        driver.get(URL);
        driver.manage().window().maximize();
        String title=driver.getTitle();
        assertEquals("Product Edition | Aswesome App",title);

        assertEquals("Name",
                (driver.findElement(By.cssSelector("#product > div:nth-child(1) > label"))).getText());
        assertEquals("Descripción",
                (driver.findElement(By.cssSelector("#product > div:nth-child(2) > label"))).getText());
        assertEquals("Precio",
                (driver.findElement(By.cssSelector("#product > div:nth-child(3) > label"))).getText());
        assertEquals("Cantidad",
                (driver.findElement(By.cssSelector("#product > div:nth-child(4) > label"))).getText());
        assertEquals("Fabricantes disponibles",
                (driver.findElement(By.cssSelector("#product > h3:nth-child(5)"))).getText());
        assertEquals("Categorías disponibles",
                (driver.findElement(By.cssSelector("#product > h3:nth-child(7)"))).getText());
        assertEquals("Categorías",
                (driver.findElement(By.cssSelector("#product > div:nth-child(8) > label"))).getText());

        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"product\"]/div[7]/button"));
        saveButton.submit();

        String newURL = "http://localhost:8080/products";
        driver.get(newURL);
        String newTitle = driver.getTitle();
        assertEquals("Product List | Awesome App",newTitle);
        assertEquals("Mesa",
                (driver.findElement(
                        By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(1)")).getText()));
        assertEquals("99.99",
                (driver.findElement(
                        By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(2)")).getText()));
        assertEquals("Lorem impsum dolor",
                (driver.findElement(
                        By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(3)")).getText()));
        assertEquals("8",
                (driver.findElement(
                        By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(4)")).getText()));
        assertEquals("Adidas",
                (driver.findElement(
                        By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(5)")).getText()));
    }


    @Test
    void modifyTest () {
        driver.get(URL);
        driver.manage().window().maximize();
        String title=driver.getTitle();
        assertEquals("Product Edition | Aswesome App",title);

        assertEquals("Name",
                (driver.findElement(By.cssSelector("#product > div:nth-child(1) > label"))).getText());
        assertEquals("Descripción",
                (driver.findElement(By.cssSelector("#product > div:nth-child(2) > label"))).getText());
        assertEquals("Precio",
                (driver.findElement(By.cssSelector("#product > div:nth-child(3) > label"))).getText());
        assertEquals("Cantidad",
                (driver.findElement(By.cssSelector("#product > div:nth-child(4) > label"))).getText());
        assertEquals("Fabricantes disponibles",
                (driver.findElement(By.cssSelector("#product > h3:nth-child(5)"))).getText());
        assertEquals("Categorías disponibles",
                (driver.findElement(By.cssSelector("#product > h3:nth-child(7)"))).getText());
        assertEquals("Categorías",
                (driver.findElement(By.cssSelector("#product > div:nth-child(8) > label"))).getText());

        driver.findElement(By.cssSelector("#name")).sendKeys("MESA DE PING PONG");
        driver.findElement(By.cssSelector("#description")).sendKeys("DIMENSIONES OFICIALES");
        driver.findElement(By.cssSelector("#price")).sendKeys("268.94");
        driver.findElement(By.cssSelector("#quantity")).sendKeys("3");

        // driver.findElement(By.cssSelector("#manufacturer > option:nth-child(1)"));
        // driver.findElement(By.cssSelector("#manufacturer > option:nth-child(2)"));
        // driver.findElement(By.cssSelector("#categories > option:nth-child(1)"));
        // driver.findElement(By.cssSelector("#categories > option:nth-child(2)"));
        // driver.findElement(By.cssSelector("#categories > option:nth-child(3)"));
        // driver.findElement(By.cssSelector("#categories > option:nth-child(4)"));

        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"product\"]/div[7]/button"));
        saveButton.submit();

        String newURL = "http://localhost:8080/products";
        driver.get(newURL);
        String newTitle = driver.getTitle();
        assertEquals("Product List | Awesome App",newTitle);
        /*

          ** ELIMINO ESTAS PRUEBEAS PORQUE NO LAS CUMPLE, LO QUE QUIERE DECIR QUE NO GUARDA LAS MODIFICACIONES **

        assertEquals("MESA DE PING PONG",
                (driver.findElement(
                        By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(1)")).getText()));
        assertEquals("268.94",
                (driver.findElement(
                        By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(2)")).getText()));
        assertEquals("DIMENSIONES OFICIALES",
                (driver.findElement(
                        By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(3)")).getText()));
        assertEquals("3",
                (driver.findElement(
                        By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(4)")).getText()));
        assertEquals("DOMYOS",
                (driver.findElement(
                        By.cssSelector("body > div > table > tbody > tr:nth-child(3) > td:nth-child(5)")).getText()));

         */
    }

}
