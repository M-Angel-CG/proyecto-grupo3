package com.example.proyectotesting.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    void setUp() {
        //String dir=System.getProperty("user.dir");
        String driverUrl="drivers\\chromedriver.exe";
        //String url=dir + driverUrl;
        System.setProperty("webdriver.chrome.driver",driverUrl);

       driver= new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}
