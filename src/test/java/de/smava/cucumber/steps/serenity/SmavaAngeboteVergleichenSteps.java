package de.smava.cucumber.steps.serenity;


import static org.assertj.core.api.Assertions.assertThat;

import de.smava.cucumber.pages.AngeboteVergleichenPage;
import de.smava.cucumber.pages.SmavaWebAnalyticsUtility;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class SmavaAngeboteVergleichenSteps extends ScenarioSteps{
    private AngeboteVergleichenPage angeboteVergleichenPage;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    @Step
    public void completeAngeboteVergleichenSteps(){
        angeboteVergleichenPage.fillAngeboteVergleichenPageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaAngeboteVergleichenPage(){
        assertThat( angeboteVergleichenPage.isAngeboteVergleichenPageLoaded()).isTrue();
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaAngeboteVergleichenPage");
    }

    @Step
    public void verifyGTMDataForSmavaAngeboteVergleichenPageWithData(List<List<String>> data){
        assertThat( angeboteVergleichenPage.isAngeboteVergleichenPageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.verifyGTMValues("SmavaAngeboteVergleichenPage");
        smavaWebAnalyticsUtility.verifyGTMTest(data);
    }
}
