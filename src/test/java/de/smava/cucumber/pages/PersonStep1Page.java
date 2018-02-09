package de.smava.cucumber.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonStep1Page extends PageObject {

    @FindBy(xpath="//a[@id=\"applicant0.personal.salutation-MR\"]")
    WebElement HerrButton;

    @FindBy(xpath="//*[@id=\"applicant0.personal.firstName\"]")
    WebElement VornameInputField;

    @FindBy(xpath="//*[@id=\"applicant0.personal.lastName\"]")
    WebElement NachnameInputField;

    @FindBy(xpath="//*[@id=\"applicant0.personal.birthDate\"]")
    WebElement GeburtsdatumInputField;

    @FindBy(xpath="//*[@id=\"applicant0.contacts.phoneMobile\"]")
    WebElement TelefonInputField;

    @FindBy(xpath="//*[@id=\"applicant0.contacts.email\"]")
    WebElement EmailInputField;

    @FindBy(xpath="//span[@class=\"checkbox__input-mask\"]")
    WebElement SchufaAgreementCheckBox;

    @FindBy(xpath="//div[@class=\"block\"]//button[@class=\"button button_primary form-buttons__button-next\"]")
    WebElement WeiterButton;


    public static final String vorname = "darth";
    public static final String nachname = "vader";
    public static final String geburtsdatum = "02.02.1972";
    public static final String telefon = "015215215263";
    public static final String emailPrefix = "darth.vader.smava";
    public static String emailForReuse = null;


    public void fillPersonStep1PageInfoAndGotoNextPage(){
        clickHerrButton();
        enterVorname();
        enterNachname();
        enterGeburtsdatum();
        enterTelefon();
        enterEmail();
        clickSchufaCheckBox();
        clickWeiterbutton();
    }

    //https://github.com/serenity-bdd/serenity-core/issues/1116
    //https://intranet.smava.de/jira/browse/WEB-450
    public void fillPersonStep1PageInfoAndGotoNextPageWithSameEmailId(boolean isCookiesSet){
        if(!isCookiesSet) {
            clickHerrButton();
            enterVorname();
            enterNachname();
            enterGeburtsdatum();
            enterTelefon();
            enterExistingEmail();
            clickSchufaCheckBox();
            clickWeiterbutton();
        }else{
            clickSchufaCheckBox();
            clickWeiterbutton();
        }
    }

    public void clickHerrButton(){
        HerrButton.click();
    }

    public void enterVorname(){
        VornameInputField.sendKeys(vorname);
    }


    public void enterNachname(){
        NachnameInputField.sendKeys(nachname);
    }

    public void enterGeburtsdatum(){
        GeburtsdatumInputField.sendKeys(geburtsdatum);
    }

    public void enterTelefon(){
        TelefonInputField.sendKeys(telefon);
    }

    public void enterEmail(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();

        EmailInputField.sendKeys(emailPrefix + dateFormat.format(date) + "@gmail.com");
    }

    public void enterExistingEmail(){
        if( emailForReuse == null ){
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date();
            emailForReuse = emailPrefix +  dateFormat.format(date) + "@gmail.com";
        }

        EmailInputField.sendKeys(emailForReuse);
    }

    public void clickSchufaCheckBox(){
        SchufaAgreementCheckBox.click();
    }

    public void clickWeiterbutton(){
        WeiterButton.click();
    }

    public boolean isPersonStep1PageLoaded(){
        if(SchufaAgreementCheckBox.isEnabled()){
            return true;
        }else{
            return false;
        }
    }

}
