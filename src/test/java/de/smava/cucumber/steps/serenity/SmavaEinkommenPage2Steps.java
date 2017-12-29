package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmavaEinkommenPage2Steps extends ScenarioSteps {
    private EinkommenStep2Page einkommenStep2Page;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    private static List<List<String>> EinkommenStep2PageGMTObjects = new ArrayList<List<String>>();
    static {
        {
            EinkommenStep2PageGMTObjects.add(Arrays.asList("event", "registration_page"));
            EinkommenStep2PageGMTObjects.add(Arrays.asList("flow", "V1"));
            EinkommenStep2PageGMTObjects.add(Arrays.asList("pageId", "IncomeExpenses"));
            EinkommenStep2PageGMTObjects.add(Arrays.asList("pageNo", "5"));
            EinkommenStep2PageGMTObjects.add(Arrays.asList("pageTitle", "Einkommen"));
        }
    }

    @Step
    public void completeEinkommenPage2Steps(){
        einkommenStep2Page.fillEinkommenStep2PageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep2Page(){
        assertThat( einkommenStep2Page.isEinkommenStep2PageLoaded() ).isTrue();
        assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaEinkommenStep2Page") ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(EinkommenStep2PageGMTObjects);
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep2PageWithData(List<List<String>> data){
        assertThat( einkommenStep2Page.isEinkommenStep2PageLoaded() ).isTrue();
        assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaEinkommenStep2Page") ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(data);
    }
}
