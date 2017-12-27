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


    public void clickHerrButton(){
        HerrButton.click();
    }

    public void enterVorname(){
        VornameInputField.sendKeys("darth");
    }


    public void enterNachname(){
        NachnameInputField.sendKeys("vader");
    }

    public void enterGeburtsdatum(){
        GeburtsdatumInputField.sendKeys("02.02.1972");
    }

    public void enterTelefon(){
        TelefonInputField.sendKeys("015215215263");
    }

    public void enterEmail(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        EmailInputField.sendKeys("darth.vader.smava" + dateFormat.format(date) + "@gmail.com");
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
