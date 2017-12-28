package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.*;

import java.util.List;

public class SmavaHomePageSteps extends ScenarioSteps {

    //----------- PageObjects --------------

    private SmavaHomePage smavaHomePage;
    private SmavaLoanSearchKreditPage smavaLoanSearchKreditPage;
    private SmavaLoginErrorPage smavaLoginErrorPage;

    private KreditStepPage kreditStepPage;
    private PersonStep1Page personStep1Page;
    private PersonStep2Page personStep2Page;
    private EinkommenStep1Page einkommenStep1Page;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;


    //------------ Test Data ---------------
    int loanAmount = 500;
    int loanDurationMonths = 24;
    String loanPurpose = "Wohnen";

    String invalidEmail = "smava@invalid.de";
    String invalidPassword = "smava";


    @Step
    public void open_smava_home_page(){
        smavaHomePage.open();
        getDriver().manage().window().maximize();
        assertThat( smavaHomePage.isSmavaHomePageLoaded() ).isTrue();
    }

    @Step
    public void user_enters_loanSearchInfo(){
        assertThat( smavaHomePage.inputNettokreditbetragValue(loanAmount) ).isTrue();
        assertThat( smavaHomePage.clickJetztVergleichenToStartWithKreditStep() ).isTrue();
    }

    @Step
    public void user_performs_vergleichen_action(){
        assertThat( smavaHomePage.clickJetztVergleichenToStartWithKreditStep() ).isTrue();
    }

    @Step
    public void verify_user_lands_on_kredit_step(){
        assertThat( smavaLoanSearchKreditPage.checkKreditStepPage() ).isTrue();
    }

    @Step
    public void verify_invalid_user_login(){
        assertThat( smavaHomePage.enterLoginDetailsAndSubmit(invalidEmail,invalidPassword) ).isTrue();
    }

    @Step
    public void verify_invalid_login_error_page(){
        assertThat( smavaLoginErrorPage.isErrorMessagePresent() ).isTrue();
    }

    @Step
    public void verifyGTMDataForSmavaHomePage(){
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaHomePage");
    }

    @Step
    public void verifyGTMDataForSmavaHomePageWithData(List<List<String>> data){

        smavaWebAnalyticsUtility.verifyGTMValues("SmavaHomePage");
        smavaWebAnalyticsUtility.verifyGTMTest(data);
    }
}
