package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.*;

public class SmavaPersonPage2Steps extends ScenarioSteps {
    private PersonStep2Page personStep2Page;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    @Step
    public void completePersonPage2Steps(){
        personStep2Page.fillPersonStep2PageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaPersonStep2Page(){
        assertThat( personStep2Page.isPersonStep2PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaPersonStep2Page");
    }
}
