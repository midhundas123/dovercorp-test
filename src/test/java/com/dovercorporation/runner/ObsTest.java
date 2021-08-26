package com.dovercorporation.runner;


import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        glue = "com.dovercorporation.step",
        tags = "@Regression",
        plugin = { "pretty" , "html:target/cucumber.html" , "json:target/cucumber.json " , "json:target/cucumber-report/cucumber.json"

        })
public class ObsTest {
}
