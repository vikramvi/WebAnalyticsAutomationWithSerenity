package de.smava.cucumber.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EinkommenStep2Page extends PageObject {

    @FindBy(xpath="//*[@id=\"applicant0.income.monthlyIncome\"]")
    WebElement MonatlichesNettoeinkommenInputField;

    @FindBy(xpath="//*[@id=\"applicant0.income.incomeConstantOverThreeMonths-true\"]")
    WebElement EinkommenkonstantJaButton;

    @FindBy(xpath="//*[@id=\"applicant0.income.partTimeJob-false\"]")
    WebElement EinkommenAusNebenbeschäftigungNeinButton;

    @FindBy(xpath="//*[@id=\"applicant0.income.additionalIncomesyes-no-false\"]")
    WebElement WeiteresEinkommenNeinButton;

    @FindBy(xpath="//*[@id=\"applicant0.income.creditCardType-DEBIT_CARD_ONLY\"]")
    WebElement ECKarteButton;

    @FindBy(xpath="//*[@id=\"applicant0.income.thirdPartyLoansyes-no-false\"]")
    WebElement bestehendeKrediteNeinButton;

    @FindBy(xpath="//div[@class=\"block\"]//button[@class=\"button button_primary form-buttons__button-next\"]")
    WebElement WeiterButton;



    public void fillEinkommenStep2PageInfoAndGotoNextPage(){
        inputMonatlichesNettoeinkommen();
        clickEinkommenKonstantJaButton();
        clickNebenbeschäftigungNeinButton();
        clickWeiteresEinkommenNeinButton();
        clickWeiteresEinkommenNeinButton();
        clickECKarteButton();
        clickBaufinanzierungenAngebenNeinButton();
        clickBaufinanzierungenAngebenNeinButton();
        clickWeiterbutton();
    }

    public void inputMonatlichesNettoeinkommen(){
        MonatlichesNettoeinkommenInputField.sendKeys("4000");
    }

    public void clickEinkommenKonstantJaButton(){
        EinkommenkonstantJaButton.click();
    }

    public void clickNebenbeschäftigungNeinButton(){
        EinkommenAusNebenbeschäftigungNeinButton.click();
    }

    public void clickWeiteresEinkommenNeinButton(){
        WeiteresEinkommenNeinButton.click();
    }

    public void clickECKarteButton(){
        ECKarteButton.click();
    }

    public void clickBaufinanzierungenAngebenNeinButton(){
        bestehendeKrediteNeinButton.click();
    }

    public void clickWeiterbutton(){
        WeiterButton.click();
    }

    public boolean isEinkommenStep2PageLoaded(){
        if(bestehendeKrediteNeinButton.isEnabled()){
            return true;
        }else{
            return false;
        }
    }
}
