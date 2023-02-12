package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BaseTest {
    public RadioButtonPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy (className = "main-header")
    public WebElement RadioButtonTitle;

    @FindBy (className = "custom-control-label")
    public List<WebElement> RadioButton;


    @FindBy (className = "mt-3")
    public WebElement ClickMessage;

    //----------------------------------------------------

    public String getHeaderText () {
        return RadioButtonTitle.getText();
    }
    public void clickYesRadioButton () {
        for (int i =0; i< RadioButton.size();i++) {
            if (RadioButton.get(i).getText().equals("Yes"))
            {RadioButton.get(i).click();
                break;}
        }
    }

    public void clickImpressiveRadioButton () {
        for (int i =0; i< RadioButton.size();i++) {
            if (RadioButton.get(i).getText().equals("Impressive"))
            {RadioButton.get(i).click();
                break;}
        }
    }

    public void clickNoRadioButton () {
        for (int i =0; i< RadioButton.size();i++) {
            if (RadioButton.get(i).getText().equals("No"))
            {RadioButton.get(i).click();
                break;}
        }
    }

    public String clickMessageText () {
        return ClickMessage.getText();
    }

}
