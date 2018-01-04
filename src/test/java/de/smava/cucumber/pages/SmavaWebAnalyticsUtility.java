package de.smava.cucumber.pages;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmavaWebAnalyticsUtility extends PageObject {


    private static SoftAssertions softAssertions = null;
    private static Multimap<String, String> multimap;
    private static int oldGMTCount = 0;
    private static int GMTCount = 0;
    private String localPageName = null;


    public boolean fetchGTMObjectsForGivenPage(String pageName){
        try{

            localPageName = pageName;

            if(softAssertions == null) {
                //http://joel-costigliola.github.io/assertj/core/api/org/assertj/core/api/SoftAssertions.html
                softAssertions = new SoftAssertions();
            }

            JavascriptExecutor js = (JavascriptExecutor)getDriver();

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

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void verifyGTM_KeyValuePair(List<List<String>> data){
        for(int i=0; i < data.size(); i++) {

            softAssertions.assertThat(isValuePresent(multimap, data.get(i).get(0), data.get(i).get(1))).as(localPageName +" " + data.get(i).get(0)).isEqualTo(true);
        }
    }

    public void verifyGTM_ValueIsNotNull(List<List<String>> data){
        for(int i=0; i < data.size(); i++) {

            softAssertions.assertThat(checkForEmptyValue(multimap, data.get(i).get(0))).as(localPageName +" " + data.get(i).get(0)).isEqualTo(true);
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
