package de.smava.cucumber.pages;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import de.smava.cucumber.SmavaHomePageTest;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class SmavaWebAnalyticsUtility extends PageObject {


    private static SoftAssertions softAssertions = null;
    Multimap<String, String> multimap;

    public void verifyGTMValues(String pageName){
        try{

            if(softAssertions == null) {
                softAssertions = new SoftAssertions();
            }

            JSONObject json = new JSONObject();

            JavascriptExecutor js = (JavascriptExecutor)getDriver();


            //ArrayList<String> myList = new ArrayList<String>();
            ArrayList<Map<String, String>> myList = new ArrayList<>();

            ArrayList<Map<String, String>> myList2 = new ArrayList<>();


            myList =  (ArrayList) js.executeScript("return window.smavaGoTaMa2016");
            myList2 = myList;


            //HashMap don’t allow duplicate keys
            //GTM has duplicate keys
            //HashMap<String, String> actualGMTData = new HashMap<String, String>();


            //https://stackoverflow.com/questions/1062960/map-implementation-with-duplicate-keys
            //Map with duplicate keys
            //Multimap<String, String> multimap = ArrayListMultimap.create();
            multimap = ArrayListMultimap.create();


            String keyTemp;
            String valueTemp;


            SmavaHomePageTest.GMTCount = myList.size();


            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + pageName +"  GTM Data <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


            for(int a=0; a < myList.size(); a++) {
                System.out.println("-----------------  Key Index = " + a);
                try {

                    for (String key : myList.get(a).keySet()) {
                        System.out.println(key + "      " + String.valueOf(myList.get(a).get(key)));

                        //keyTemp = key;
                        //valueTemp = String.valueOf( myList.get(a).get(key).toString() );

                        //actualGMTData.put(key, String.valueOf( myList.get(a).get(key)) );

                        //working
                        multimap.put(key, String.valueOf( myList.get(a).get(key)) );

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


            //FAILS in case assertion fails but test case should continue execution
            //assertThat( isValuePresent(multimap, "gtm.uniqueEventId", "5123") ).isTrue();


            /*//http://joel-costigliola.github.io/assertj/core/api/org/assertj/core/api/SoftAssertions.html
            softAssertions = new SoftAssertions();

            softAssertions.assertThat(isValuePresent(multimap, "affiliateChannel", "NA")).as("affiliateChannel").isEqualTo(true);

            softAssertions.assertThat(isValuePresent(multimap, "channel", "smava intern")).as("channel").isEqualTo(true);

            softAssertions.assertThat(isValuePresent(multimap, "gtm.uniqueEventId", "5123")).as("gtm.uniqueEventId").isEqualTo(true);

            softAssertions.assertAll();*/

            //SmavaHomePageSoftAssertions();

            switch(pageName){
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
                                    SmavaOfferPageSoftAssertions();
                                    break;
                default:
                       System.out.println("Invalid Page Name");
                       break;
            }


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


    public void SmavaHomePageSoftAssertions(){

        //http://joel-costigliola.github.io/assertj/core/api/org/assertj/core/api/SoftAssertions.html
        //softAssertions = new SoftAssertions();

        softAssertions.assertThat(isValuePresent(multimap, "affiliateChannel", "NA")).as("HomePage affiliateChannel").isEqualTo(true);

        softAssertions.assertThat(isValuePresent(multimap, "channel", "smava intern")).as("HomePage channel").isEqualTo(true);

        //softAssertions.assertThat(isValuePresent(multimap, "gtm.uniqueEventId", "5")).as("gtm.uniqueEventId").isEqualTo(true);

        //softAssertions.assertAll(); //CALL in the end

    }


    public void SmavaKreditStepPageSoftAssertions(){
        //softAssertions = new SoftAssertions();

        softAssertions.assertThat(isValuePresent(multimap, "pageId", "CreditSelection")).as("KreditStepPage pageId").isEqualTo(true);

       // softAssertions.assertAll();
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

    public void SmavaOfferPageSoftAssertions(){
        softAssertions.assertThat(isValuePresent(multimap, "pageId", "NextSteps")).as("OfferPage pageId").isEqualTo(true);
        softAssertions.assertThat(isValuePresent(multimap, "requested_amount", "500")).as("OfferPage requested_amount").isEqualTo(true);
        softAssertions.assertThat(isValuePresent(multimap, "requested_duration", "84")).as("OfferPage requested_duration").isEqualTo(true);
        softAssertions.assertThat(isValuePresent(multimap, "requested_category", "888")).as("OfferPage requested_category").isEqualTo(true);
    }

    public void AssertAll(){
        softAssertions.assertAll();
    }


}
