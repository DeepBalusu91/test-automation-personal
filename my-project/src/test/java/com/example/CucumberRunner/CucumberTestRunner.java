package com.example.CucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", // Path to the feature file
        glue = "com.example.StepDefs",
        publish = true,
        plugin = {"json:target/cucumber-reports/Cucumber.json",
                "pretty",
                "html:target/cucumber-reports.html"
        }
)
public class CucumberTestRunner {
}
