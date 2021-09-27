package com.hepsiburada.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/failed-html-reports"},
        features = "@target/rerun.txt", // it will execute failed test case again for the environmental issue. it does not solve the functional or coding issue
        glue = "com/hepsiburada/stepDefs"

)

public class FiledTestRerun {

}
