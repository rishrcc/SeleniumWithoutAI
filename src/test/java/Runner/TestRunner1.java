package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features", // Path to your feature file(s)
        glue = {"StepDefinitions", "Utility"},// Package where your step definitions are located
        tags = "@Group1",
        plugin = {"pretty", "html:target/cucumber-html-reports.html", "json:cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner1 {

}
