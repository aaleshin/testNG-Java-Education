package test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport", "json:target/cucumber.json"},
        tags = { "~@ignore" }
    )
public class CucumberIT extends AbstractTestNGCucumberTests {
}
