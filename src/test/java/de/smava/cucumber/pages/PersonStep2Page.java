package de.smava.cucumber.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonStep2Page extends PageObject {

    @FindBy(xpath="//*[@id=\"applicant0.personal.birthplace\"]")
    WebElement GeburtsortInputField;

    @FindBy(xpath="//a[@id=\"applicant0.personal.familyStatus-UNMARRIED\"]")
    WebElement LedigButton;

    @FindBy(xpath="//input[@id=\"applicant0.address.city.zipCode\"]")
    WebElement PLZInputField;

    @FindBy(xpath="//input[@id=\"applicant0.address.city.city\"]")
    WebElement IhrWohnortInputField;

    @FindBy(xpath="//input[@placeholder=\"Ihre Straße\"]")
    WebElement IhreStrasseInputField;

    @FindBy(xpath="//input[@id=\"applicant0.address.street.houseNumber\"]")
    WebElement NrInputField;

    @FindBy(xpath="//*[@id=\"applicant0.address.moveInDate\"]")
    WebElement DortWohnhaftSeitInputField;

    @FindBy(xpath="//div[@class=\"block\"]//button[@class=\"button button_primary form-buttons__button-next\"]")
    WebElement WeiterButton;


    public static final String Geburtsort = "Berlin";
    public static final String Postleitzahl = "13355";
    public static final String Wohnort = "Berlin";
    public static final String STRASSE = "BadStrasse";
    public static final String Hausnummer = "11";
    public static final String DortWohnhaftSeit = "01.2000";

    public void fillPersonStep2PageInfoAndGotoNextPage(){
        inputGeburtsort();
        clickLedigButton();
        inputPLZ();
        inputInrWohnort();
        inputIhreStrasse();
        inputNr();
        inputDortWohnhaftSeit();
        clickWeiterbutton();
    }



    public void inputGeburtsort(){
        GeburtsortInputField.sendKeys(Geburtsort);
    }

    public void clickLedigButton(){
        LedigButton.click();
    }

    public void inputPLZ(){
        PLZInputField.sendKeys(Postleitzahl);
    }

    public void inputInrWohnort(){
        IhrWohnortInputField.sendKeys(Wohnort);
    }

    public void inputIhreStrasse(){
        IhreStrasseInputField.sendKeys(STRASSE);
    }

    public void inputNr(){
        NrInputField.sendKeys(Hausnummer);
    }

    public void inputDortWohnhaftSeit(){
        DortWohnhaftSeitInputField.sendKeys(DortWohnhaftSeit );
    }

    public void clickWeiterbutton(){
        WeiterButton.click();
    }

    public boolean isPersonStep2PageLoaded(){
        if(DortWohnhaftSeitInputField.isEnabled()){
            return true;
        }else{
            return false;
        }
    }

}
