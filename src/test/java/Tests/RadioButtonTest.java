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

public class RadioButtonTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(baseURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        sidebarPage = new SidebarPage();
        radioButtonPage = new RadioButtonPage();
    }

    public void goToRadioButtonPage () {
        sidebarPage.clickOnRadioButton();
        String expectedUrl = excelReader.getStringData("URL", 1, 5);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertEquals(radioButtonPage.getHeaderText(), "Radio Button");
    }


    @Test (priority = 10)
    public void userCanClickYesRadioButton () throws InterruptedException {
        goToElementsPage();
        goToRadioButtonPage();
        radioButtonPage.clickYesRadioButton();
        Thread.sleep(2000);
        Assert.assertEquals(radioButtonPage.clickMessageText(), "You have selected Yes");
    }

    @Test (priority = 20)
    public void userCanClickImpressiveRadioButton () {
        goToElementsPage();
        goToRadioButtonPage();
        radioButtonPage.clickImpressiveRadioButton();
        Assert.assertEquals(radioButtonPage.clickMessageText(), "You have selected Impressive");
    }

    @Test (priority = 30)
    public void userCanClickNoRadioButton () {
        // test will fail, the No radio button is inactive
        goToElementsPage();
        goToRadioButtonPage();
        radioButtonPage.clickNoRadioButton();
        Assert.assertEquals(radioButtonPage.clickMessageText(), "You have selected No");
    }


    @Test (priority = 40)
    public void userCanSelectOnlyOneRadioButtonAtATime () {
        goToElementsPage();
        goToRadioButtonPage();
        radioButtonPage.clickYesRadioButton();
        Assert.assertEquals(radioButtonPage.clickMessageText(), "You have selected Yes");
        radioButtonPage.clickImpressiveRadioButton();
        Assert.assertNotEquals(radioButtonPage.clickMessageText(), "You have selected Yes");
    }
    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
