package de.smava.cucumber.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmavaLoanSearchKreditPage extends PageObject {
    @FindBy(xpath="//*[@id=\"x-application\"]/div[@class='progress-bar block']//a[contains(@href,'smava.de')]")
    private WebElement KreditStepZuruckButton;

    @FindBy(xpath="//section[@id=\"x-application\"]//a[@href='#ContactInfo']")
    private WebElement KreditStepWeiterButton;

    public boolean checkKreditStepPage(){
        try{
            if(KreditStepZuruckButton.isEnabled() && KreditStepWeiterButton.isEnabled()){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
