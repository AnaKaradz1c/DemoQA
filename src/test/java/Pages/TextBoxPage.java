package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseTest {
    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "main-header")
    public WebElement TextBoxHeader;

    @FindBy (xpath = "/html/body/div[2]/header/a")
    public WebElement ToolsQAButton;

    @FindBy (id = "userName")
    public WebElement FullNameField;

    @FindBy (id = "userEmail")
    public WebElement EmailField;

    @FindBy (id = "currentAddress")
    public WebElement CurrentAddressField;

    @FindBy (id = "permanentAddress")
    public WebElement PermanentAddressField;

    @FindBy (id = "submit")
    public WebElement SubmitButton;

    @FindBy (id = "name")
    public WebElement NameOutput;

    @FindBy (id = "email")
    public WebElement EmailOutput;

    @FindBy (id = "currentAddress")
    public WebElement CurrentAddressOutput;

    @FindBy (id = "permanentAddress")
    public WebElement PermanentAddressOutput;

    @FindBy (id = "output")
    public WebElement OutputBox;



    //--------------------------------------

    public String getHeaderText () {
        return TextBoxHeader.getText();
    }

    public void clickOnToolsButton () {
        ToolsQAButton.click();
    }

    public void enterFullName (String fullname) {
        FullNameField.clear();
        FullNameField.sendKeys(fullname);
    }

    public void leaveFullNameBlank () {
        FullNameField.clear();
    }

    public void enterEmail (String email) {
        EmailField.clear();
        EmailField.sendKeys(email);
    }

    public void leaveEmailBlank () {
        EmailField.clear();
    }

    public void enterCurrentAddress (String currentAddress) {
        CurrentAddressField.clear();
        CurrentAddressField.sendKeys(currentAddress);
    }

    public void leaveCurrentAddressBlank () {
        CurrentAddressField.clear();
    }

    public void enterPermanentAddress (String permanentAddress) {
        PermanentAddressField.clear();
        PermanentAddressField.sendKeys(permanentAddress);
    }

    public void leavePermanentAddressBlank () {
        PermanentAddressField.clear();
    }

    public void clickOnSubbmitButton () {
        SubmitButton.click();
    }

    public String fullNameOutputText () {
        return NameOutput.getText();
    }

    public String emailOutputText () {
        return EmailOutput.getText();
    }

    public String currentAddressOutputText () {
        return CurrentAddressOutput.getText();
    }

    public String permanentAddressOutputText () {
        return PermanentAddressOutput.getText();
    }

       public String placeholderFullName () {
        return FullNameField.getAttribute("placeholder");
    }

    public String placeholderEmail () {
        return EmailField.getAttribute("placeholder");
    }

    public String placeholderCurrentAddress () {
        return CurrentAddressField.getAttribute("placeholder");
    }

    public String placeholderPermanentAddress () {
        return PermanentAddressField.getText();
    }

}
