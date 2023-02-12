package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegistrationFormPage extends BaseTest {
    public RegistrationFormPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "firstName")
    public WebElement FirstName;
    @FindBy (id = "lastName")
    public WebElement LastName;
    @FindBy (id = "userEmail")
    public WebElement Email;
    @FindBy (id = "age")
    public WebElement Age;
    @FindBy (id = "salary")
    public WebElement Salary;
    @FindBy (id = "department")
    public WebElement Department;
    @FindBy (id = "submit")
    public WebElement SubmitButton;
    @FindBy (className = "close")
    public WebElement CloseModal;



    //-------------------------------------------------

    public void enterFirstName (String firstname) {
        FirstName.clear();
        FirstName.sendKeys(firstname);
    }
    public void leaveFirstNameBlank () {
        FirstName.clear();
    }
    public void enterLastName (String lastname) {
        LastName.clear();
        LastName.sendKeys(lastname);
    }
    public void leaveLastNameBlank () {
        LastName.clear();
    }
    public void enterDepartment(String department) {
       Department.clear();
       Department.sendKeys(department);
    }
    public void leaveDepartmentEmpty () {
        Department.clear();
    }
    public void enterEmail (String email) {
       Email.clear();
       Email.sendKeys(email);
    }
    public void leaveEmailEmpty () {
        Email.clear();
    }

    public void enterSalary (int salary) {
        Salary.clear();
        Salary.sendKeys(String.valueOf(salary));
    }
    public void enterSalaryForComparison (String salary) {
        Salary.clear();
        Salary.sendKeys(salary);
    }

    public void leaveSalaryBlank () {
        Salary.clear();
    }
    public void enterAge (int age) {
        Age.clear();
        Age.sendKeys(String.valueOf(age));
    }
    public void enterAgeForComparison (String age) {
        Age.clear();
        Age.sendKeys(age);
    }
    public void leaveAgeEmpty () {
        Age.clear();
    }
    public void clickOnSubmitButton () {
        SubmitButton.click();
    }

    public void clickCloseModal () {
        CloseModal.click();
    }

    public String placeholderFirstName () {
        return FirstName.getAttribute("placeholder");
    }
    public String placeholderLastName () {
        return LastName.getAttribute("placeholder");
    }
    public String placeholderEmail () {
        return Email.getAttribute("placeholder");
    }
    public String placeholderDepartment () {
        return Department.getAttribute("placeholder");
    }
    public String placeholderAge () {
        return Age.getAttribute("placeholder");
    }
    public String placeholderSalary () {return Salary.getAttribute("placeholder");
    }


}
