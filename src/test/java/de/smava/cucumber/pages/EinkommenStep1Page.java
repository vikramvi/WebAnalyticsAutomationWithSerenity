package de.smava.cucumber.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EinkommenStep1Page extends PageObject {

    @FindBy(xpath="//*[@id=\"applicant0.household.rent\"]")
    WebElement MonatlicheWarmmieteInputField;

    @FindBy(xpath="//*[@id=\"applicant0.work.startOfOccupationDate\"]")
    WebElement BeginndesArbeitsverhaltnissesInputField;

    @FindBy(xpath="//*[@id=\"applicant0.work.tempEmployment-false\"]")
    WebElement UnbefristetButton;

    @FindBy(xpath="//*[@id=\"applicant0.work.employerName\"]")
    WebElement NameDesArbeitgebersInputField;

    @FindBy(xpath="//*[@id=\"applicant0.work.employerAddress.zipCode\"]")
    WebElement ArbeitgebersPLZInputField;

    @FindBy(xpath="//*[@id=\"applicant0.work.employerAddress.city\"]")
    WebElement ArbeitgebersOrtInputField;

    @FindBy(xpath="//input[@name=\"applicant0.work.employerStreet.street\"]")
    WebElement ArbeitgebersStrasseInputField;

    @FindBy(xpath="//*[@id=\"applicant0.work.employerStreet.houseNumber\"]")
    WebElement ArbeitgebersHausnummberInputField;

    @FindBy(xpath = "//*[@id=\"applicant0.work.employment\"]")
    WebElement BeschaftigungsverhaltnisDropDown;

    @FindBy(xpath="//*[@id=\"applicant0.work.salariedStaffType\"]")
    WebElement ArtDerBeschaftigungDropDown;

    @FindBy(xpath="//*[@id=\"applicant0.work.sectorId\"]")
    WebElement BrancheDropDown;

    @FindBy(xpath="//div[@class=\"block\"]//button[@class=\"button button_primary form-buttons__button-next\"]")
    WebElement WeiterButton;


    public void fillEinkommenStep1PageInfoAndGotoNextPage(){
        inputMonatlicheWarmmiete();
        selectBeschaftigungsverhaltnis();
        selectArtDerBeschaftigung();
        selectBranche();
        BeginnDesArbeitsverhaltnissesInputField();
        clickUnbefristet();
        inputNameDesArbeitgebers();
        inputArbeitgebersPLZ();
        inputArbeitgebersOrt();
        inputArbeitgebersStrasse();
        inputArbeitgebersNr();
        clickWeiterbutton();
    }


    public void inputMonatlicheWarmmiete(){
        MonatlicheWarmmieteInputField.sendKeys("250");
    }

    public void BeginnDesArbeitsverhaltnissesInputField(){
        BeginndesArbeitsverhaltnissesInputField.sendKeys("01.2000");
    }

    public void clickUnbefristet(){
        UnbefristetButton.click();
    }

    public void inputNameDesArbeitgebers(){
        NameDesArbeitgebersInputField.sendKeys("Tesla");
    }

    public void inputArbeitgebersPLZ(){
        ArbeitgebersPLZInputField.sendKeys("13355");
    }

    public void inputArbeitgebersOrt(){
        ArbeitgebersOrtInputField.sendKeys("Berlin");
    }

    public void inputArbeitgebersStrasse(){
        ArbeitgebersStrasseInputField.sendKeys("Badstrasse");
    }

    public void inputArbeitgebersNr(){
        ArbeitgebersHausnummberInputField.sendKeys("11");
    }


    public void selectBeschaftigungsverhaltnis(){
        Select dropDownSelection = new Select( BeschaftigungsverhaltnisDropDown);
        dropDownSelection.selectByIndex(1);
    }

    public void selectArtDerBeschaftigung(){
        Select dropDownSelection = new Select( ArtDerBeschaftigungDropDown);
        dropDownSelection.selectByIndex(1);
    }

    public void selectBranche(){
        Select dropDownSelection = new Select( BrancheDropDown);
        dropDownSelection.selectByIndex(1);
    }

    public void clickWeiterbutton(){
        WeiterButton.click();
    }

    public boolean isEinkommenStep1PageLoaded(){
        if(MonatlicheWarmmieteInputField.isEnabled()){
            return true;
        }else{
            return false;
        }
    }
}
