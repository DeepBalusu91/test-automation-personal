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

}
