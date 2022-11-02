package com.sogeti.pages;

import com.sogeti.utilities.BrowserUtils;
import com.sogeti.utilities.ConfigurationReader;
import com.sogeti.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".acceptCookie")
    public WebElement allowAllCookies;

    @FindBy(xpath = "(//span[contains(text(),'Services')])[1]")
    public WebElement services;

    @FindBy(xpath = "//a[contains(@class,'subMenuLink')][normalize-space()='Automation']")
    public WebElement automation;

    @FindBy(xpath = "//span[normalize-space()='Automation']")
    public WebElement textOnPage;

    @FindBy(xpath = "//li[contains(@class,'selected has-children')]")
    public WebElement mainMenuSelected;

    @FindBy(xpath = "(//li[contains(@class,'current expanded')])[1]")
    public WebElement subMenuSelected;

    public void gotoHomePage() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        allowAllCookies.click();

        log.info("The user is on the Home Page");

    }

    public void HoverOverMainLinkAndClickTheSubLink(String goMainLink, String goSubLink) {

        WebElement mainLink = Driver.get().findElement(By.xpath("(//span[contains(text(),'" + goMainLink + "')])[1]"));
        WebElement subLink = Driver.get().findElement(By.xpath("//a[contains(@class,'subMenuLink')][normalize-space()='" + goSubLink + "']"));

        mouseOverElementUsingActionsClass(mainLink);
        mouseOverElementUsingActionsClass(subLink);
        clickMethodVisibilityOf(subLink);

    }

    public void verifyTextOnPage(String pageText) {

        WebElement actualText = Driver.get().findElement(By.xpath("//span[normalize-space()='" + pageText + "']"));
        System.out.println(actualText);
        Assert.assertEquals(pageText, actualText.getText());

    }

    public void verifyThatThaMainMenuAndTheSubMenuAreSelected() {

        Assert.assertTrue(mainMenuSelected.isEnabled());
        Assert.assertTrue(subMenuSelected.isEnabled());
        String actualClassText = mainMenuSelected.getAttribute("class");
        System.out.println(actualClassText);

    }

    public void verifyThatThaMainMenuAndTheSubMenuAreSelected(String mainLink, String subLink) {

        BrowserUtils.waitFor(2);

        WebElement mainMenu = Driver.get().findElement(By.xpath("(//li[contains(.,'" + mainLink + "')])[1]"));
        WebElement subMenu = Driver.get().findElement(By.xpath("(//li[contains(.,'" + subLink + "')])[1]"));

        BrowserUtils.waitFor(2);

        String mainMenuClassValue = mainMenu.getAttribute("class");
        String subMenuClassValue = subMenu.getAttribute("class");

        System.out.println("Main Menu = " + mainMenuClassValue);
        System.out.println("Sub Menu = " + subMenuClassValue);

        BrowserUtils.waitFor(2);

        Assert.assertTrue(mainMenuClassValue.contains("selected"));
        Assert.assertTrue(subMenuClassValue.contains("expanded"));

    }

}
