package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "banner-image")
    WebElement SeleniumBanner;

    @FindBy (className = "card-body")
    public List <WebElement> Cards;

    //----------------------------------------


    public void  clickOnSeleniumBanner () {
        SeleniumBanner.click();
    }
    public void clickOnElementsCard () {
        for (int i =0; i< Cards.size();i++) {
            if (Cards.get(i).getText().equals("Elements"))
            {Cards.get(i).click();
            break;}
        }
    }

    public void clickOnFormsCard () {
        for (int i =0; i< Cards.size();i++) {
            if (Cards.get(i).getText().equals("Forms"))
            {Cards.get(i).click();
                break;}
        }
    }

    public void clickOnAlertsFormsAndWindows () {
        for (int i =0; i< Cards.size();i++) {
            if (Cards.get(i).getText().equals("Alerts, Frame & Windows"))
            {Cards.get(i).click();
                break;}
        }
    }
    public void clickOnWidgets () {
        for (int i =0; i< Cards.size();i++) {
            if (Cards.get(i).getText().equals("Widgets"))
            {Cards.get(i).click();
                break;}
        }
    }

    public void clickOnInteractions () {
        for (int i =0; i< Cards.size();i++) {
            if (Cards.get(i).getText().equals("Interactions"))
            {Cards.get(i).click();
                break;}
        }
    }
    public void clickOnBookstoreApp () {
        for (int i =0; i< Cards.size();i++) {
            if (Cards.get(i).getText().equals("Book Store Application"))
            {Cards.get(i).click();
                break;}
        }
    }
}
