package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarPage extends BaseTest {
    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }
      @FindBy(className = "text")
    public List<WebElement> SidebarButton;

    //------------------------

    public void clickOnTextBoxButton () {
        for (int i =0; i< SidebarButton.size();i++) {
            if (SidebarButton.get(i).getText().equals("Text Box"))
            {SidebarButton.get(i).click();
                break;}
        }
    }


    public void clickOnCheckBoxButton () {
        for (int i =0; i< SidebarButton.size();i++) {
            if (SidebarButton.get(i).getText().equals("Check Box"))
            {SidebarButton.get(i).click();
                break;}
        }
    }

    public void clickOnRadioButton () {
        for (int i =0; i< SidebarButton.size();i++) {
            if (SidebarButton.get(i).getText().equals("Radio Button"))
            {SidebarButton.get(i).click();
                break;}
        }
    }

    public void clickOnWebTablesButton () {
        for (int i =0; i< SidebarButton.size();i++) {
            if (SidebarButton.get(i).getText().equals("Web Tables"))
            {SidebarButton.get(i).click();
                break;}
        }
    }

    public void clickOnButtonsButton () {
        for (int i =0; i< SidebarButton.size();i++) {
            if (SidebarButton.get(i).getText().equals("Buttons"))
            {SidebarButton.get(i).click();
                break;}
        }
    }

    public void clickOnLinksButton () {
        for (int i =0; i< SidebarButton.size();i++) {
            if (SidebarButton.get(i).getText().equals("Links"))
            {SidebarButton.get(i).click();
                break;}
        }
    }

    public void clickOnBrokenLinksImagesButton () {
        for (int i =0; i< SidebarButton.size();i++) {
            if (SidebarButton.get(i).getText().equals("Broken Links - Images"))
            {SidebarButton.get(i).click();
                break;}
        }
    }

    public void clickOnUploadAndDownloadButton () {
        for (int i =0; i< SidebarButton.size();i++) {
            if (SidebarButton.get(i).getText().equals("Upload and Download"))
            {SidebarButton.get(i).click();
                break;}
        }
    }

    public void clickOnDynamicPropertiesButton () {
        for (int i =0; i< SidebarButton.size();i++) {
            if (SidebarButton.get(i).getText().equals("Dynamic Properties"))
            {SidebarButton.get(i).click();
                break;}
        }
    }
}
