package Utility;

import TestData.LoginData;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;


public class BrowserDriver {
    public static WebDriver driver;

    public BrowserDriver(WebDriver driver)
    {

        BrowserDriver.driver = driver;
    }

    public static WebDriver getDriver()
    {
        if (driver == null) {

            ChromeOptions options = new ChromeOptions();
            // Create a map to hold the preference settings
            Map<String, Object> prefs = new HashMap<>();
            // Add the preference to allow notifications
            prefs.put("profile.default_content_setting_values.notifications", 1);

            // Add the preferences to the ChromeOptions
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.get(LoginData.testUrl);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void takeScreenshotAfterStep(Scenario scenario)
    {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Step Screenshot", new ByteArrayInputStream(screenshot));
    }

    public static void quitDriver(Scenario scenario)
    {
        if (driver != null) {
            if (scenario.isFailed())
            {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
            }
            driver.quit();
            driver = null;
        }
    }
}
