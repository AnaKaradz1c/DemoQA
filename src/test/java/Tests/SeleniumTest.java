package Tests;

import BaseTest.BaseTest;
import Pages.HomePage;
import Pages.SeleniumPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(baseURL);
        homePage = new HomePage();
        seleniumPage = new SeleniumPage();

      }

      @Test
    public void userRedirectedToTheSeleniumPage () {
        String expectedUrl = excelReader.getStringData("URL", 1, 1);
        homePage.clickOnSeleniumBanner();
        newTab();
          Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertTrue(isDisplayed(seleniumPage.GoToRegistrationButton));
        Assert.assertEquals(seleniumPage.getSubtitle(), "Selenium Certification Training | Enroll Now | Study Online");
      }

      @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
