package de.smava.cucumber.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OfferPage extends PageObject {

    @FindBy(xpath="//div[contains(text(),\"In wenigen Schritten zu Ihrem Kredit\")]")
    WebElement InWenigenSchrittenZuIhremKreditTitle;

    @FindBy(xpath="//div[@class=\"icon-checkmark2\"]")
    WebElement GreenCheckMark;

    public boolean isOfferPageLoadedSuccessfully(){
        try{
             int timeCounter = 0;

             while (timeCounter <= 20) {

                 if ( getDriver().findElements(By.xpath("//div[contains(text(),\"In wenigen Schritten zu Ihrem Kredit\")]")).size() > 0
                         &&
                      getDriver().findElements(By.xpath("//div[@class=\"icon-checkmark2\"]")).size() > 0) {
                     return true;
                 } else {
                     timeCounter++;
                     Thread.sleep(1000);
                     continue;
                 }
             }

             return  false;

        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

}
