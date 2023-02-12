package BaseTest;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

public static WebDriver driver;
public  WebDriverWait wdwait;
public ExcelReader excelReader;
public String baseURL;
public HomePage homePage;
public SeleniumPage seleniumPage;
public ElementsPage elementsPage;
public SidebarPage sidebarPage;
public TextBoxPage textBoxPage;
public CheckBoxPage checkBoxPage;
public RadioButtonPage radioButtonPage;
public WebTablesPage webTablesPage;
public RegistrationFormPage registrationFormPage;
    ArrayList<String> listaTabova;


    @BeforeClass
    public void setUp () throws IOException {
    WebDriverManager.chromedriver().setup();
    excelReader = new ExcelReader("src/test/java/DemoQA.xlsx");
    baseURL = excelReader.getStringData("URL", 1, 0);
}

    public void goToElementsPage() {
        for (int i = 0; i < homePage.Cards.size(); i++) {
            if (homePage.Cards.get(i).getText().equals("Elements")) {
                scrollToElement(homePage.Cards.get(i));}
        }
        homePage.clickOnElementsCard();
        String expectedUrl = excelReader.getStringData("URL", 1 ,2);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertEquals(elementsPage.getElementsTitle(), "Elements");
        Assert.assertEquals(elementsPage.getElementText(), "Please select an item from left to start practice.");

    }

    public boolean isDisplayed (WebElement element) {
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
    }
    public boolean isEmpty(List<WebElement> elements) {
        boolean webelement = false;

        try {
            webelement = elements.isEmpty();
        } catch (Exception e) {

        }
        return webelement;
    }
    public void waitForVisibility (WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability (WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollToBottom () {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }
    public void newTab () {
        ArrayList<String> listaTabova  = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
