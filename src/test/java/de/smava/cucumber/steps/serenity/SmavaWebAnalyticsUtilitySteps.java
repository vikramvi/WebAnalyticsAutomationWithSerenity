package de.smava.cucumber.steps.serenity;

import de.smava.cucumber.pages.SmavaWebAnalyticsUtility;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SmavaWebAnalyticsUtilitySteps extends ScenarioSteps{
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    @Step
    public void finishAssertAllStep(){
       smavaWebAnalyticsUtility.AssertAll();
    }

    @Step
    public void checkEventsOrdering(List<List<String>> data){
        smavaWebAnalyticsUtility.verifyEventsOrdering(data);
    }

    @Step
    public void verifyGTMDataForParticularSmavaPage_AgainstNonEmptyValues(String eventName, String pageName,  List<List<String>> data){
        assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage(pageName, eventName) ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_ValueIsNotNull(data);
    }

    @Step
    public void verifyGTMDataForParticularSmavaPage_KeyValuePairsFromDataTable(String pageName, List<List<String>> data){
        assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage(pageName) ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(data);
    }

    @Step
    public void updateGTMCountForParticularPage(){
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage();
    }

    @Step
    public void verifyGTMObjectKeyValuePair(String pageName, List<List<String>> data){
        assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage(pageName) ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(data);
    }

}
