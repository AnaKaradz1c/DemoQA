package Tests;

import BaseTest.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(baseURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        sidebarPage = new SidebarPage();
        checkBoxPage = new CheckBoxPage();
    }


    public void goToCheckBoxPage () {
        sidebarPage.clickOnCheckBoxButton();
        String expectedUrl = excelReader.getStringData("URL", 1,4);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertEquals(checkBoxPage.checkBoxTitleText(), "Check Box");
            }

    @Test (priority = 10)
    public void userCanExpandAll () {
        goToElementsPage();
        goToCheckBoxPage();
        Assert.assertTrue(isDisplayed(checkBoxPage.HomeFolderClosed));
        checkBoxPage.clickExpandAllButton();
        Assert.assertTrue(isDisplayed(checkBoxPage.HomeFolderOpen));
    }

    @Test (priority = 20)
    public void userCanCollapseAll () {
        goToElementsPage();
        goToCheckBoxPage();
        checkBoxPage.clickExpandAllButton();
        checkBoxPage.clickCollapseAllButton();
        Assert.assertTrue(isDisplayed(checkBoxPage.HomeFolderClosed));
        Assert.assertFalse(isDisplayed(checkBoxPage.HomeFolderOpen));
    }


    @Test (priority = 30)
    public void selectAllWithHomeCheckBox () {
        goToElementsPage();
        goToCheckBoxPage();
        checkBoxPage.clickExpandAllButton();
        for (int i = 0; i<checkBoxPage.CheckBoxUnchecked.size(); i++) {
            scrollToElement(checkBoxPage.CheckBoxUnchecked.get(i));
            checkBoxPage.CheckBoxUnchecked.get(i).click();
        }
    Assert.assertTrue(isEmpty(checkBoxPage.CheckBoxUnchecked));
    }

    @Test (priority = 40)
    public void deselectAllWithHomeCheckBox () {
        goToElementsPage();
        goToCheckBoxPage();
        checkBoxPage.clickExpandAllButton();
        for (int i = 0; i<checkBoxPage.CheckBoxUnchecked.size(); i++) {
            scrollToElement(checkBoxPage.CheckBoxUnchecked.get(i));
            checkBoxPage.CheckBoxUnchecked.get(i).click();
        }
        for (int i = 0; i<checkBoxPage.CheckBoxChecked.size(); i++) {
            scrollToElement(checkBoxPage.CheckBoxChecked.get(i));
            checkBoxPage.CheckBoxChecked.get(i).click();
        }
        Assert.assertTrue(isEmpty(checkBoxPage.CheckBoxChecked));
    }

    @Test (priority = 50)
    public void selectSeveralCheckboxes ()  {
        goToElementsPage();
        goToCheckBoxPage();
        checkBoxPage.clickExpandAllButton();
        checkBoxPage.clickOnNotesCheckBoxName();
        checkBoxPage.clickOnReactCheckBoxName();
        checkBoxPage.clickOnPublicCheckBox();
        scrollToBottom();
        checkBoxPage.clickOnWordFileCheckBox();
        Assert.assertEquals(checkBoxPage.displayResultText(), "You have selected :\nnotes\nreact\npublic\nwordFile");
        for (int i=0; i<checkBoxPage.CheckBoxHalfChecked.size(); i++) {
            Assert.assertTrue(isDisplayed(checkBoxPage.CheckBoxHalfChecked.get (i)));
        }
    }

    @Test (priority = 60)
    public void selectAllThenDeselectSeveral () {
        goToElementsPage();
        goToCheckBoxPage();
        checkBoxPage.clickExpandAllButton();
        for (int i = 0; i<checkBoxPage.CheckBoxUnchecked.size(); i++) {
            scrollToElement(checkBoxPage.CheckBoxUnchecked.get(i));
            checkBoxPage.CheckBoxUnchecked.get(i).click();
        }
        checkBoxPage.clickOnWordFileCheckBox();
        checkBoxPage.clickOnDocumentsCheckBoxName();
        Assert.assertEquals(checkBoxPage.displayResultText(), "You have selected :\ndesktop\nnotes\ncommands\nexcelFile");
    }


    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
