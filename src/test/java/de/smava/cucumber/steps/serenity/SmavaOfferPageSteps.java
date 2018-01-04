package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import de.smava.cucumber.pages.OfferPage;
import de.smava.cucumber.pages.SmavaWebAnalyticsUtility;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmavaOfferPageSteps extends ScenarioSteps {
    private OfferPage offerPage;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;


    private static List<List<String>> offerPageGMTObjects = new ArrayList<List<String>>();
    static {
                {
                    offerPageGMTObjects.add(Arrays.asList("pageId", "NextSteps"));
                    offerPageGMTObjects.add(Arrays.asList("requested_amount", "500"));

                    offerPageGMTObjects.add(Arrays.asList("requested_duration", "84"));
                    offerPageGMTObjects.add(Arrays.asList("requested_category", "888"));

                    offerPageGMTObjects.add(Arrays.asList("event", "next_steps"));
                    offerPageGMTObjects.add(Arrays.asList("flow", "Fred"));

                    offerPageGMTObjects.add(Arrays.asList("marketingPartnerName", "smava GmbH"));
                    offerPageGMTObjects.add(Arrays.asList("firstMarketingPartnerName", "smava GmbH"));
                }
    }


    private static List<List<String>> offerPageGMTObjectsForNullCheck = new ArrayList<List<String>>();
    static {
                {

                    offerPageGMTObjectsForNullCheck.add(Arrays.asList("placementId"));
                    offerPageGMTObjectsForNullCheck.add(Arrays.asList("accountId"));

                    offerPageGMTObjectsForNullCheck.add(Arrays.asList("currentLoanApplicationId"));
                    offerPageGMTObjectsForNullCheck.add(Arrays.asList("leadCycleLoanApplicationId"));

                    offerPageGMTObjectsForNullCheck.add(Arrays.asList("leadCycleLastTouchpoint"));
                    //offerPageGMTObjectsForNullCheck.add(Arrays.asList("leadCycleState"));

                }
    }

    public void isOfferPageLoadedSuccessfully(){
        assertThat( offerPage.isOfferPageLoadedSuccessfully() ).isTrue();
    }

    @Step
    public void verifyGTMDataForSmavaOfferPage(){
        assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaOfferPage") ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(offerPageGMTObjects);
        smavaWebAnalyticsUtility.verifyGTM_ValueIsNotNull(offerPageGMTObjectsForNullCheck);
    }

    @Step
    public void verifyGTMDataForSmavaOfferPageWithData(List<List<String>> data){
        assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaOfferPage") ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(data);
    }

    @Step
    public void verifyGTMDataForSmavaOfferPage_AgainstNonEmptyValues(List<List<String>> data){
        //assertThat( smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaOfferPage") ).isTrue();
        smavaWebAnalyticsUtility.verifyGTM_ValueIsNotNull(data);
    }
}
