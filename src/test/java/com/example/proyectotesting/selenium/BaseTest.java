package com.example.proyectotesting.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    void setUp() {

        String os = System.getProperty("os.name");

        boolean isNix = (os.contains("nix")
                || os.contains("nux")
                || os.contains("aix"));

        if(isNix){
            System.out.println("Configurando Navegador Chrome Headless para CI");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            js = (JavascriptExecutor) driver;
        }else{
            System.out.println("Configurando Navegador Chrome desde carpeta drivers para testing en desarrollo");
            //String dir = System.getProperty("user.dir"); // ruta del proyecto
            String driverUrl = "drivers/chromedriver.exe";
            //String url = dir + driverUrl;
            System.setProperty("webdriver.chrome.driver", driverUrl);
            driver = new ChromeDriver(); // Google Chrome
            js = (JavascriptExecutor) driver;
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }



}
