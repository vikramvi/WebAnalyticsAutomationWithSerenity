package de.smava.cucumber.pages;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmavaWebAnalyticsUtility extends PageObject {

    private static final String GTMScript = "return window.smavaGoTaMa2016";
    private static SoftAssertions softAssertions = null;
    private static Multimap<String, String> multimap, multimapForParticularEvent;
    private static int GTMObjectsCountForParticularPage = 0, oldGTMCount = 0;
    private String localPageName = null;
    private String localEventName = null;
    private static String lastPageName = "RandomLastPage";


    public void createSoftAssertionObject(){
        //https://automationrhapsody.com/soft-assertions-not-fail-junit-test/
        //http://joel-costigliola.github.io/assertj/core/api/org/assertj/core/api/SoftAssertions.html
        softAssertions = new SoftAssertions();
    }

    //Method to keep track of GTM objects count of each page
    public void fetchGTMObjectsForGivenPage() {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();

            ArrayList<Map<String, String>> GTMObjectsList = new ArrayList<>();

            GTMObjectsList = (ArrayList) js.executeScript(GTMScript);

            GTMObjectsCountForParticularPage = GTMObjectsList.size();
    }

    //Method to get GTM objects for particular event on particular page
    public boolean fetchGTMObjectsForGivenPage(String pageName, String eventName) {

        localEventName = eventName;

        return fetchGTMObjectsForGivenPage(pageName);
    }


    //Method to get GTM objects unique to particular page
    public boolean fetchGTMObjectsForGivenPage(String pageName){

                localPageName = pageName;

                JavascriptExecutor js = (JavascriptExecutor)getDriver();

                ArrayList<Map<String, String>> GTMObjectsList = new ArrayList<>();

                GTMObjectsList =  (ArrayList) js.executeScript(GTMScript);


                //HashMap don’t allow duplicate keys
                //GTM has duplicate keys
                //HashMap<String, String> actualGMTData = new HashMap<String, String>();


                //https://stackoverflow.com/questions/1062960/map-implementation-with-duplicate-keys
                //Map with duplicate keys
                //Multimap<String, String> multimap = ArrayListMultimap.create();
                ////multimap = ArrayListMultimap.create();
                multimap = LinkedListMultimap.create();
                multimapForParticularEvent = LinkedListMultimap.create();


                String keyTemp;
                String valueTemp;

                if(!lastPageName.equals(localPageName)) {
                    //assign last page GTM objects's count, so that only new GTM objects will be checked
                    oldGTMCount = GTMObjectsCountForParticularPage;
                }

                //get current page GTM objects' count
                GTMObjectsCountForParticularPage = GTMObjectsList.size();

                //To ignore GMT ojbects from earlier pages
                if(pageName.equals("SmavaHomePage") || pageName.equals("SmavaKreditPage") || pageName.equals("SmavaOfferPage")){
                    oldGTMCount = 0;
                }


                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + pageName +"  GTM Data <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


                for(int a=0; a < GTMObjectsList.size(); a++) {
                    try {

                               multimapForParticularEvent.clear();

                               if(a >= oldGTMCount) {
                                   System.out.println("-----------------  Key Index = " + a);

                                       for (String key : GTMObjectsList.get(a).keySet()) {

                                           System.out.println(key + "      " + String.valueOf(GTMObjectsList.get(a).get(key)));

                                           multimap.put(key, String.valueOf(GTMObjectsList.get(a).get(key)));
                                           multimapForParticularEvent.put(key, String.valueOf(GTMObjectsList.get(a).get(key)));
                                       }
                               }

                               //This code block is useful when GTM objects under particular event type needs to be checked for non null values
                               if(localEventName != null) {
                                   if (isValuePresent(multimapForParticularEvent, "event", localEventName)) {

                                       lastPageName = localPageName;
                                       //reset as method may be called again in same user story and results in incomplete GTM objects extraction
                                       localEventName = null;

                                       return true;
                                   }
                               }

                    }catch (ClassCastException exception){
                        continue;
                    }
                }

                //https://stackoverflow.com/questions/3934470/how-to-iterate-through-google-multimap
                for(Object key : multimap.keySet()){
                    System.out.println( key + "     " + multimap.get(String.valueOf(key)) );
                }

                lastPageName = localPageName;

                if(GTMObjectsList.size() > 0){
                    return true;
                }else{
                    return false;
                }

    }

    public void verifyGTM_KeyValuePair(List<List<String>> data){
        for(int i=0; i < data.size(); i++) {

            softAssertions.assertThat(isValuePresent(multimap, data.get(i).get(0), data.get(i).get(1))).as("Key-Value Check For " + localPageName +" : " + data.get(i).get(0) + " - " + data.get(i).get(1) ).isEqualTo(true);

        }
    }

    public void verifyGTM_ValueIsNotNull(List<List<String>> data){
        for(int i=0; i < data.size(); i++) {

            softAssertions.assertThat(checkForEmptyValue(multimapForParticularEvent, data.get(i).get(0))).as("Value Is Not Null Check For " + localPageName +" : " + data.get(i).get(0) ).isEqualTo(true);

        }
    }

    public void verifyGTM_KeyIsNotPresent(List<List<String>> data){
        for(int i=0; i < data.size(); i++) {

            softAssertions.assertThat( isValuePresent(multimap, data.get(i).get(0), data.get(i).get(1))).as("Key Not Present Check For " + localPageName +" : " + data.get(i).get(1) ).isEqualTo(false);

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


    public void verifyEventsOrdering(List<List<String>> data){
        for(int i=0; i < data.size(); i++) {

            softAssertions.assertThat(isParticularEventFiredPriorToAnother(multimap, "event", data.get(i).get(0), data.get(i).get(1))).as("event ordering check" + " " + data.get(i).get(0) + "  " + data.get(i).get(1) ).isEqualTo(true);
        }
    }


    public boolean isParticularEventFiredPriorToAnother(Multimap multimap, String key, String firstEvent, String secondEvent){
        if( isKeyPresent(multimap, key)) {
            System.out.println(multimap.get(key).size());

            int firstEventCounter = -1, secondEventCounter = -1;

            for(int cnt=0; cnt < multimap.get(key).size(); cnt++){

                    if(multimap.get(key).toArray()[cnt].equals(firstEvent)){
                        firstEventCounter = cnt;
                        continue;

                    }else if(multimap.get(key).toArray()[cnt].equals(secondEvent)){
                        secondEventCounter = cnt;
                        continue;
                    }

            }

            if( ( firstEventCounter != -1 && secondEventCounter != -1) && firstEventCounter < secondEventCounter){
                return true;
            }else{
                return false;
            }

        }

        return true;
    }

    public void AssertAll(){
        softAssertions.assertAll();
    }

}
