package com.sogeti.step_definitions;

import com.sogeti.pages.Worldwide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class worldwideStepDefs {

    Worldwide worldwide = new Worldwide();

    @When("the user click Worldwide Dropdown")
    public void theUserClickWorldwideDropdown() {

        worldwide.clickWorldwideDropdown();

    }

    @And("the user should see Countries")
    public void theUserShouldSeeCountries() {

        worldwide.theUserShouldSeeCountries();

    }

    @Then("verify that all the Country specific Sogeti links are working {string} {string}")
    public void verifyThatAllTheCountrySpecificSogetiLinksAreWorking(String country, String partialPageTitle) {

        worldwide.clickCountryLink(country);
        worldwide.checkTheNewWindowTitle(partialPageTitle);

    }

}
