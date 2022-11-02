package com.sogeti.pages;

import com.github.javafaker.Faker;
import com.sogeti.utilities.BrowserUtils;
import com.sogeti.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class AutomationPage extends BasePage {

    @FindBy(className = "Form__Title")
    public WebElement contactUs;

    @FindBy(xpath = "//input[@name='__field_123927']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@name='__field_123938']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@name='__field_123928']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='__field_123929']")
    public WebElement phoneField;

    @FindBy(xpath = "//input[@name='__field_132738']")
    public WebElement companyField;

    @FindBy(xpath = "//select[@id='e74d82fb-949d-40e5-8fd2-4a876319c45a']")
    public WebElement countrySelect;

    @FindBy(xpath = "//textarea[@name='__field_123931']")
    public WebElement messageField;

    @FindBy(xpath = "//label[@for='__field_1239350']")
    public WebElement iAgree;

    @FindBy(xpath = "//*[@id=\"c0706cb4-c58d-4c20-835a-a327a013a48f\"]/div/div/div/iframe")
    public WebElement reCaptcha;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    public WebElement reCaptchaBox;

    @FindBy(id = "b35711ee-b569-48b4-8ec4-6476dbf61ef8")
    public WebElement submitButton;

    @FindBy(xpath = "//p[normalize-space()='Thank you for contacting us.']")
    public WebElement thankYou;

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String phone = faker.phoneNumber().phoneNumber();
    String company = faker.company().name();
    String message = faker.name().fullName();

    public void fillContactUs() {
        sendMethodVisibilityOf(firstNameField, firstName);

        sendMethodVisibilityOf(lastNameField, lastName);

        sendMethodVisibilityOf(emailField, firstName + "@randomemail.de");

        sendMethodVisibilityOf(phoneField, phone);

        sendMethodVisibilityOf(companyField, company);

        Select countryDropdown = new Select(countrySelect);
        Random rand = new Random();
        int countryIndex = rand.nextInt(41);
        countryDropdown.selectByIndex(countryIndex + 1);

        sendMethodVisibilityOf(messageField, message);

        log.info("Contact us form is filled ");

    }

    public void CheckTheIAgreeCheckbox() {

        clickMethodVisibilityOf(iAgree);

    }

    public void checkTheIAmNotARobotCheckbox() {

        BrowserUtils.waitFor(3);
        Driver.get().switchTo().frame(reCaptcha);
        clickMethodVisibilityOf(reCaptchaBox);
        Driver.get().switchTo().parentFrame();
        BrowserUtils.waitFor(10);
//      10 seconds delay is added in order to solve manually Captcha issue.
//      if needed you should answer the question in 10 seconds.
        log.info("Sometimes user need to answer reCAPTCHA question manually !!!");

    }

    public void clickSubmitButton() {

        clickMethodVisibilityOf(submitButton);
        log.info("if this step is FAILED, you need the answer reCAPTCHA question MANUALLY");

    }

    public void thankYouMessageIsDisplayed(){

        Assert.assertEquals("Thank you for contacting us.", thankYou.getText());

    }

}
