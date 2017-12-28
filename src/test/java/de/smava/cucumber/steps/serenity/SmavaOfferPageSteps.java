package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import de.smava.cucumber.pages.OfferPage;
import de.smava.cucumber.pages.SmavaWebAnalyticsUtility;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class SmavaOfferPageSteps extends ScenarioSteps {
    private OfferPage offerPage;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    public void isOfferPageLoadedSuccessfully(){
        assertThat( offerPage.isOfferPageLoadedSuccessfully() ).isTrue();
    }

    @Step
    public void verifyGTMDataForSmavaOfferPage(){
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaOfferPage");
    }

    @Step
    public void verifyGTMDataForSmavaOfferPageWithData(List<List<String>> data){
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaOfferPage");
        smavaWebAnalyticsUtility.verifyGTMTest(data);
    }
}
