package com.sogeti.step_definitions;

import com.sogeti.pages.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiStepDefs {
    ApiPage apiPage = new ApiPage();

    @Given("user is on the Api page")
    public void userIsOnTheApiPage() {

        apiPage.userIsOnTheApiPage();
    }

    @When("Verify that the response status code is {int} and content type is {string}")
    public void verifyThatTheResponseStatusCodeIsAndContentTypeIs(int statusCode, String contentType) {

        apiPage.verifyStatusCode(statusCode);
        apiPage.verifyContentType(contentType);

    }

    @And("Verify that the response time is below {int}ms")
    public void verifyThatTheResponseTimeIsBelowMs(int ms) {

        apiPage.responseTimeBelowOneSecond(ms);
    }

    @And("Verify in Response - That country is {string} and state is {string}")
    public void verifyInResponseThatCountryIsAndStateIs(String country, String state) {

        apiPage.verifyStateAndCountry(country, state);

    }

    @Then("Verify in Response - For Post Code {string} the place name has {string}")
    public void verifyInResponseForPostCodeThePlaceNameHas(String postCode, String placeName) {
       apiPage.verifyPostCodeAndPlaceName(postCode, placeName);

    }

    @Given("information for data driven test below")
    public void informationForDataDrivenTestBelow() {

//        Given information for data driven test

    }

    @Then("Verify in Response  {string} for each input {string} and {string}")
    public void verifyInResponseForEachInputAnd(String placeName, String country, String postalCode) {

        apiPage.verifyInResposePlaceNameForInputAndPostalCode(placeName, country, postalCode);

    }

}
