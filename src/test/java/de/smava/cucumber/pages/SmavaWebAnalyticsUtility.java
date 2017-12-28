package de.smava.cucumber.pages;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmavaWebAnalyticsUtility extends PageObject {


    private static SoftAssertions softAssertions = null;
    Multimap<String, String> multimap;
    private static int oldGMTCount = 0;
    private static int GMTCount = 0;
    private String localPageName = null;

    public void verifyGTMTest(List<List<String>> data){

        //softAssertions = new SoftAssertions();

        for(int i=0; i < data.size(); i++) {

            softAssertions.assertThat(isValuePresent(multimap, data.get(i).get(0), data.get(i).get(1))).as(localPageName +" " + data.get(i).get(0)).isEqualTo(true);
        }
    }



    public void verifyGTMValues(String pageName){
        try{

            localPageName = pageName;

            if(softAssertions == null) {
                //http://joel-costigliola.github.io/assertj/core/api/org/assertj/core/api/SoftAssertions.html
                softAssertions = new SoftAssertions();
            }

            JSONObject json = new JSONObject();

            JavascriptExecutor js = (JavascriptExecutor)getDriver();


            //ArrayList<String> myList = new ArrayList<String>();
            ArrayList<Map<String, String>> myList = new ArrayList<>();

            myList =  (ArrayList) js.executeScript("return window.smavaGoTaMa2016");


            //HashMap don’t allow duplicate keys
            //GTM has duplicate keys
            //HashMap<String, String> actualGMTData = new HashMap<String, String>();


            //https://stackoverflow.com/questions/1062960/map-implementation-with-duplicate-keys
            //Map with duplicate keys
            //Multimap<String, String> multimap = ArrayListMultimap.create();
            multimap = ArrayListMultimap.create();


            String keyTemp;
            String valueTemp;

            oldGMTCount = GMTCount;
            GMTCount = myList.size();

            //To ignore GMT ojbects from earlier pages
            if(pageName.equals("SmavaHomePage") || pageName.equals("SmavaKreditPage") || pageName.equals("SmavaOfferPage")){
                oldGMTCount = 0;
            }


            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + pageName +"  GTM Data <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


            for(int a=0; a < myList.size(); a++) {

                try {

                       if(a >= oldGMTCount) {
                           System.out.println("-----------------  Key Index = " + a);
                               for (String key : myList.get(a).keySet()) {

                                   System.out.println(key + "      " + String.valueOf(myList.get(a).get(key)));

                                   //keyTemp = key;
                                   //valueTemp = String.valueOf( myList.get(a).get(key).toString() );

                                   //actualGMTData.put(key, String.valueOf( myList.get(a).get(key)) );

                                   //working
                                   multimap.put(key, String.valueOf(myList.get(a).get(key)));

                               }
                       }

                }catch (Exception e){
                    //e.printStackTrace();
                    continue;
                }
            }


            //---------------  Verification Step --------------


            //https://stackoverflow.com/questions/3934470/how-to-iterate-through-google-multimap
            for(Object key : multimap.keySet()){
                System.out.println( key + "     " + multimap.get(String.valueOf(key)) );
            }



            /*switch(pageName){
                case "SmavaHomePage":
                                    SmavaHomePageSoftAssertions();
                                    break;
                case "SmavaKreditPage":
                                    SmavaKreditStepPageSoftAssertions();
                                    break;
                case "SmavaPersonStep1Page":
                                    SmavaPersonStep1SoftAssertions();
                                    break;
                case "SmavaPersonStep2Page":
                                    SmavaPersonStep2SoftAssertions();
                                    break;
                case "SmavaEinkommenStep1Page":
                                    SmavaEinkommenStep1SoftAssertions();
                                    break;
                case "SmavaEinkommenStep2Page":
                                    SmavaEinkommenStep2SoftAssertions();
                                    break;
                case "SmavaAngeboteVergleichenPage":
                                    SmavaAngeboteVergleichenSoftAssertions();
                                    break;
                case "SmavaOfferPage":
                                    SmavaOfferPageCheckForValidValues_SoftAssertions();
                                    SmavaOfferPageCheckForEmptyValues_SoftAssertions();
                                    break;
                default:
                       System.out.println("Invalid Page Name");
                       break;
            }*/


            // return true;
        }catch (Exception e){
            e.printStackTrace();
            //return false;
        }
    }

    //Check for key
    public boolean isKeyPresent(Multimap multimap, String key){
        Set keys = multimap.keySet();

        if(keys.contains(key)){
            return true;
        }else{
            return false;
        }
    }

    //Check for value of key
    public boolean isValuePresent(Multimap multimap, String key, String expectedValue){

        if( isKeyPresent(multimap, key)) {

            System.out.println("************" + key + "     " + multimap.get(String.valueOf(key)) );

            if(multimap.get(key).contains(expectedValue)) {
                return true;
            }else{
                return false;
            }
        }{
            return  false;
        }
    }


    public boolean checkForEmptyValue(Multimap multimap, String key){
        if( isKeyPresent(multimap, key)) {

            System.out.println("************" + key + "     " + multimap.get(String.valueOf(key)) );

                if(multimap.get(key).isEmpty() || multimap.get(key) != null) {
                    return true;
                }else{
                    return false;
                }
        }{
            return  false;
        }
    }

    public void SmavaHomePageSoftAssertions(){

        softAssertions.assertThat(checkForEmptyValue(multimap, "affiliateChannel")).as("HomePage affiliateChannel").isEqualTo(true);

        softAssertions.assertThat(isValuePresent(multimap, "affiliateChannel", "NA")).as("HomePage affiliateChannel").isEqualTo(true);

        softAssertions.assertThat(isValuePresent(multimap, "channel", "smava intern")).as("HomePage channel").isEqualTo(true);

        //softAssertions.assertThat(isValuePresent(multimap, "gtm.uniqueEventId", "5")).as("gtm.uniqueEventId").isEqualTo(true);

    }


    public void SmavaKreditStepPageSoftAssertions(){
        softAssertions.assertThat(isValuePresent(multimap, "pageId", "CreditSelection")).as("KreditStepPage pageId").isEqualTo(true);
    }

    public void SmavaPersonStep1SoftAssertions(){
        softAssertions.assertThat(isValuePresent(multimap, "pageId", "ContactInfo")).as("PersonStep1 pageId").isEqualTo(true);
    }

    public void SmavaPersonStep2SoftAssertions(){
        softAssertions.assertThat(isValuePresent(multimap, "pageId", "Address2")).as("PersonStep2 pageId").isEqualTo(true);

    }

    public void SmavaEinkommenStep1SoftAssertions(){
        softAssertions.assertThat(isValuePresent(multimap, "pageId", "Employment")).as("EinkommenStep1 pageId").isEqualTo(true);
    }

    public void SmavaEinkommenStep2SoftAssertions(){
        softAssertions.assertThat(isValuePresent(multimap, "pageId", "IncomeExpenses")).as("EinkommenStep2 pageId").isEqualTo(true);
    }

    public void SmavaAngeboteVergleichenSoftAssertions(){
        softAssertions.assertThat(isValuePresent(multimap, "pageId", "RdiAccount")).as("AngeboteVergleichen pageId").isEqualTo(true);
    }

    public void SmavaOfferPageCheckForValidValues_SoftAssertions(){
        softAssertions.assertThat(isValuePresent(multimap, "pageId", "NextSteps")).as("OfferPage pageId").isEqualTo(true);
        softAssertions.assertThat(isValuePresent(multimap, "requested_amount", "500")).as("OfferPage requested_amount").isEqualTo(true);

        softAssertions.assertThat(isValuePresent(multimap, "requested_duration", "84")).as("OfferPage requested_duration").isEqualTo(true);
        softAssertions.assertThat(isValuePresent(multimap, "requested_category", "888")).as("OfferPage requested_category").isEqualTo(true);

        softAssertions.assertThat(isValuePresent(multimap, "event", "next_steps")).as("OfferPage event").isEqualTo(true);
        softAssertions.assertThat(isValuePresent(multimap, "flow", "Fred")).as("OfferPage flow").isEqualTo(true);

        softAssertions.assertThat(isValuePresent(multimap, "marketingPartnerName", "smava GmbH")).as("OfferPage marketingPartnerName").isEqualTo(true);
        softAssertions.assertThat(isValuePresent(multimap, "firstMarketingPartnerName", "smava GmbH")).as("OfferPage firstMarketingPartnerName").isEqualTo(true);
    }

    public void SmavaOfferPageCheckForEmptyValues_SoftAssertions(){
        softAssertions.assertThat(checkForEmptyValue(multimap, "placementId")).as("OfferPage placementId").isEqualTo(true);
        softAssertions.assertThat(checkForEmptyValue(multimap, "accountId")).as("OfferPage accountId").isEqualTo(true);

        softAssertions.assertThat(checkForEmptyValue(multimap, "currentLoanApplicationId")).as("OfferPage currentLoanApplicationId").isEqualTo(true);
        softAssertions.assertThat(checkForEmptyValue(multimap, "leadCycleLoanApplicationId")).as("OfferPage leadCycleLoanApplicationId").isEqualTo(true);

        softAssertions.assertThat(checkForEmptyValue(multimap, "leadCycleLastTouchpoint")).as("OfferPage leadCycleLastTouchpoint").isEqualTo(true);
        softAssertions.assertThat(checkForEmptyValue(multimap, "leadCycleState")).as("OfferPage leadCycleState").isEqualTo(true);
    }


    public void AssertAll(){
        softAssertions.assertAll();
    }


}
