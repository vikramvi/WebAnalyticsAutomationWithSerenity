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

import org.assertj.core.api.SoftAssertions;

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

    @FindBy(xpath="//*[@id=\"content\"]//a[@class='ui orange big button']")
    private WebElement JetztPramieSichernButton;


    private String NettokreditbetragInputFieldValueSelectionXpath = "//*[@id=\"myselect\"]/div/div[2]/div[REPLACE_ME]";
    private String NettokreditbetragValuesListXpath = "//*[@id=\"myselect\"]/div/div[2]/div";

    private String LaufZeitInputFieldValueSelectionXpath = "//*[@id=\"myselect2\"]/div/div[2]/div[REPLACE_ME]";
    private String LaufZeitValuesListXpath = "//*[@id=\"myselect2\"]/div/div[2]/div";

    private String VerwendungSelectionXpath = "//*[@id=\"myselect3\"]/div/div[2]/div[REPLACE_ME]";
    private String VerwendungValuesListXpath = "//*[@id=\"myselect3\"]/div/div[2]/div";


    private SoftAssertions softAssertions ;

    public boolean isSmavaHomePageLoaded(){
        if(JetztVergleichenButton.isEnabled() && JetztPramieSichernButton.isEnabled() ){
            return true;
        }else{
            return false;
        }
    }

    public boolean inputNettokreditbetragValue(int value){
        try{
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
