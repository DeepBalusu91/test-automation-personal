package com.example;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppiumTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        // Set up desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "sdk_gphone64_x86_64"); // Your device or emulator name
        capabilities.setCapability("platformName", "Android");        // Platform name (Android)
        capabilities.setCapability("appPackage", "com.android.chrome"); // App package (calculator)
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main"); // App activity

        // Initialize the driver (Appium server should be running at this point)
        driver = new AndroidDriver(new URL("http://10.186.91.10:4723"), capabilities);
    }

    @Test
    public void testCalculator() {
        // Find the button with ID and click on it (e.g., "5")
        WebElement element = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        element.click();

        // Add some assertion to validate test results
        assertTrue(element.isDisplayed(), "Digit 5 should be visible on the screen.");
    }

    @AfterEach
    public void tearDown() {
        // Close the session after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
