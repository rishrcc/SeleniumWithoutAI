package Helpers;

import Pages.LoginPage;
import TestData.LoginData;
import Utility.BrowserDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class LoginHelper extends BrowserDriver {

    public WebDriverWait wait;

    public LoginHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void userLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LoginPage.txtUsername)));
        driver.findElement(By.cssSelector(LoginPage.txtUsername)).sendKeys(LoginData.User_Rishabh.USER_EMAIL.getValue());
        driver.findElement(By.cssSelector(LoginPage.txtPassword)).sendKeys(LoginData.User_Rishabh.USER_PASSWORD.getValue());
        driver.findElement(By.xpath(LoginPage.btnLogin)).click();
        selectDB();
    }

    public void selectDB(){
        //Formation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPage.btnpreprodDBHP)));
        driver.findElement(By.xpath(LoginPage.btnpreprodDBHP)).click();
    }

    public void selectDBEC(){
        //Expert Comptable
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPage.btnpreprodDBEC)));
        driver.findElement(By.xpath(LoginPage.btnpreprodDBEC)).click();
    }

}
