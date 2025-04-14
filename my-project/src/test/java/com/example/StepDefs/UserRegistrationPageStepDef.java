package com.example.StepDefs;

import com.example.page.LoginPage;
import com.example.page.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class UserRegistrationPageStepDef {

    WebDriver driver;
    RegistrationPage registrationPage;

    @Given("I am on facebook page")
    public void i_am_on_facebook_page() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login");

    }
    @Given("I click on registration button")
    public void i_click_on_registration_button() {
        LoginPage loginPage = new LoginPage(driver);
        registrationPage =loginPage.clickRegistration();
    }
    @When("I try to half fill in the details")
    public void i_try_to_half_fill_in_the_details() throws InterruptedException {
        registrationPage.enterFirstName("Sample");
        Thread.sleep(1000);
        registrationPage.enterLastName("Data");
        Thread.sleep(1000);
        registrationPage.SelectBirthDate("12");
        Thread.sleep(1000);
        registrationPage.SelectBirthMonth("12");
        Thread.sleep(1000);
        registrationPage.SelectBirthYear("1991");
        Thread.sleep(1000);
        registrationPage.selectGender();
        Thread.sleep(1000);
        registrationPage.enterEmail("dummy@dummy.com");
        Thread.sleep(1000);
        registrationPage.enterPassword("SampleData");
        Thread.sleep(1000);
        registrationPage.clickSignUp();

    }
    @Then("User registration fails")
    public void user_registration_fails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("reg_error_inner"))
        );
        assertTrue("Error element is  displayed", errorElement.isDisplayed());
    }
}
