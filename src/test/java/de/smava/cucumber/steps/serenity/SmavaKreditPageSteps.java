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
                    //kreditPageGMTObjects.add(0, ("pageId","CreditSelection") );

                }
    }



    @Step
    public void completeKreditPageSteps(){
        kreditStepPage.clickWeiterButton();
    }

    @Step
    public void verifyGTMDataForSmavaKreditPage(){
        assertThat( kreditStepPage.isKreditStepPageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaKreditPage");
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(kreditPageGMTObjects);
    }

    @Step
    public void verifyGTMDataForSmavaKreditPageWithData(List<List<String>> data){
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaKreditPage");
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(data);
    }

}
