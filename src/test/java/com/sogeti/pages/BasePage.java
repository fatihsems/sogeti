package com.sogeti.pages;

import com.sogeti.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Set;

public abstract class BasePage {

    Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void verifyThatTheUserIsOnTheSelectedPageWithPageTitle(String expectedTitle) {

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("Expected page Title :" + expectedTitle);

    }

    Actions actions = new Actions(Driver.get());

    public void mouseOverElementUsingActionsClass(WebElement element) {

        actions.moveToElement(element).build().perform();

    }

    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(5));

    public void clickMethodVisibilityOf(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element)).click();

    }

    public void sendMethodVisibilityOf(WebElement element, String text) {

        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);

    }

    public void clickCountryLink(String Country) {

        WebElement countryLink = Driver.get().findElement(By.xpath("//a[@title='" + Country + " (new window) (new window)']"));
        clickMethodVisibilityOf(countryLink);

    }

    public void checkTheNewWindowTitle(String pageTitle) {

        String currentWindowHandle = Driver.get().getWindowHandle();
        Set<String> windowHandles = Driver.get().getWindowHandles();
        for (
                String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                Driver.get().switchTo().window(handle);
            }
        }
        log.info("Title after switch new window: " + Driver.get().getTitle());
        Assert.assertTrue(Driver.get().getTitle().contains(pageTitle));

    }
}
