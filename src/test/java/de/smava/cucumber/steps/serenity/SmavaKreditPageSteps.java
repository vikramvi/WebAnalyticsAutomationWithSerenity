package de.smava.cucumber.steps.serenity;


import static org.assertj.core.api.Assertions.assertThat;

import de.smava.cucumber.pages.SmavaWebAnalyticsUtility;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.KreditStepPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmavaKreditPageSteps extends ScenarioSteps {
    private KreditStepPage kreditStepPage;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;


    private static List<List<String>> kreditPageGMTObjects = new ArrayList<List<String>>();
    static {
                {
                    kreditPageGMTObjects.add(Arrays.asList("pageId", "CreditSelection"));
                    kreditPageGMTObjects.add(Arrays.asList("channel", "smava intern"));
                    kreditPageGMTObjects.add(Arrays.asList("event", "registration_started"));
                    kreditPageGMTObjects.add(Arrays.asList("event", "registration_page"));
                    kreditPageGMTObjects.add(Arrays.asList("flow", "V1"));
                    kreditPageGMTObjects.add(Arrays.asList("pageNo", "1"));
                    kreditPageGMTObjects.add(Arrays.asList("pageTitle", "Kredit"));
                }
    }


    @Step
    public void isKreditPageCompletelyLoaded(){
        assertThat( kreditStepPage.isKreditStepPageLoaded() ).isTrue();
    }

    @Step
    public void completeKreditPageSteps(){
        kreditStepPage.clickWeiterButton();
    }

    @Step
    public void verifyGTMDataForSmavaKreditPage(){
        assertThat( kreditStepPage.isKreditStepPageLoaded() ).isTrue();
        assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaKreditPage") ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(kreditPageGMTObjects);
    }

    @Step
    public void verifyGTMDataForSmavaKreditPage_AgainstNonEmptyValues(List<List<String>> data){
        //As fetchGTMObjectsForGivenPage is alredy called, recalling results in failure
        //assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaKreditPage") ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_ValueIsNotNull(data);
    }

}
