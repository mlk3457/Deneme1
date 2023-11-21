package com.devbook.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports.html",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/feature",
        glue = "com/devbook/stepDefinitions",
        dryRun = false,
        tags = "@mlk"
)
public class CukesRunner {
}
