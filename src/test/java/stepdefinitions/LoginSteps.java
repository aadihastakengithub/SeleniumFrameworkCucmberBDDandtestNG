package stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelUtils;

import java.io.IOException;


public class LoginSteps extends BaseTest {

    //WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);;
    
    String url = ConfigReader.getProperty("url");



    @Given("user is on login page")
    public void user_is_on_login_page() {
        //loginPage = new LoginPage(driver);
        //driver = BaseTest.getDriver();
        loginPage.getUrl();
        //loginPage = new LoginPage(driver);

    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        String user = ExcelUtils.getCellValue("testdata/data.xlsx", "Sheet1", 0, 0);
        String pass = ExcelUtils.getCellValue("testdata/data.xlsx", "Sheet1", 0, 1);
         loginPage.login(user,pass);
         loginPage.explicitWait();

    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() throws IOException {
        //loginPage.validate();
        test = extent.createTest("BDD Login Test");
        String screenshotPath = takeScreenshot("BDD_LoginTest");
        test.addScreenCaptureFromPath(screenshotPath);
        //System.out.println("You are in then block");
        loginPage.validate();

    }

    @And("logout button should be visible.")
    public void logoutButtonShouldBeVisible() {
        loginPage.validateLogout();
    }
}
