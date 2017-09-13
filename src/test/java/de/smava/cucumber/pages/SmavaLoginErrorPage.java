package de.smava.cucumber.pages;

import net.thucydides.core.pages.PageObject;

public class SmavaLoginErrorPage extends PageObject{

    public boolean isErrorMessagePresent(){
        if( getDriver().getPageSource().contains("Ihre Angaben zum Einloggen sind ungültig. Bitte versuchen Sie es erneut. Bitte beachten Sie, dass Ihr Zugang bei 3 Fehlversuchen von uns vorläufig gesperrt wird") ){
            return true;
        }else{
            return false;
        }
    }
}
