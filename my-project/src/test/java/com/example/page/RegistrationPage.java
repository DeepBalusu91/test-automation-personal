package com.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    WebDriver driver;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(css = "input[type='radio'][name='sex'][value='2']")
    private WebElement gender;

    @FindBy(name = "birthday_month")
    private WebElement birthDayMonth;

    @FindBy(name = "birthday_day")
    private WebElement birthDay;

    @FindBy(name = "birthday_year")
    private WebElement birthDayYear;

    @FindBy(name = "reg_email__")
    private WebElement regEmail;

    @FindBy(name = "reg_passwd__")
    private WebElement regPassword;

    @FindBy(name = "websubmit")
    private WebElement signUp;


    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SelectBirthMonth(String monthValue)
    {
        Select dropdown = new Select(birthDayMonth);
        dropdown.selectByValue(monthValue);
    }

    public void SelectBirthDate(String dayValue)
    {
        Select dropdown = new Select(birthDay);
        dropdown.selectByValue(dayValue);
    }

    public void SelectBirthYear(String yearValue)
    {
        Select dropdown = new Select(birthDayYear);
        dropdown.selectByValue(yearValue);
    }

    public void enterFirstName(String firstNameValue)
    {
        firstName.sendKeys(firstNameValue);
    }

    public void enterLastName(String lastNameValue)
    {
        lastName.sendKeys(lastNameValue);
    }

    public void selectGender()
    {
        gender.click();
    }

    public void enterEmail(String emailValue)
    {
        regEmail.sendKeys(emailValue);
    }

    public void enterPassword(String passValue)
    {
        regPassword.sendKeys(passValue);
    }

    public void clickSignUp()
    {
        signUp.click();
    }
}
