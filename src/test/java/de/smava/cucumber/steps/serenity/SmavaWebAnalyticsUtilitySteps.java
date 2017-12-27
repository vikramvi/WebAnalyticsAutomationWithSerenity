package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import de.smava.cucumber.pages.SmavaWebAnalyticsUtility;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SmavaWebAnalyticsUtilitySteps extends ScenarioSteps{
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    @Step
    public void finishAssertAllStep(){
       smavaWebAnalyticsUtility.AssertAll();
    }

}
