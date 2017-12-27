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
        GeburtsortInputField.sendKeys("Berlin");
    }

    public void clickLedigButton(){
        LedigButton.click();
    }

    public void inputPLZ(){
        PLZInputField.sendKeys("13355");
    }

    public void inputInrWohnort(){
        IhrWohnortInputField.sendKeys("Berlin");
    }

    public void inputIhreStrasse(){
        IhreStrasseInputField.sendKeys("BadStrasse");
    }

    public void inputNr(){
        NrInputField.sendKeys("11");
    }

    public void inputDortWohnhaftSeit(){
        DortWohnhaftSeitInputField.sendKeys("01.2000");
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
