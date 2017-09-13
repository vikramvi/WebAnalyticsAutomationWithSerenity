package de.smava.cucumber.steps.gherkin;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.thucydides.core.annotations.Steps;

import de.smava.cucumber.steps.serenity.*;

public class SmavaScenarioSteps {

    //------- Serenity Step Objects ---------

    @Steps
    SmavaHomePageSteps smavaHomePageCucumberSteps;


    //--------------------------- GIVEN -----------------------------------

    @Given("User is on smava home page")
    public void gotoSmavaHomePage(){
        smavaHomePageCucumberSteps.open_smava_home_page();
    }


    //--------------------------- WHEN -----------------------------------

    @When("User performs search by entering loan related valid values")
    public void userInputsData(){
        smavaHomePageCucumberSteps.user_enters_loanSearchInfo();
        smavaHomePageCucumberSteps.user_performs_vergleichen_action();
    }

    @When("User enters invalid credentials to login")
    public void userTriesToLoginWithInvalidInput(){
        smavaHomePageCucumberSteps.verify_invalid_user_login();
    }

    //--------------------------- THEN -----------------------------------

    @Then("User is taken to first step of loan processing")
    public void verifyKreditStep(){
        smavaHomePageCucumberSteps.verify_user_lands_on_kredit_step();
    }

    @Then("User is taken to error page")
    public void verifyInvalidLoginErrorPage(){
        smavaHomePageCucumberSteps.verify_invalid_login_error_page();
    }

}
