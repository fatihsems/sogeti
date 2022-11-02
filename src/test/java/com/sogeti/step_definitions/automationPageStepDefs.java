package com.sogeti.step_definitions;

import com.sogeti.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class automationPageStepDefs {

    HomePage homePage = new HomePage();

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {

        homePage.gotoHomePage();

    }

    @Given("the user should be able to hover over {string} Link and click the {string} link")
    public void theUserShouldBeAbleToHoverOverLinkAndClickTheLink(String mainLink, String subLink) {

        homePage.HoverOverMainLinkAndClickTheSubLink(mainLink, subLink);

    }

    @And("The {string} Screen should be displayed")
    public void the_Screen_should_be_displayed(String expectedTitle) {

        homePage.verifyThatTheUserIsOnTheSelectedPageWithPageTitle(expectedTitle);

    }

    @And("The {string} text should be visible in Page")
    public void the_text_should_be_visible_in_Page(String pageText) {

        homePage.verifyTextOnPage(pageText);

    }

    @When("the user hover over mainLink Link again")
    public void theUserHoverOverServicesLinkAgain() {

        homePage.mouseOverElementUsingActionsClass(homePage.mainMenuSelected);

    }

    @Then("verify that the mainMenu and subMenu are selected")
    public void verifyThatTheMainMenuAndSubMenuAreSelected() {

        homePage.verifyThatThaMainMenuAndTheSubMenuAreSelected();

    }

    @Then("verify that the mainMenu and subMenu are selected {string} {string}")
    public void verifyThatTheMainMenuAndSubMenuAreSelected(String mainLink, String subLink) {

        homePage.verifyThatThaMainMenuAndTheSubMenuAreSelected(mainLink, subLink);

    }

}
