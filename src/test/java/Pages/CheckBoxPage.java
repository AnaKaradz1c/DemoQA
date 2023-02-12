package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseTest {
    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (className = "main-header")
    public WebElement CheckBoxTitle;
    @FindBy (css = ".rct-option.rct-option-expand-all")
    public  WebElement ExpandAllButton;
    @FindBy (css = ".rct-option.rct-option-collapse-all")
    public WebElement CollapseAllButton;
    @FindBy(className = "rct-title")
    public List<WebElement> CheckBoxName;
    @FindBy (css = ".rct-icon.rct-icon-uncheck")
    public List<WebElement> CheckBoxUnchecked;
    @FindBy (css = ".rct-icon.rct-icon-check")
    public List<WebElement> CheckBoxChecked;
    @FindBy (css = ".rct-icon.rct-icon-half-check")
    public List<WebElement> CheckBoxHalfChecked;
    @FindBy (css = ".rct-icon.rct-icon-parent-close")
    public WebElement HomeFolderClosed;
    @FindBy (css = ".rct-icon.rct-icon-parent-open")
    public WebElement HomeFolderOpen;
    @FindBy (css = ".display-result.mt-4")
    public WebElement DisplayResult;
    //--------------------------------

    public String checkBoxTitleText () {
        return CheckBoxTitle.getText();
    }
    public void clickExpandAllButton () {
        ExpandAllButton.click();
    }
    public void clickCollapseAllButton () {
        CollapseAllButton.click();
   }
    public void clickOnDocumentsCheckBoxName () {
        for (int i =0; i< CheckBoxName.size();i++) {
            if (CheckBoxName.get(i).getText().equals("Documents"))
            {CheckBoxName.get(i).click();
                break;}
        }
    }
    public void clickOnReactCheckBoxName () {
        for (int i =0; i< CheckBoxName.size();i++) {
            if (CheckBoxName.get(i).getText().equals("React"))
            {CheckBoxName.get(i).click();
                break;}
        }
    }
    public void clickOnNotesCheckBoxName () {
        for (int i =0; i< CheckBoxName.size();i++) {
            if (CheckBoxName.get(i).getText().equals("Notes"))
            {CheckBoxName.get(i).click();
                break;}
        }
    }
    public void clickOnPublicCheckBox () {
        for (int i =0; i< CheckBoxName.size();i++) {
            if (CheckBoxName.get(i).getText().equals("Public"))
            {CheckBoxName.get(i).click();
                break;}
        }
    }
    public void clickOnWordFileCheckBox () {
        for (int i =0; i< CheckBoxName.size();i++) {
            if (CheckBoxName.get(i).getText().equals("Word File.doc"))
            {CheckBoxName.get(i).click();
                break;}
        }
    }
    public String displayResultText () {
       return DisplayResult.getText();
    }
}
