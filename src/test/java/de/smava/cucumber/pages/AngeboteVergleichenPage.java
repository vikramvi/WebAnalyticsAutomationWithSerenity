package de.smava.cucumber.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AngeboteVergleichenPage extends PageObject {

    @FindBy(xpath="//*[@id=\"applicant0.bank.type-ACCOUNT\"]")
    WebElement KontonummerButton;

    @FindBy(xpath="//*[@id=\"applicant0.bank.bankAccountNumber\"]")
    WebElement KontonummerInputField;

    @FindBy(xpath="//*[@id=\"applicant0.bank.bankCode\"]")
    WebElement BankleitzahlInputField;

    @FindBy(xpath="//div[@class=\"block\"]//button[@class=\"button button_primary form-buttons__button-next\"]")
    WebElement WeiterButton;

    @FindBy(xpath="//*[@id=\"dac.isUsed-false\"]")
    WebElement SchnellerBekommenNeinDankeButton;

    public void fillAngeboteVergleichenPageInfoAndGotoNextPage(){
        clickKontonummerButton();
        inputKontonummer();
        inputBankleitzahl();
        clickSchnellerBekommenNeinDankeButton();
        clickWeiterbutton();
    }


    public void clickKontonummerButton(){
        KontonummerButton.click();
    }

    public void inputKontonummer(){
        KontonummerInputField.sendKeys("123456");
    }

    public void inputBankleitzahl(){
        BankleitzahlInputField.sendKeys("10061006");
    }

    public void clickWeiterbutton(){
        WeiterButton.click();
    }

    public void clickSchnellerBekommenNeinDankeButton(){
        if( getDriver().findElements(By.xpath("//*[@id=\"dac.isUsed-false\"]")).size() > 0 ){
            SchnellerBekommenNeinDankeButton.click();
        }
    }

    public boolean isAngeboteVergleichenPageLoaded(){
        if(KontonummerButton.isEnabled()){
            return true;
        }else{
            return false;
        }
    }

}
