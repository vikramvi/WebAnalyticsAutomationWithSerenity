package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import de.smava.cucumber.pages.AngeboteVergleichenPage;
import de.smava.cucumber.pages.OfferPage;
import de.smava.cucumber.pages.SmavaWebAnalyticsUtility;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SmavaOfferPageSteps extends ScenarioSteps {
    private OfferPage offerPage;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    public void isOfferPageLoadedSuccessfully(){
        assertThat( offerPage.isOfferPageLoadedSuccessfully() ).isTrue();
    }

    @Step
    public void verifyGTMDataForSmavaSmavaOfferPage(){
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaOfferPage");
    }
}
