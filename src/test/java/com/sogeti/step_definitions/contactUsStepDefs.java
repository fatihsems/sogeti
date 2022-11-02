package com.sogeti.step_definitions;

import com.sogeti.pages.AutomationPage;
import com.sogeti.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class contactUsStepDefs {

    AutomationPage automationPage = new AutomationPage();

    @And("the user scroll down to the Contact us Form")
    public void the_user_scroll_down_to_the_Contact_us_Form() {

        BrowserUtils.scrollToElement(automationPage.contactUs);

    }

    @And("the user fill the First Name, Last Name, Email, Phone and Message fields with Random Generated Data")
    public void theUserFillTheFirstNameLastNameEmailPhoneAndMessageFieldsWithRandomGeneratedData() {

        automationPage.fillContactUs();

    }

    @And("the user check the I agree checkbox")
    public void theUserCheckTheIAgreeCheckbox() {

        automationPage.CheckTheIAgreeCheckbox();

    }

    @And("the user check the i am not a robot checkbox")
    public void theUserCheckTheIAmNotARobotCheckbox() {

        automationPage.checkTheIAmNotARobotCheckbox();

    }

    @And("the user click submit button")
    public void theUserClickSubmitButton() {

       automationPage.clickSubmitButton();

    }

    @Then("Thank you message is displayed")
    public void thankYouMessageIsDisplayed() {

        automationPage.thankYouMessageIsDisplayed();

    }

}
