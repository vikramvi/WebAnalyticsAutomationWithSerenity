package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.*;

public class SmavaPersonPage1Steps extends ScenarioSteps {
    private PersonStep1Page personStep1Page;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    @Step
    public void completePersonPage1Steps(){
        personStep1Page.fillPersonStep1PageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaPersonPage1Steps(){
        assertThat( personStep1Page.isPersonStep1PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaPersonStep1Page");
    }
}
