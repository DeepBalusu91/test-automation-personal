package com.example.page;

import org.openqa.selenium.*;

import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "email")
    private WebElement userNameField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(css = "._42ft._4jy0._16jx._4jy6._4jy2.selected._51sy")
    private WebElement registrationButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions (methods) on the page
    public void enterUsername(String username) {
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public RegistrationPage clickRegistration() {
        registrationButton.click();
        return new RegistrationPage(driver);
    }

}
