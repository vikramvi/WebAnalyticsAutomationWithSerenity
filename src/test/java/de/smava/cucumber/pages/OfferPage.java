package de.smava.cucumber.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.NoSuchElementException;


import java.util.concurrent.TimeUnit;

public class OfferPage extends PageObject {

    @FindBy(xpath="//div[@class=\"icon-checkmark2\"]")
    WebElementFacade GreenCheckMark;

    public boolean isOfferPageLoadedSuccessfully(){
        try{
             int explicitWaitTimeout = 120;

             GreenCheckMark.withTimeoutOf(explicitWaitTimeout, TimeUnit.SECONDS).waitUntilVisible();

             return true;

        }catch (NoSuchElementException e){
            return  false;
        }
    }

}
