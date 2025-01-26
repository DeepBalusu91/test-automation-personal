package com.example.CucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Greetings.feature", // Path to the feature file
        glue = "com.example.StepDefs" // Package containing step definitions
)
public class CucumberTestRunner {
}
