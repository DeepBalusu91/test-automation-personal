package com.example.StepDefs;

import com.example.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class LoginPageStepDef {

    WebDriver driver;

    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return result.toString();
    }

    @Given("I am on the Facebook login page")
    public void i_am_on_the_facebook_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login");
    }
    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        String randomUsername = generateRandomString(10);
        String randomPassword = generateRandomString(10);

        loginPage.enterUsername(randomUsername);
        Thread.sleep(1000);

        loginPage.enterPassword(randomPassword);
        Thread.sleep(1000);

        loginPage.clickLogin();
        Thread.sleep(1000);
    }
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMessage = driver.findElement(By.className("_9ay7"));
        Assert.assertTrue("Element should be visible", errorMessage.isDisplayed());        driver.quit();
    }
}
