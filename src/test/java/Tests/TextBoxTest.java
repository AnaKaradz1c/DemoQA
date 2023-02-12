package Tests;

import BaseTest.BaseTest;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.SidebarPage;
import Pages.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBoxTest extends BaseTest {




    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(baseURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        sidebarPage = new SidebarPage();
        textBoxPage = new TextBoxPage();
    }

    public void goToTextBoxPage () {
        sidebarPage.clickOnTextBoxButton();
        String expectedUrl = excelReader.getStringData("URL", 1,3);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertEquals(textBoxPage.getHeaderText(), "Text Box");
        Assert.assertTrue(isDisplayed(textBoxPage.SubmitButton));
    }

    public void invalidSubmittingAssert () {
        Assert.assertFalse(isDisplayed(textBoxPage.OutputBox));
        Assert.assertEquals(textBoxPage.placeholderFullName(), "Full Name");
        Assert.assertEquals(textBoxPage.placeholderEmail(), "name@example.com");
        Assert.assertEquals(textBoxPage.placeholderCurrentAddress(), "Current Address");
    }

    //------------------------------HAPPY PATH---------------------------------
    @Test (priority = 10)
    public void userCanSubmitValidDataInTheTextForm() {
        goToElementsPage();
        goToTextBoxPage();
        String validFullName = excelReader.getStringData("TextBox", 1, 0);
        String validEmail = excelReader.getStringData("TextBox", 1,1);
        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        String validPermanentAddress = excelReader.getStringData("TextBox", 1,3);
        textBoxPage.enterFullName(validFullName);
        textBoxPage.enterEmail(validEmail);
        textBoxPage.enterCurrentAddress(validCurrentAddress);
        textBoxPage.enterPermanentAddress(validPermanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubbmitButton();
        Assert.assertTrue(isDisplayed(textBoxPage.OutputBox));
        Assert.assertEquals(textBoxPage.fullNameOutputText(), "Name:" +validFullName);
        Assert.assertEquals(textBoxPage.emailOutputText(), "Email:"+ validEmail);

        }



        //------------------------NEGATIVE TESTS---------------------------
    @Test (priority = 20)
    public void userCannotSubmitDataFullNameBlank () {
        // test will fail, the website allows user to leave one or more fields blank
        goToElementsPage();
        goToTextBoxPage();
        String validEmail = excelReader.getStringData("TextBox", 1, 1);
        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        String validPermanentAddress = excelReader.getStringData("TextBox", 1, 3);
        textBoxPage.leaveFullNameBlank();
        textBoxPage.enterEmail(validEmail);
        textBoxPage.enterCurrentAddress(validCurrentAddress);
        textBoxPage.enterPermanentAddress(validPermanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubbmitButton();
        Assert.assertFalse(isDisplayed(textBoxPage.OutputBox));
        Assert.assertEquals(textBoxPage.placeholderFullName(), "Full Name");
    }
    @Test (priority = 20)
    public void userCannotSubmitDataEmailBlank () {
        // test will fail, the website allows user to leave one or more fields blank

        goToElementsPage();
        goToTextBoxPage();
        String validFullName = excelReader.getStringData("TextBox", 1, 0);
        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        String validPermanentAddress = excelReader.getStringData("TextBox", 1,3);
        textBoxPage.leaveEmailBlank();
        textBoxPage.enterFullName(validFullName);
        textBoxPage.enterCurrentAddress(validCurrentAddress);
        textBoxPage.enterPermanentAddress(validPermanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubbmitButton();
        Assert.assertFalse(isDisplayed(textBoxPage.OutputBox));
        Assert.assertEquals(textBoxPage.placeholderEmail(), "name@example.com");

    }

    @Test (priority = 20)
    public void userCannotSubmitDataCurrentAddressBlank () {
        // test will fail, the website allows user to leave one or more fields blank

        goToElementsPage();
        goToTextBoxPage();
        String validFullName = excelReader.getStringData("TextBox", 1, 0);
        String validEmail = excelReader.getStringData("TextBox", 1,1);
        String validPermanentAddress = excelReader.getStringData("TextBox", 1,3);
        textBoxPage.enterFullName(validFullName);
        textBoxPage.enterEmail(validEmail);
        textBoxPage.leaveCurrentAddressBlank();
        textBoxPage.enterPermanentAddress(validPermanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubbmitButton();
        Assert.assertFalse(isDisplayed(textBoxPage.OutputBox));
        Assert.assertEquals(textBoxPage.placeholderCurrentAddress(), "Current Address");

    }

    @Test (priority = 20)
    public void userCannotSubmitDataPermanentAddressBlank () {
        // test will fail, the website allows user to leave one or more fields blank

        goToElementsPage();
        goToTextBoxPage();
        String validFullName = excelReader.getStringData("TextBox", 1, 0);
        String validEmail = excelReader.getStringData("TextBox", 1,1);
        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        textBoxPage.enterFullName(validFullName);
        textBoxPage.enterEmail(validEmail);
        textBoxPage.enterCurrentAddress(validCurrentAddress);
        textBoxPage.leavePermanentAddressBlank();
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubbmitButton();
        Assert.assertFalse(isDisplayed(textBoxPage.OutputBox));
        Assert.assertEquals(textBoxPage.placeholderPermanentAddress(), "");
    }

    @Test (priority = 20)
    public void userCannotSubmitDataAllFieldsBlank () {
        goToElementsPage();
        goToTextBoxPage();
        textBoxPage.leaveFullNameBlank();
        textBoxPage.leaveEmailBlank();
        textBoxPage.leaveCurrentAddressBlank();
        textBoxPage.leavePermanentAddressBlank();
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubbmitButton();
        Assert.assertEquals(textBoxPage.placeholderFullName(), "Full Name");
        Assert.assertEquals(textBoxPage.placeholderEmail(), "name@example.com");
        Assert.assertEquals(textBoxPage.placeholderCurrentAddress(), "Current Address");

    }

    @Test (priority = 30)
    public void userCannotSubmitDataInvalidFullNameOneNameOnly () {
        //test will fail. Web page allows the user to submit Full name in various non-standard forms.
        goToElementsPage();
        goToTextBoxPage();
        scrollToElement(textBoxPage.FullNameField);
        String validEmail = excelReader.getStringData("TextBox", 1, 1);
        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        String validPermanentAddress = excelReader.getStringData("TextBox", 1, 3);
        String invalidFullName = excelReader.getStringData("TextBox", 1, 4);
        textBoxPage.enterFullName(invalidFullName);
        textBoxPage.enterEmail(validEmail);
        textBoxPage.enterCurrentAddress(validCurrentAddress);
        textBoxPage.enterPermanentAddress(validPermanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubbmitButton();
        invalidSubmittingAssert();

        }
    @Test (priority = 30)
    public void userCannotSubmitDataInvalidFullNameLowerCase () {
        //test will fail. Web page allows the user to submit Full name in various non-standard forms.
        goToElementsPage();
        goToTextBoxPage();
        scrollToElement(textBoxPage.FullNameField);
        String validEmail = excelReader.getStringData("TextBox", 1, 1);
        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        String validPermanentAddress = excelReader.getStringData("TextBox", 1, 3);
        String invalidFullName = excelReader.getStringData("TextBox", 2, 4);
        textBoxPage.enterFullName(invalidFullName);
        textBoxPage.enterEmail(validEmail);
        textBoxPage.enterCurrentAddress(validCurrentAddress);
        textBoxPage.enterPermanentAddress(validPermanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubbmitButton();
        invalidSubmittingAssert();

    }

    @Test (priority = 30)
    public void userCannotSubmitDataInvalidFullNameNumericCharacters () {
        //test will fail. Web page allows the user to submit Full name in various non-standard forms.
        goToElementsPage();
        goToTextBoxPage();
        scrollToElement(textBoxPage.FullNameField);
        String validEmail = excelReader.getStringData("TextBox", 1, 1);
        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        String validPermanentAddress = excelReader.getStringData("TextBox", 1, 3);
        String invalidFullName = excelReader.getStringData("TextBox", 3, 4);
        textBoxPage.enterFullName(invalidFullName);
        textBoxPage.enterEmail(validEmail);
        textBoxPage.enterCurrentAddress(validCurrentAddress);
        textBoxPage.enterPermanentAddress(validPermanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubbmitButton();
        invalidSubmittingAssert();

    }
    @Test (priority = 30)
    public void userCannotSubmitDataInvalidFullNameSpecialCharacters () {
        //test will fail. Web page allows the user to submit Full name in various non-standard forms.
        goToElementsPage();
        goToTextBoxPage();
        scrollToElement(textBoxPage.FullNameField);
        String validEmail = excelReader.getStringData("TextBox", 1, 1);
        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        String validPermanentAddress = excelReader.getStringData("TextBox", 1, 3);
        String invalidFullName = excelReader.getStringData("TextBox", 4, 4);
        textBoxPage.enterFullName(invalidFullName);
        textBoxPage.enterEmail(validEmail);
        textBoxPage.enterCurrentAddress(validCurrentAddress);
        textBoxPage.enterPermanentAddress(validPermanentAddress);
        scrollToElement(textBoxPage.SubmitButton);
        textBoxPage.clickOnSubbmitButton();
        invalidSubmittingAssert();

    }
    @Test (priority = 40)
    public void userCannotSubmitDataInvalidEmail () {
        goToElementsPage();
        goToTextBoxPage();
        for (int i =1; i<= excelReader.getLastRow("TextBox"); i++) {
            String validFullName = excelReader.getStringData("TextBox", 1, 0);
            String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
            String validPermanentAddress = excelReader.getStringData("TextBox", 1, 3);
            String invalidEmail = excelReader.getStringData("TextBox", i, 5);
            textBoxPage.enterFullName(validFullName);
            textBoxPage.enterEmail(invalidEmail);
            textBoxPage.enterCurrentAddress(validCurrentAddress);
            textBoxPage.enterPermanentAddress(validPermanentAddress);
            scrollToElement(textBoxPage.SubmitButton);
            textBoxPage.clickOnSubbmitButton();
            invalidSubmittingAssert();
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


    }

