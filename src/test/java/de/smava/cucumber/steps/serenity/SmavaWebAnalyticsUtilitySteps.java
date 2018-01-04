package de.smava.cucumber.steps.serenity;

import de.smava.cucumber.pages.SmavaWebAnalyticsUtility;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

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

}
