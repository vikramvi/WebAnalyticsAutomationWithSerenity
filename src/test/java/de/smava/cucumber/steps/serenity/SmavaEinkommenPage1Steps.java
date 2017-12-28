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

            EinkommenStep1PageGMTObjects.add(Arrays.asList("pageId", "Employment"));
            //EinkommenStep1PageGMTObjects.add(Arrays.asList("channel", "smava intern"));
            //kreditPageGMTObjects.add(0, ("pageId","CreditSelection") );

        }
    }

    @Step
    public void completeEinkommenPage1Steps(){
        einkommenStep1Page.fillEinkommenStep1PageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep1Page(){
        assertThat( einkommenStep1Page.isEinkommenStep1PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaEinkommenStep1Page");
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(EinkommenStep1PageGMTObjects);
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep1PageWithData(List<List<String>> data){
        assertThat( einkommenStep1Page.isEinkommenStep1PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaEinkommenStep1Page");
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(data);
    }
}
