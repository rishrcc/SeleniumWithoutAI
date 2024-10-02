package StepDefinitions;

import Helpers.LoginHelper;
import TestData.LoginData;
import Utility.BrowserDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class LoginDef {

    public WebDriver driver;
    public LoginHelper LoginStep;


    public LoginDef()
    {
        driver = BrowserDriver.getDriver();
        LoginStep = new LoginHelper(driver);
    }

    @Given("^I am logged in with valid user$")
    public void i_am_logged_in_with_username_and_password() {
        LoginStep.userLogin();
    }

}
