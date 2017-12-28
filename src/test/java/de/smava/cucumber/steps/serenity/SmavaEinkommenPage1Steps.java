package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.*;

import java.util.List;

public class SmavaEinkommenPage1Steps extends ScenarioSteps {
    private EinkommenStep1Page einkommenStep1Page;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    @Step
    public void completeEinkommenPage1Steps(){
        einkommenStep1Page.fillEinkommenStep1PageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep1Page(){
        assertThat( einkommenStep1Page.isEinkommenStep1PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaEinkommenStep1Page");
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep1PageWithData(List<List<String>> data){
        assertThat( einkommenStep1Page.isEinkommenStep1PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaEinkommenStep1Page");
        smavaWebAnalyticsUtility.verifyGTMTest(data);
    }
}
