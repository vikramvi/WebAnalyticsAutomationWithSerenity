package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.*;

import java.util.List;

public class SmavaEinkommenPage2Steps extends ScenarioSteps {
    private EinkommenStep2Page einkommenStep2Page;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    @Step
    public void completeEinkommenPage2Steps(){
        einkommenStep2Page.fillEinkommenStep2PageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep2Page(){
        assertThat( einkommenStep2Page.isEinkommenStep2PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaEinkommenStep2Page");
    }

    @Step
    public void verifyGTMDataForSmavaEinkommenStep2PageWithData(List<List<String>> data){
        assertThat( einkommenStep2Page.isEinkommenStep2PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaEinkommenStep2Page");
        smavaWebAnalyticsUtility.verifyGTMTest(data);
    }
}
