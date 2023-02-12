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

public class WebTablesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(baseURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        sidebarPage = new SidebarPage();
        webTablesPage = new WebTablesPage();
        registrationFormPage = new RegistrationFormPage();

    }
    public void goToWebTablesPage () {
        sidebarPage.clickOnWebTablesButton();
        String expectedUrl = excelReader.getStringData("URL", 1, 6);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertEquals(webTablesPage.getHeaderText(), "Web Tables");
    }

    public void enterValidElements () {
        webTablesPage.clickOnAddNewRecordButton();
        waitForClickability(registrationFormPage.FirstName);
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1, 5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
    }

    public void initialAssertionNumberOfDeleteIcons() {
        int numberOfDeleteIcons = 0;
        for (int i = 0; i < webTablesPage.DeleteIcon.size(); i++) {
            numberOfDeleteIcons ++;
        }
        Assert.assertEquals(numberOfDeleteIcons, 3);
    }
    public void oneAddedEntryAssertionNumberOfDeleteIcons () {int newNumberOfDeleteIcons = 0;
        for (int i = 0; i < webTablesPage.DeleteIcon.size(); i++) {
            newNumberOfDeleteIcons ++;
        }
        Assert.assertEquals(newNumberOfDeleteIcons, 4);}

    //--------------------VALID ENTRIES--------------------------

    @Test (priority = 10)
    public void validAddEntry () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
        enterValidElements();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i =0; i< webTablesPage.TableElement.size(); i++) {
            if (webTablesPage.TableElement.get(i).getText().equals("Karadzic")) {
                Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"Karadzic");
            }
            break;
        }
    }
   @Test (priority = 10)
    public void validAddNewEntryFirstNameMaxCharacters () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
      webTablesPage.clickOnAddNewRecordButton();
      String validFirstName = excelReader.getStringData("RegistrationForm", 2,0);
      String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
      String validEmail = excelReader.getStringData("RegistrationForm", 1,2);
      int validAge = excelReader.getIntegerData("RegistrationForm", 1,3);
      int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
      String validDepartment = excelReader.getStringData("RegistrationForm", 1,5);
      registrationFormPage.enterFirstName(validFirstName);
      registrationFormPage.enterLastName(validLastName);
      registrationFormPage.enterEmail(validEmail);
      registrationFormPage.enterAge(validAge);
      registrationFormPage.enterSalary(validSalary);
      registrationFormPage.enterDepartment(validDepartment);
      registrationFormPage.clickOnSubmitButton();
       oneAddedEntryAssertionNumberOfDeleteIcons();
       for (int i =0; i< webTablesPage.TableElement.size(); i++) {
           if (webTablesPage.TableElement.get(i).getText().equals("Anaanaanaanaanaanaanaanaa")) {
               Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"Anaanaanaanaanaanaanaanaa");
           }
           break;
       }
    }

    @Test (priority = 10)
    public void validAddNewEntryFirstNameMinCharacters () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 3,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1,2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1,3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i =0; i< webTablesPage.TableElement.size(); i++) {
            if (webTablesPage.TableElement.get(i).getText().equals("A")) {
                Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"A");
            }
            break;
        }
    }
    @Test (priority = 10)
    public void validAddNewEntryLastNameMaxCharacters () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 2,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1,2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1,3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i =0; i< webTablesPage.TableElement.size(); i++) {
            if (webTablesPage.TableElement.get(i).getText().equals("Karadzickaradzickaradzick")) {
                Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"Karadzickaradzickaradzick");
            }
            break;
        }
    }
    @Test (priority = 10)
    public void validAddNewEntryLastNameMinCharacters () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 3,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1,2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1,3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i =0; i< webTablesPage.TableElement.size(); i++) {
            if (webTablesPage.TableElement.get(i).getText().equals("K")) {
                Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"K");
            }
            break;
        }
    }
    @Test (priority = 10)
    public void validAddNewEntryAgeMaxValue () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1,2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 2,3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i =0; i< webTablesPage.TableElement.size(); i++) {
            if (webTablesPage.TableElement.get(i).getText().equals("99")) {
                Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"99");
            }
            break;
        }
    }
    @Test (priority = 10)
    public void validAddNewEntryAgeMinValue () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1,2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 3,3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i =0; i< webTablesPage.TableElement.size(); i++) {
            if (webTablesPage.TableElement.get(i).getText().equals("0")) {
                Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"0");
            }
            break;
        }
    }
    @Test (priority = 10)
    public void validAddNewEntrySalaryMaxValue () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1,2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1,3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 2, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i =0; i< webTablesPage.TableElement.size(); i++) {
            if (webTablesPage.TableElement.get(i).getText().equals("9999999999")) {
                Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"9999999999");
            }
            break;
        }
    }
    @Test (priority = 10)
    public void validAddNewEntrySalaryMinValue () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1,2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1,3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 3, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i =0; i< webTablesPage.TableElement.size(); i++) {
            if (webTablesPage.TableElement.get(i).getText().equals("0")) {
                Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"0");
            }
            break;
        }
    }
    @Test (priority = 10)
    public void validAddNewEntryDepartmentMaxCharacters () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1,2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1,3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 2,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i =0; i< webTablesPage.TableElement.size(); i++) {
            if (webTablesPage.TableElement.get(i).getText().equals("DepartmentdepartmentMaint")) {
                Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"DepartmentdepartmentMaint");
            }
            break;
        }
    }
    @Test (priority = 10)
    public void validAddNewEntryDepartmentMinCharacters () {
        goToElementsPage();
        goToWebTablesPage();
        initialAssertionNumberOfDeleteIcons();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1,2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1,3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 3,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i =0; i< webTablesPage.TableElement.size(); i++) {
            if (webTablesPage.TableElement.get(i).getText().equals("D")) {
                Assert.assertEquals(webTablesPage.TableElement.get(i).getText(),"D");
            }
            break;
        }
    }

    @Test (priority = 10)
    public void validCloseRegistrationFormWithoutAffectingTheTable () {
        goToElementsPage();
        goToWebTablesPage();
       initialAssertionNumberOfDeleteIcons();
        webTablesPage.clickOnAddNewRecordButton();
        waitForClickability(registrationFormPage.FirstName);
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.clickCloseModal();
        initialAssertionNumberOfDeleteIcons();
    }

    @Test (priority = 20)
    public void validDeleteAllThePreviousEntries () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        oneAddedEntryAssertionNumberOfDeleteIcons();
        for (int i= webTablesPage.DeleteIcon.size()-1; i>=0; i--) {
            scrollToElement(webTablesPage.DeleteIcon.get(i));
            waitForClickability(webTablesPage.DeleteIcon.get(i));
            webTablesPage.DeleteIcon.get(i).click();
        }
        int newNumberOfDeleteIcons = 0;
        for (int i=0; i<webTablesPage.DeleteIcon.size(); i++) {
            newNumberOfDeleteIcons ++;
        }
        Assert.assertEquals(newNumberOfDeleteIcons, 0);
    }

    @Test (priority = 20)
    public void validPerformSearchThroughSearchBar () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        Assert.assertEquals(webTablesPage.placeholderSearchBox(), "Type to search");
        webTablesPage.enterTextInSearchBox(validFirstName);

    }
 //--------------------VERIFYING SORTING ---------------------------------------------------

    @Test (priority = 30)
    public void tableHeaderFirstNameSortsTableEntriesAlphabeticallyAscending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnFirstName();
        Assert.assertTrue(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertFalse(isDisplayed(webTablesPage.DescendingOrderTable));
    }

    @Test (priority = 30)
    public void tableHeaderFirstNameSortsTableEntriesAlphabeticallyDescending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnFirstName();
        webTablesPage.clickOnFirstName();
        Assert.assertFalse(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertTrue(isDisplayed(webTablesPage.DescendingOrderTable));
    }
    @Test (priority = 30)
    public void tableHeaderLastNameSortsTableEntriesAlphabeticallyAscending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnLastName();
        Assert.assertTrue(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertFalse(isDisplayed(webTablesPage.DescendingOrderTable));
    }

    @Test (priority = 30)
    public void tableHeaderLastNameSortsTableEntriesAlphabeticallyDescending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnLastName();
        webTablesPage.clickOnLastName();
        Assert.assertFalse(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertTrue(isDisplayed(webTablesPage.DescendingOrderTable));
    }

    @Test (priority = 30)
    public void tableHeaderAgeSortsTableEntriesNumericallyAscending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnAge();
        Assert.assertTrue(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertFalse(isDisplayed(webTablesPage.DescendingOrderTable));
    }

    @Test (priority = 30)
    public void tableHeaderAgeSortsTableEntriesNumericallyDescending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnAge();
        webTablesPage.clickOnAge();
        Assert.assertFalse(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertTrue(isDisplayed(webTablesPage.DescendingOrderTable));
    }

    @Test (priority = 30)
    public void tableHeaderEmailSortsTableEntriesAlphabeticallyAscending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnEmail();
        Assert.assertTrue(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertFalse(isDisplayed(webTablesPage.DescendingOrderTable));
    }

    @Test (priority = 30)
    public void tableHeaderEmailSortsTableEntriesAlphabeticallyDescending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnEmail();
        webTablesPage.clickOnEmail();
        Assert.assertFalse(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertTrue(isDisplayed(webTablesPage.DescendingOrderTable));
    }

    @Test (priority = 30)
    public void tableHeaderSalarySortsTableEntriesNumericallyAscending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnSalary();
        Assert.assertTrue(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertFalse(isDisplayed(webTablesPage.DescendingOrderTable));
    }

    @Test (priority = 30)
    public void tableHeaderSalarySortsTableEntriesNumericallyDescending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnSalary();
        webTablesPage.clickOnSalary();
        Assert.assertFalse(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertTrue(isDisplayed(webTablesPage.DescendingOrderTable));
    }
    @Test (priority = 30)
    public void tableHeaderDepartmentSortsTableEntriesAlphabeticallyAscending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnDepartment();
        Assert.assertTrue(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertFalse(isDisplayed(webTablesPage.DescendingOrderTable));
    }

    @Test (priority = 30)
    public void tableHeaderDepartmentSortsTableEntriesAlphabeticallyDescending () {
        goToElementsPage();
        goToWebTablesPage();
        enterValidElements();
        webTablesPage.clickOnDepartment();
        webTablesPage.clickOnDepartment();
        Assert.assertFalse(isDisplayed(webTablesPage.AscendingOrderTable));
        Assert.assertTrue(isDisplayed(webTablesPage.DescendingOrderTable));
    }


    //------------------------INVALID ENTRIES ---------------------------------

    @Test (priority = 40)
    public void invalidAddNewEntryFirstNameBlank () {
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        waitForClickability(registrationFormPage.FirstName);
        String validLastName = excelReader.getStringData("RegistrationForm", 1,1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1, 5);
        registrationFormPage.leaveFirstNameBlank();
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        Assert.assertEquals(registrationFormPage.placeholderFirstName(), "First Name");
    }

    @Test (priority = 40)
    public void invalidAddNewEntryLastNameBlank () {
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1, 5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.leaveLastNameBlank();
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        Assert.assertEquals(registrationFormPage.placeholderLastName(), "Last Name");

    }

    @Test (priority = 40)
    public void invalidAddNewEntryEmailBlank () {
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1, 5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.leaveEmailEmpty();
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        Assert.assertEquals(registrationFormPage.placeholderEmail(), "name@example.com");

    }

    @Test (priority = 40)
    public void invalidAddNewEntryAgeBlank () {
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1, 5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.leaveAgeEmpty();
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        Assert.assertEquals(registrationFormPage.placeholderAge(), "Age");
    }

    @Test (priority = 40)
    public void invalidAddNewEntrySalaryBlank () {
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        String validDepartment = excelReader.getStringData("RegistrationForm", 1, 5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.leaveSalaryBlank();
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        Assert.assertEquals(registrationFormPage.placeholderSalary(), "Salary");
    }

    @Test (priority = 40)
    public void invalidAddNewEntryDepartmentBlank () {
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.leaveDepartmentEmpty();
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        Assert.assertEquals(registrationFormPage.placeholderDepartment(), "Department");
    }

    @Test (priority = 50)
    public void invalidAddNewEntryFirstNameNumericCharacter () {
        // test will fail, because the form numbers
        goToElementsPage();
        goToWebTablesPage();
        waitForClickability(webTablesPage.AddNewRecordButton);
         webTablesPage.clickOnAddNewRecordButton();
         String invalidFirstName = excelReader.getStringData("RegistrationForm", 1,6);
         String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
         String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
         int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
         int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
         String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
         registrationFormPage.enterFirstName(invalidFirstName);
         registrationFormPage.enterLastName(validLastName);
         registrationFormPage.enterEmail(validEmail);
         registrationFormPage.enterAge(validAge);
         registrationFormPage.enterSalary(validSalary);
         registrationFormPage.enterDepartment(validDepartment);
         registrationFormPage.clickOnSubmitButton();
         Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        }
    @Test (priority = 50)
    public void invalidAddNewEntryFirstNameSpecialCharacter () {
        // test will fail, because the form allows special characters
        goToElementsPage();
        goToWebTablesPage();
        waitForClickability(webTablesPage.AddNewRecordButton);
        webTablesPage.clickOnAddNewRecordButton();
        String invalidFirstName = excelReader.getStringData("RegistrationForm", 2,6);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(invalidFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
    }
    @Test (priority = 50)
    public void invalidAddNewEntryFirstNameExceedsMaxCharacters () {
        // test will fail, because the form removes extra characters after space 25
        goToElementsPage();
        goToWebTablesPage();
        waitForClickability(webTablesPage.AddNewRecordButton);
        webTablesPage.clickOnAddNewRecordButton();
        String invalidFirstName = excelReader.getStringData("RegistrationForm", 3,6);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(invalidFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
    }
    @Test (priority = 50)
    public void invalidAddNewEntryFirstNameLowerCaseCharacters () {
        // test will fail, because the form allows only lower letter characters
        goToElementsPage();
        goToWebTablesPage();
        waitForClickability(webTablesPage.AddNewRecordButton);
        webTablesPage.clickOnAddNewRecordButton();
        String invalidFirstName = excelReader.getStringData("RegistrationForm", 4,6);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(invalidFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
    }


    @Test (priority = 50)
    public void invalidAddNewEntryLastNameNumericCharacters () {
        // test will fail, because the form allows numeric characters
        goToElementsPage();
        goToWebTablesPage();
       webTablesPage.clickOnAddNewRecordButton();
            String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
            String invalidLastName = excelReader.getStringData("RegistrationForm", 1, 7);
            String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
            int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
            int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
            String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
            registrationFormPage.enterFirstName(validFirstName);
            registrationFormPage.enterLastName(invalidLastName);
            registrationFormPage.enterEmail(validEmail);
            registrationFormPage.enterAge(validAge);
            registrationFormPage.enterSalary(validSalary);
            registrationFormPage.enterDepartment(validDepartment);
            registrationFormPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
             scrollToElement(webTablesPage.AddNewRecordButton);
        }
    @Test (priority = 50)
    public void invalidAddNewEntryLastNameSpecialCharacters () {
        // test will fail, because the form allows special characters
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String invalidLastName = excelReader.getStringData("RegistrationForm", 2, 7);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(invalidLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        scrollToElement(webTablesPage.AddNewRecordButton);
    }
    @Test (priority = 50)
    public void invalidAddNewEntryLastNameExceedsMaxCharacters () {
        // test will fail, because the form removes extra characters after space 25
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String invalidLastName = excelReader.getStringData("RegistrationForm", 3, 7);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(invalidLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        scrollToElement(webTablesPage.AddNewRecordButton);
    }
    @Test (priority = 50)
    public void invalidAddNEwEntryLastNameLowerCase () {
     // test will fail, the form allows lower case only entry for last name
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String invalidLastName = excelReader.getStringData("RegistrationForm", 4, 7);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(invalidLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        scrollToElement(webTablesPage.AddNewRecordButton);
    }

    @Test (priority = 50)
    public void invalidAddNewEntryInvalidEmail () {
        goToElementsPage();
        goToWebTablesPage();
        for (int i =1; i <= excelReader.getLastRow("RegistrationForm"); i++) {
            waitForClickability(webTablesPage.AddNewRecordButton);
            webTablesPage.clickOnAddNewRecordButton();
            String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
            String validLastName = excelReader.getStringData("RegistrationForm",1 , 1);
            String validEmail = excelReader.getStringData("RegistrationForm", i, 8);
            int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
            int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
            String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
            registrationFormPage.enterFirstName(validFirstName);
            registrationFormPage.enterLastName(validLastName);
            registrationFormPage.enterEmail(validEmail);
            registrationFormPage.enterAge(validAge);
            registrationFormPage.enterSalary(validSalary);
            registrationFormPage.enterDepartment(validDepartment);
            registrationFormPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
            registrationFormPage.clickCloseModal();
            scrollToElement(webTablesPage.AddNewRecordButton);

        }
    }

    @Test (priority = 50)
    public void invalidAddNewEntryAgeSpecialCharacter () {
        goToElementsPage();
        goToWebTablesPage();
         waitForClickability(webTablesPage.AddNewRecordButton);
            webTablesPage.clickOnAddNewRecordButton();
            String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
            String validLastName = excelReader.getStringData("RegistrationForm",1 , 1);
            String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
            String invalidAge = excelReader.getStringData("RegistrationForm", 1, 9);
            int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
            String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
            registrationFormPage.enterFirstName(validFirstName);
            registrationFormPage.enterLastName(validLastName);
            registrationFormPage.enterEmail(validEmail);
            registrationFormPage.enterAgeForComparison(invalidAge);
            registrationFormPage.enterSalary(validSalary);
            registrationFormPage.enterDepartment(validDepartment);
            registrationFormPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));

        }
    @Test (priority = 50)
    public void invalidAddNewEntryAgeAlphabeticCharacter () {
        goToElementsPage();
        goToWebTablesPage();
        waitForClickability(webTablesPage.AddNewRecordButton);
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm",1 , 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        String invalidAge = excelReader.getStringData("RegistrationForm", 2, 9);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAgeForComparison(invalidAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));

    }

    @Test (priority = 50)
    public void invalidAddNewEntryExceededAgeLimit () {
        // test will fail, because the form removes extra digit after space 99
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm",1 , 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int invalidAge = excelReader.getIntegerData("RegistrationForm", 3, 9);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(invalidAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
    }
    @Test (priority = 50)
    public void invalidAddNewEntryAgeNegative () {
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm",1 , 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int invalidAge = excelReader.getIntegerData("RegistrationForm", 4, 9);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(invalidAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
    }
    @Test (priority = 50)
    public void invalidAddNewEntrySalarySpecialCharacter() {
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
            String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
            String validLastName = excelReader.getStringData("RegistrationForm",1 , 1);
            String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
            int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
            String invalidSalary = excelReader.getStringData("RegistrationForm", 1, 10);
            String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
            registrationFormPage.enterFirstName(validFirstName);
            registrationFormPage.enterLastName(validLastName);
            registrationFormPage.enterEmail(validEmail);
            registrationFormPage.enterAge(validAge);
            registrationFormPage.enterSalaryForComparison(invalidSalary);
            registrationFormPage.enterDepartment(validDepartment);
            registrationFormPage.clickOnSubmitButton();
            Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));

        }

    @Test (priority = 50)
    public void invalidAddNewEntrySalaryAlphabeticCharacter() {
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm",1 , 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        String invalidSalary = excelReader.getStringData("RegistrationForm", 2, 10);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalaryForComparison(invalidSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));


    }
    @Test (priority = 50)
    public void invalidAddNewEntryExceededSalaryLimit() {
        // test will fail, because the form removes extra digit
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm",1 , 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int invalidSalary = excelReader.getIntegerData("RegistrationForm", 3, 10);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(invalidSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));


    }
    @Test (priority = 50)
    public void invalidAddNewEntrySalaryNegative() {

        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm",1 , 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int invalidSalary = excelReader.getIntegerData("RegistrationForm", 4, 10);
        String validDepartment = excelReader.getStringData("RegistrationForm",1,5);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(invalidSalary);
        registrationFormPage.enterDepartment(validDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));

    }
    @Test (priority = 50)
    public void invalidAddNewEntryInvalidDepartmentExceededMaxCharacters () {
        //test will fail, the form removes extra characters after space 25
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String invalidDepartment = excelReader.getStringData("RegistrationForm",1,11);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(invalidDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        Assert.assertFalse(isDisplayed(webTablesPage.AddNewRecordButton));
        }
    @Test (priority = 50)
    public void invalidAddNewEntryDepartmentSpecialCharacters () {
        //test will fail, the form allows special characters
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String invalidDepartment = excelReader.getStringData("RegistrationForm",2,11);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(invalidDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        Assert.assertFalse(isDisplayed(webTablesPage.AddNewRecordButton));
    }
    @Test (priority = 50)
    public void invalidAddNewEntryDepartmentNumericCharacters () {
        //test will fail, the form allows numeric characters
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String invalidDepartment = excelReader.getStringData("RegistrationForm",3,11);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(invalidDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        Assert.assertFalse(isDisplayed(webTablesPage.AddNewRecordButton));
    }

    @Test (priority = 50)
    public void invalidAddNEwEntryDepartmentLowerCase () {
        //test will fail, the form allows lower case
        goToElementsPage();
        goToWebTablesPage();
        webTablesPage.clickOnAddNewRecordButton();
        String validFirstName = excelReader.getStringData("RegistrationForm", 1,0);
        String validLastName = excelReader.getStringData("RegistrationForm", 1, 1);
        String validEmail = excelReader.getStringData("RegistrationForm", 1, 2);
        int validAge = excelReader.getIntegerData("RegistrationForm", 1, 3);
        int validSalary = excelReader.getIntegerData("RegistrationForm", 1, 4);
        String invalidDepartment = excelReader.getStringData("RegistrationForm",4,11);
        registrationFormPage.enterFirstName(validFirstName);
        registrationFormPage.enterLastName(validLastName);
        registrationFormPage.enterEmail(validEmail);
        registrationFormPage.enterAge(validAge);
        registrationFormPage.enterSalary(validSalary);
        registrationFormPage.enterDepartment(invalidDepartment);
        registrationFormPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(registrationFormPage.SubmitButton));
        Assert.assertFalse(isDisplayed(webTablesPage.AddNewRecordButton));
    }
    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
