package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmavaEinkommenPage1Steps extends ScenarioSteps {
    private EinkommenStep1Page einkommenStep1Page;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    private static List<List<String>> EinkommenStep1PageGMTObjects = new ArrayList<List<String>>();
    static {
        {
            EinkommenStep1PageGMTObjects.add(Arrays.asList("event", "registration_page"));
            EinkommenStep1PageGMTObjects.add(Arrays.asList("flow", "V1"));
            EinkommenStep1PageGMTObjects.add(Arrays.asList("pageId", "Employment"));
            EinkommenStep1PageGMTObjects.add(Arrays.asList("pageNo", "4"));
            EinkommenStep1PageGMTObjects.add(Arrays.asList("pageTitle", "Einkommen"));
        }
    }

    @Step
    public void isEinkommenPage1StepCompletelyLoaded(){
        assertThat( einkommenStep1Page.isEinkommenStep1PageLoaded() ).isTrue();
    }

    @Step
    public void completeEinkommenPage1Steps(){
        einkommenStep1Page.fillEinkommenStep1PageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep1Page(){
        assertThat( einkommenStep1Page.isEinkommenStep1PageLoaded() ).isTrue();
        assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaEinkommenStep1Page") ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(EinkommenStep1PageGMTObjects);
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep1PageWithData(List<List<String>> data){
        assertThat( einkommenStep1Page.isEinkommenStep1PageLoaded() ).isTrue();
        assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaEinkommenStep1Page") ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(data);
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep1Page_AgainstNonEmptyValues(List<List<String>> data){
        //assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaEinkommenStep1Page") ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_ValueIsNotNull(data);
    }

}
