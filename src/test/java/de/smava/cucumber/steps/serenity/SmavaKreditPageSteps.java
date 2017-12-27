package de.smava.cucumber.steps.serenity;


import static org.assertj.core.api.Assertions.assertThat;

import de.smava.cucumber.pages.SmavaWebAnalyticsUtility;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.KreditStepPage;

public class SmavaKreditPageSteps extends ScenarioSteps {
    private KreditStepPage kreditStepPage;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    @Step
    public void completeKreditPageSteps(){
        kreditStepPage.clickWeiterButton();
    }

    @Step
    public void verifyGTMDataForSmavaKreditPage(){
        assertThat( kreditStepPage.isKreditStepPageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaKreditPage");
    }

}
