package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmavaPersonPage2Steps extends ScenarioSteps {
    private PersonStep2Page personStep2Page;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    private static List<List<String>> personPage2PageGMTObjects = new ArrayList<List<String>>();
    static {
        {

            personPage2PageGMTObjects.add(Arrays.asList("pageId", "Address2"));
            //kreditPageGMTObjects.add(Arrays.asList("channel", "smava intern1"));
            //kreditPageGMTObjects.add(0, ("pageId","CreditSelection") );

        }
    }

    @Step
    public void completePersonPage2Steps(){
        personStep2Page.fillPersonStep2PageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaPersonStep2Page(){
        assertThat( personStep2Page.isPersonStep2PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaPersonStep2Page");
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(personPage2PageGMTObjects);
    }

    @Step
    public void verifyGTMDataForSmavaPersonStep2PageWithData(List<List<String>> data){
        assertThat( personStep2Page.isPersonStep2PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaPersonStep2Page");
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(data);
    }
}
