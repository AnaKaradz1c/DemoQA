package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class SeleniumPage extends BaseTest {
    public SeleniumPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".btn.btn-primary-shadow.btn-block")
    public WebElement GoToRegistrationButton;

    @FindBy (className = "enroll__heading")
    public WebElement Subtitle;

    //------------------------------------------

    public String getSubtitle () {
        return Subtitle.getText();
    }
}
