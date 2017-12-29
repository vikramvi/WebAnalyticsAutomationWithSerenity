package de.smava.cucumber.steps.gherkin;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.thucydides.core.annotations.Steps;

import de.smava.cucumber.steps.serenity.*;

import java.util.List;

public class SmavaScenarioSteps {

    //------- Serenity Step Objects ---------

    @Steps
    SmavaHomePageSteps smavaHomePageCucumberSteps;

    //@Steps
    //SmavaMobilPageSteps smavaMobilPageCucumberSteps;

    @Steps
    SmavaKreditPageSteps smavaKreditPageSteps;

    @Steps
    SmavaPersonPage1Steps smavaPersonPage1Steps;

    @Steps
    SmavaPersonPage2Steps smavaPersonPage2Steps;

    @Steps
    SmavaEinkommenPage1Steps smavaEinkommenPage1Steps;

    @Steps
    SmavaEinkommenPage2Steps smavaEinkommenPage2Steps;

    @Steps
    SmavaAngeboteVergleichenSteps smavaAngeboteVergleichenSteps;

    @Steps
    SmavaOfferPageSteps smavaOfferPageSteps;

    @Steps
    SmavaWebAnalyticsUtilitySteps smavaWebAnalyticsUtilitySteps;


    //--------------------------- GIVEN -----------------------------------

    @Given("User is on smava home page")
    public void gotoSmavaHomePage(){
        smavaHomePageCucumberSteps.open_smava_home_page();
    }

    @Given("User is on Smava Registration Route Kredit Page")
    public void gotoSmavaKreditStepPage(){
        smavaHomePageCucumberSteps.open_smava_home_page();
        smavaHomePageCucumberSteps.user_enters_loanSearchInfo();
    }

    @Given("User is on Smava Registration Route Person Step1 Page")
    public void gotoSmavaPersonStep1Page(){
        smavaHomePageCucumberSteps.open_smava_home_page();
        smavaHomePageCucumberSteps.user_enters_loanSearchInfo();
        smavaKreditPageSteps.completeKreditPageSteps();
    }

    @Given("User is on Smava Registration Route Person Step2 Page")
    public void gotoSmavaPersonStep2Page(){
        smavaHomePageCucumberSteps.open_smava_home_page();
        smavaHomePageCucumberSteps.user_enters_loanSearchInfo();
        smavaKreditPageSteps.completeKreditPageSteps();
        smavaPersonPage1Steps.completePersonPage1Steps();
    }

    @Given("User is on Smava Registration Route Einkommen Step1 Page")
    public void gotoSmavaEinkommenStep1Page(){
        smavaHomePageCucumberSteps.open_smava_home_page();
        smavaHomePageCucumberSteps.user_enters_loanSearchInfo();
        smavaKreditPageSteps.completeKreditPageSteps();
        smavaPersonPage1Steps.completePersonPage1Steps();
        smavaPersonPage2Steps.completePersonPage2Steps();
    }

    @Given("User is on Smava Registration Route Einkommen Step2 Page")
    public void gotoSmavaEinkommenStep2Page(){
        smavaHomePageCucumberSteps.open_smava_home_page();
        smavaHomePageCucumberSteps.user_enters_loanSearchInfo();
        smavaKreditPageSteps.completeKreditPageSteps();
        smavaPersonPage1Steps.completePersonPage1Steps();
        smavaPersonPage2Steps.completePersonPage2Steps();
        smavaEinkommenPage1Steps.completeEinkommenPage1Steps();
    }

    @Given("User is on Smava Registration Route Angebote Vergleichen Page")
    public void gotoSmavaAngeboteVergleichenPage(){
        smavaHomePageCucumberSteps.open_smava_home_page();
        smavaHomePageCucumberSteps.user_enters_loanSearchInfo();
        smavaKreditPageSteps.completeKreditPageSteps();
        smavaPersonPage1Steps.completePersonPage1Steps();
        smavaPersonPage2Steps.completePersonPage2Steps();
        smavaEinkommenPage1Steps.completeEinkommenPage1Steps();
        smavaEinkommenPage2Steps.completeEinkommenPage2Steps();
    }

    @Given("User is on Smava Offer Page")
    public void gotoSmavaOfferPage(){
        smavaHomePageCucumberSteps.open_smava_home_page();
        smavaHomePageCucumberSteps.user_enters_loanSearchInfo();
        smavaKreditPageSteps.completeKreditPageSteps();
        smavaPersonPage1Steps.completePersonPage1Steps();
        smavaPersonPage2Steps.completePersonPage2Steps();
        smavaEinkommenPage1Steps.completeEinkommenPage1Steps();
        smavaEinkommenPage2Steps.completeEinkommenPage2Steps();
        smavaAngeboteVergleichenSteps.completeAngeboteVergleichenSteps();
        smavaOfferPageSteps.isOfferPageLoadedSuccessfully();
    }



    /*@Given("User is on smava mobile integration page")
    public void gotoSmavaMobilIntegrationPage(){
        smavaMobilPageCucumberSteps.open_smava_mobile_integration_page();
    }*/


    //--------------------------- WHEN -----------------------------------

    @When("User verifies home page GTM objects key value pair with datatable")
    public void checkSmavaHomePageGMT(DataTable testData){
        List<List<String>> data = testData.raw();
        smavaHomePageCucumberSteps.verifyGTMDataForSmavaHomePageWithData(data);
    }

    @When("User checks Kredit page for GTM with datatable")
    public void checkSmavaKreditPageGMT(DataTable testData){
        List<List<String>> data = testData.raw();
        smavaKreditPageSteps.verifyGTMDataForSmavaKreditPageWithData(data);
    }

    @When("User checks Person Step1 for GTM with datatable")
    public void checkSmavaPersonStep1PageGMT(DataTable testData){
        List<List<String>> data = testData.raw();
        smavaPersonPage1Steps.verifyGTMDataForSmavaPersonStep1PageWithData(data);

    }

    @When("User checks Person Step2 page for GTM with datatable")
    public void checkSmavaPersonStep2PageGMT(DataTable testData){
        List<List<String>> data = testData.raw();
        smavaPersonPage2Steps.verifyGTMDataForSmavaPersonStep2PageWithData(data);
    }

    @When("User checks Einkommen Step1 page for GTM with datatable")
    public void checkSmavaEinkommenStep1PageGMT(DataTable testData){
        List<List<String>> data = testData.raw();
        smavaEinkommenPage1Steps.verifyGTMDataForSmavaEinkommenStep1PageWithData(data);
    }

    @When("User checks Einkommen Step2 page for GTM with datatable")
    public void checkSmavaEinkommenStep2PageGMT(DataTable testData){
        List<List<String>> data = testData.raw();
        smavaEinkommenPage2Steps.verifyGTMDataForSmavaEinkommenStep2PageWithData(data);
    }

    @When("User checks Angebote Vergleichen page for GTM with datatable")
    public void checkSmavaAngeboteVergleichenPageGMT(DataTable testData){
        List<List<String>> data = testData.raw();
        smavaAngeboteVergleichenSteps.verifyGTMDataForSmavaAngeboteVergleichenPageWithData(data);
    }

    @When("User verifies offer page GTM objects key value pair from datatable")
    public void checkSmavaOfferPageGTM_KeyValuePair(DataTable testData){
        List<List<String>> data = testData.raw();
        smavaOfferPageSteps.verifyGTMDataForSmavaOfferPageWithData(data);
    }

    @When("User checks offer page for non empty GTM objects from datatable")
    public void checkSmavaOfferPageGTM_NonEmptyValuesAgainstKey(DataTable testData){
        List<List<String>> data = testData.raw();
        smavaOfferPageSteps.verifyGTMDataForSmavaOfferPage_AgainstNonEmptyValues(data);
    }





    @When("User performs search by entering loan related valid values")
    public void userInputsData(){
        smavaHomePageCucumberSteps.user_enters_loanSearchInfo();
        smavaHomePageCucumberSteps.user_performs_vergleichen_action();
    }

    @When("User enters invalid credentials to login")
    public void userTriesToLoginWithInvalidInput(){
        smavaHomePageCucumberSteps.verify_invalid_user_login();
    }

    /*@When("User clicks on expand icon against bank entry row")
    public void userClickOnProductDetailsExpandbutton(){
        smavaMobilPageCucumberSteps.userClicksProductDetailsExpandButton();
    }*/

    @When("User goes through registration route to get offer")
    public void completeRegistrationRouteAndFetchGTMData(){
        smavaHomePageCucumberSteps.verifyGTMDataForSmavaHomePage();
        smavaHomePageCucumberSteps.user_enters_loanSearchInfo();

        //Kredit
        smavaKreditPageSteps.verifyGTMDataForSmavaKreditPage();
        smavaKreditPageSteps.completeKreditPageSteps();

        //PersonStep 1
        smavaPersonPage1Steps.verifyGTMDataForSmavaPersonPage1Steps();
        smavaPersonPage1Steps.completePersonPage1Steps();



        //PersonStep 2
        smavaPersonPage2Steps.verifyGTMDataForSmavaPersonStep2Page();
        smavaPersonPage2Steps.completePersonPage2Steps();


        //EinkommenStep 1
        smavaEinkommenPage1Steps.verifyGTMDataForSmavaEinkommenStep1Page();
        smavaEinkommenPage1Steps.completeEinkommenPage1Steps();


        //EinkommenStep 2
        smavaEinkommenPage2Steps.verifyGTMDataForSmavaEinkommenStep2Page();
        smavaEinkommenPage2Steps.completeEinkommenPage2Steps();


        //Angebote Vergleichen
        smavaAngeboteVergleichenSteps.verifyGTMDataForSmavaAngeboteVergleichenPage();
        smavaAngeboteVergleichenSteps.completeAngeboteVergleichenSteps();


        //Offer page
        smavaOfferPageSteps.isOfferPageLoadedSuccessfully();
        smavaOfferPageSteps.verifyGTMDataForSmavaOfferPage();
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

    /*@Then("Landing page is fully loaded")
    public void verifyIntegrationLandingPage(){
        smavaMobilPageCucumberSteps.is_smava_mobile_integration_page_loaded_completely();
    }

    @Then("User should see required 5 column names")
    public void verifyBankingTableColumnNames(){
       smavaMobilPageCucumberSteps.isBankingTableColumnsNameDisplayed();
    }*/

    /*@Then("User can see Continue button against each of the bank entries")
    public void verifyWeiterButtonAgainstEachOfTheBankEntry(){
         smavaMobilPageCucumberSteps.checkForWeiterButton();
    }

    @Then("User can view all the expected values for Verwendung")
    public void verifyVerwendungValues(){
        smavaMobilPageCucumberSteps.checkVerwendung();
    }

    @Then("User can view all the expected values for Laufzeit")
    public void verifyLaufzeitValues(){
        smavaMobilPageCucumberSteps.checkLaufzeit();
    }

    @Then("User can view all the expected values for Nettokreditbetrag")
    public void verifyNettokreditbetragValues(){
        smavaMobilPageCucumberSteps.checkNettokreditbetrag();
    }

    @Then("User can view product details by clicking on expand icon against bank entry row")
    public void verifyUserCanViewProductDetailsForParticularBank(){
        smavaMobilPageCucumberSteps.userClicksProductDetailsExpandButton();
    }*/

    @Then("User verifies values of GTM on each of the pages")
    public void completeGTMSoftAssertionsStep(){
        smavaWebAnalyticsUtilitySteps.finishAssertAllStep();
    }

}
