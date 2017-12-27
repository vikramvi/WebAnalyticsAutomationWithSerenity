package de.smava.cucumber.pages;

import java.security.Key;
import java.util.*;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.json.simple.JSONObject;

import de.smava.cucumber.SmavaHomePageTest;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.SoftAssertions;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@DefaultUrl("https://www.smava.de/")
public class SmavaHomePage extends PageObject{

    @FindBy(xpath="//*[@id=\"myselect\"]/div/div[@class='text']")
    private WebElement Nettokreditbetrag;

    @FindBy(xpath="//*[@id=\"myselect\"]/div/input")
    private WebElement NettokreditbetragInputField;

    @FindBy(xpath="//div[@id='myselect2']/div/i[@class='dropdown icon']")
    private WebElement LaufZeit;

    @FindBy(xpath="//*[@id=\"myselect2\"]/div/input")
    private WebElement LaufZeitInputField;

    @FindBy(xpath="//div[@id='myselect3']/div/i[@class='dropdown icon']")
    private WebElement Verwendung;

    @FindBy(xpath="//div[@class=\"cont\"]/button[@id=\"loanSelectionForward\"]")
    private WebElement JetztVergleichenButton;


    @FindBy(xpath="//*[@id=\"x-application\"]/div[@class='progress-bar block']//a[contains(@href,'smava.de')]")
    private WebElement KreditStepZuruckButton;

    @FindBy(xpath="//section[@id=\"x-application\"]//a[@href='#ContactInfo']")
    private WebElement KreditStepWeiterButton;

    @FindBy(xpath="//div/a[text()='Anmelden'][1]")
    private WebElement AnmeldenButton;

    @FindBy(xpath="//input[@id=\"signonForm.email\"]")
    private WebElement EmailInputField;

    @FindBy(xpath="//input[@id=\"signonForm.password\"]")
    private WebElement PasswordInputField;

    @FindBy(xpath="//*[@id=\"signonForm\"]/button")
    private WebElement AnmeldenButtonFromLoginDialog;


    private String NettokreditbetragInputFieldValueSelectionXpath = "//*[@id=\"myselect\"]/div/div[2]/div[REPLACE_ME]";
    private String NettokreditbetragValuesListXpath = "//*[@id=\"myselect\"]/div/div[2]/div";

    private String LaufZeitInputFieldValueSelectionXpath = "//*[@id=\"myselect2\"]/div/div[2]/div[REPLACE_ME]";
    private String LaufZeitValuesListXpath = "//*[@id=\"myselect2\"]/div/div[2]/div";

    private String VerwendungSelectionXpath = "//*[@id=\"myselect3\"]/div/div[2]/div[REPLACE_ME]";
    private String VerwendungValuesListXpath = "//*[@id=\"myselect3\"]/div/div[2]/div";


    private SoftAssertions softAssertions ;


    /*public void verifyGTMValueOn_SmavaHomePage(){
        try{
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
            Multimap<String, String> multimap = ArrayListMultimap.create();

            String keyTemp;
            String valueTemp;


            SmavaHomePageTest.GMTCount = myList.size();


            System.out.println("-----------------  Smava Home Page GTM Data ------------------");

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


            //http://joel-costigliola.github.io/assertj/core/api/org/assertj/core/api/SoftAssertions.html
            softAssertions = new SoftAssertions();

            softAssertions.assertThat(isValuePresent(multimap, "affiliateChannel", "NA")).as("affiliateChannel").isEqualTo(true);

            softAssertions.assertThat(isValuePresent(multimap, "channel", "smava intern")).as("channel").isEqualTo(true);

            softAssertions.assertThat(isValuePresent(multimap, "gtm.uniqueEventId", "5123")).as("gtm.uniqueEventId").isEqualTo(true);

            softAssertions.assertAll();

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


    public void doSoftAssert(){

    }
*/

    public boolean inputNettokreditbetragValue(int value){
        try{

            /*JSONObject json = new JSONObject();

            JavascriptExecutor js = (JavascriptExecutor)getDriver();


            //ArrayList<String> myList = new ArrayList<String>();
            ArrayList<Map<String, List<String> >> myList = new ArrayList<>();

            ArrayList<Map<String, List<String> >> myList2 = new ArrayList<>();


            myList =  (ArrayList) js.executeScript("return window.smavaGoTaMa2016");
            myList2 = myList;

            for(int a=0; a < myList.size(); a++) {
                for (String key : myList.get(a).keySet()) {
                    System.out.println(key + "      " + myList.get(a).get(key));

                }
            }

            Map<String, List<String>> map = new HashMap<>();
            for (Map<String, List<String>> mapFromList : myList) {
                //mapFromList.
            }*/

           // Map<Key,Item> map = new HashMap<Key,Item>();

             //HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

             //for(String m : myList){
                 //map.put(m.get)
             //}

            //----------------

            Nettokreditbetrag.click();

            if(NettokreditbetragInputField.isEnabled()){
                getDriver().findElement(By.xpath(NettokreditbetragInputFieldValueSelectionXpath.replaceAll("REPLACE_ME", String.valueOf(isValidLoanAmount(value))) )).click();
                return true;
            }
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    public int isValidLoanAmount(int loanAmount){
        try{
               List<WebElement> options = getDriver().findElements(By.xpath(NettokreditbetragValuesListXpath));

               int cnt = 0;
               for(WebElement opt : options){
                   cnt++;
                   System.out.println( opt.getAttribute("data-value") );
                   if(opt.getAttribute("data-value").equals(String.valueOf(loanAmount))){
                       return cnt;
                   }
               }
               return 999;
        }catch (Exception e){
            e.printStackTrace();
            return 999;
        }
    }

    public boolean selectLaufzeitValue(int value){
        try{
            LaufZeit.click();

            if(LaufZeitInputField.isEnabled()){
                getDriver().findElement(By.xpath(LaufZeitInputFieldValueSelectionXpath.replaceAll("REPLACE_ME", String.valueOf(isValidLaufzeit(value))) )).click();
                return true;
            }

            return false;
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    public int isValidLaufzeit(int value) {
        try{
            List<WebElement> options = getDriver().findElements(By.xpath(LaufZeitValuesListXpath));

            int cnt = 0;
            for(WebElement opt : options){
                cnt++;
                System.out.println( opt.getAttribute("data-value") );
                if(opt.getAttribute("data-value").equals(String.valueOf(value))){
                    return cnt;
                }
            }

            return 999;
        }catch(Exception e){
            e.printStackTrace();
            return 999;
        }
    }

    public boolean selectVerwendungValue(String value){
        try{
            Verwendung.click();

            getDriver().findElement(By.xpath(VerwendungSelectionXpath.replaceAll("REPLACE_ME", String.valueOf(isValidVerwendung(value))) )).click();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    public int isValidVerwendung(String value) {
       try{
           List<WebElement> options = getDriver().findElements(By.xpath(VerwendungValuesListXpath));

           int cnt = 0;
           for(WebElement opt : options){
               cnt++;
               System.out.println( opt.getText() );
               if( opt.getText().equals(value) ){
                   return cnt;
               }
           }

           return 999;
       }catch(Exception e){
           e.printStackTrace();
           return 999;
       }
    }

    public boolean clickJetztVergleichenToStartWithKreditStep(){
        try {

             if(JetztVergleichenButton.isEnabled()) {
                 JavascriptExecutor executor = (JavascriptExecutor)getDriver();
                 executor.executeScript("arguments[0].click();", JetztVergleichenButton);

                 //JetztVergleichenButton.click();
                 return true;
             }else{
                 return false;
             }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean enterLoginDetailsAndSubmit(String emailId, String password){
        try{
            getDriver().manage().window().maximize();
            AnmeldenButton.click();

            if(EmailInputField.isEnabled()){
                EmailInputField.sendKeys(emailId);
                PasswordInputField.sendKeys(password);
                AnmeldenButtonFromLoginDialog.click();
                return true;
            }
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

}
