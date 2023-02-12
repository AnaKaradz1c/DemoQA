package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage extends BaseTest {

    public ElementsPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "main-header")
    public WebElement ElementsTitle;

    @FindBy (id = "cbb")
    public WebElement AddCloseButton;

    @FindBy (css = ".col-12.mt-4.col-md-6")
    public WebElement ElementsText;



    //-----------------------------------

    public String getElementsTitle () {
        return ElementsTitle.getText();
    }

    public void clickOnAddCloseButton () {
        AddCloseButton.click();
    }

    public String getElementText () {
      return  ElementsText.getText();
    }


}
