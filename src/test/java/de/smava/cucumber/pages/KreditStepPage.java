package de.smava.cucumber.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KreditStepPage extends PageObject {

   @FindBy(xpath="//div[@class='segmented']//a[@id=\"applicant0.applicantsCount-1\"]")
   WebElement NeinButton;

   @FindBy(xpath="//div[@class=\"block\"]/div[@class=\"form-buttons\"][1]/button[@class=\"button button_primary form-buttons__button-next\"]")
   WebElement WeiterButton;

   @FindBy(xpath="//*[@id=\"applicant0.applicantsCount-2\"]")
   WebElement Ja2KreditnehmerButton;


   public void clickNeinButton(){
       NeinButton.click();
   }

   public void clickWeiterButton(){
       WeiterButton.click();
   }

   public boolean isKreditStepPageLoaded(){
      if(Ja2KreditnehmerButton.isEnabled()){
         return true;
      }else{
         return false;
      }
   }

}
