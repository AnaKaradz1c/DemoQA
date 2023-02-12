package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {
    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "main-header")
    public WebElement WebTablesTitle;
    @FindBy (id = "addNewRecordButton")
    public WebElement AddNewRecordButton;
    @FindBy (id = "searchBox")
    public WebElement SearchBox;
    @FindBy (className = "rt-resizable-header-content")
    public List<WebElement> TableHeader;
    @FindBy (className = "mr-2" )
    public List<WebElement> EditIcon;
    @FindBy (css = "span[title = 'Delete']")
    public List<WebElement> DeleteIcon;

    @FindBy (css = "div[class = 'rt-td']")
    public List<WebElement> TableElement;
    @FindBy (css = ".rt-th.rt-resizable-header.-sort-asc.-cursor-pointer")
    public WebElement AscendingOrderTable;

    @FindBy (css = ".rt-th.rt-resizable-header.-sort-desc.-cursor-pointer")
    public WebElement DescendingOrderTable;

    @FindBy (className = "rt-td")
    public List <WebElement> tableELement;


    //---------------------------------------------

    public String getHeaderText () {
        return WebTablesTitle.getText();
    }
    public void clickOnAddNewRecordButton () {
        AddNewRecordButton.click();
    }
    public void enterTextInSearchBox (String text) {
        SearchBox.clear();
        SearchBox.sendKeys(text);
    }
    public String placeholderSearchBox () {
        return SearchBox.getAttribute("placeholder");
    }
    public void clickOnFirstName () {
        for (int i =0; i< TableHeader.size();i++) {
            if (TableHeader.get(i).getText().equals("First Name"))
            {TableHeader.get(i).click();
                break;}
        }
    }
    public void clickOnLastName () {
        for (int i =0; i< TableHeader.size();i++) {
            if (TableHeader.get(i).getText().equals("Last Name"))
            {TableHeader.get(i).click();
                break;}
        }
    }
    public void clickOnAge () {
        for (int i =0; i< TableHeader.size();i++) {
            if (TableHeader.get(i).getText().equals("Age"))
            {TableHeader.get(i).click();
                break;}
        }
    }
    public void clickOnEmail () {
        for (int i =0; i< TableHeader.size();i++) {
            if (TableHeader.get(i).getText().equals("Email"))
            {TableHeader.get(i).click();
                break;}
        }
    }
    public void clickOnSalary () {
        for (int i =0; i< TableHeader.size();i++) {
            if (TableHeader.get(i).getText().equals("Salary"))
            {TableHeader.get(i).click();
                break;}
        }
    }
    public void clickOnDepartment () {
        for (int i =0; i< TableHeader.size();i++) {
            if (TableHeader.get(i).getText().equals("Department"))
            {TableHeader.get(i).click();
                break;}
        }
    }
    public void clickOnAction () {
        for (int i =0; i< TableHeader.size();i++) {
            if (TableHeader.get(i).getText().equals("Action"))
            {TableHeader.get(i).click();
                break;}
        }
    }






}
