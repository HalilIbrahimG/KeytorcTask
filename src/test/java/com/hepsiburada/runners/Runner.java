package com.hepsiburada.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",       // cucumber test report
                  "html:target/default-html-reports",// html test report
                  "rerun:target/rerun.txt" // if any tests fail, this keeps failed scenarios
        },
        features = "src/test/resources/features",
        glue = "com/hepsiburada/stepDefs",
        dryRun = false, // true -> focus on the implementation (undefined definitions)
                       // false -> code will execute inside the each step definitions
        tags = "@task"
)
public class Runner {
}
