package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.*;

public class SmavaHomePageSteps extends ScenarioSteps {

    //----------- PageObjects --------------

    SmavaHomePage smavaHomePage;
    SmavaLoanSearchKreditPage smavaLoanSearchKreditPage;
    SmavaLoginErrorPage smavaLoginErrorPage;


    //------------ Test Data ---------------
    int loanAmount = 2750;
    int loanDurationMonths = 24;
    String loanPurpose = "Wohnen";

    String invalidEmail = "smava@invalid.de";
    String invalidPassword = "smava";


    @Step
    public void open_smava_home_page(){
        smavaHomePage.open();
    }

    @Step
    public void user_enters_loanSearchInfo(){
        assertThat( smavaHomePage.inputNettokreditbetragValue(loanAmount) ).isTrue();
        assertThat( smavaHomePage.selectLaufzeitValue(loanDurationMonths) ).isTrue();
        assertThat( smavaHomePage.selectVerwendungValue(loanPurpose) ).isTrue();
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
}
