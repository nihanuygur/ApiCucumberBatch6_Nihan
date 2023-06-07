package com.devex.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/default-html-reports.html",
        },
features = "src/test/resources/features",
        glue = "com/devex/stepDefs",
        dryRun = false,
        tags = "@wip"


)





public class CukesRunner {

}
