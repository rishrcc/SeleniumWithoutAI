package Utility;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URISyntaxException;

public class Hooks {

    public static String scenarioName;
    public WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@APIHealthCheck"))
        {
            System.out.println("API TEST STARTED");
        }
        else{
            driver = BrowserDriver.getDriver();
        }
    }

    @Before
    public void startRecording(Scenario scenario) throws Exception {

        scenarioName = scenario.getName();

        if (scenario.getSourceTagNames().contains("@APIHealthCheck"))
        {
            System.out.println("NO RECORDING");
        }
        else{
            TestRecorder.startRecording("src/test/java/Recording/" + scenarioName);
        }

    }

    @AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@APIHealthCheck"))
        {
            System.out.println("NO SCREENSHOT");
        }
        else{
            BrowserDriver.takeScreenshotAfterStep(scenario);
        }
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {

        if (scenario.getSourceTagNames().contains("@APIHealthCheck"))
        {
            System.out.println("NO RECORDING");
            SendResult.addResultTolist(scenario);
        }
        else{
            SendResult.addResultTolist(scenario);
            TestRecorder.stopRecording();
            BrowserDriver.quitDriver(scenario);
        }

    }

    @AfterAll
    public static void afterAllScenarios() throws URISyntaxException, IOException {
        SendResult.formatAndStoreFinalResults();
        SendResult.sendReportToGoogle();
    }
}

