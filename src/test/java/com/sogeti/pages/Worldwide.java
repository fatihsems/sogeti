package com.sogeti.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Worldwide extends BasePage {

    @FindBy (xpath = "//span[@aria-label='Worldwide']")
    public WebElement worldwideDropdown;

    @FindBy(id = "country-list-id")
    public WebElement worldwideDropdownOpen;

    public void clickWorldwideDropdown() {

    clickMethodVisibilityOf(worldwideDropdown);

    }

    public void theUserShouldSeeCountries(){

        String actualWorldwideStyleValue = worldwideDropdownOpen.getAttribute("style");
        log.info(actualWorldwideStyleValue + " that means user able to see Countries list");
        Assert.assertTrue(actualWorldwideStyleValue.contains("block"));

    }

}
