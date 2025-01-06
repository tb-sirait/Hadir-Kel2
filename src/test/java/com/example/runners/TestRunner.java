package com.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/features/"},
        glue = {"com.example"},
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

