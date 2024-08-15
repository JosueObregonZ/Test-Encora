package com.pb.web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.pb.web.stepdefinition"},
        monochrome = true,
        plugin = {"pretty","junit:target/XMLReports/XMLReports.xml","json:target/JSONReports/JSONReport.json","html:target/HtmlReports/HtlmlReport.html","json:target/cucumber.json"},
        tags = "@PRUEBA"

)
public class TestRunner {
}