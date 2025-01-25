package com.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SeleniumTest {
    private WebDriver driver;

     public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return result.toString();
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().browserVersion("131").setup();

        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleHomePage() {
        driver.get("https://www.google.com");
        String pageTitle = driver.getTitle();
        assertEquals("Google", pageTitle);
    }

    @Test
    public void testFacebookLoginPage() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Thread.sleep(1000);

        WebElement usernameField = driver.findElement(By.id("email"));
        usernameField.sendKeys(generateRandomString(10));
        Thread.sleep(5000);

        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys(generateRandomString(10));
        Thread.sleep(5000);

        passwordField.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
