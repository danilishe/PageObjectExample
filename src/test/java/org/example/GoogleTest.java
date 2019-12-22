package org.example;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        glue = {"org.example.steps", "org.example.hooks"},
        features = "src/test/resources/feature"
)
public class GoogleTest extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("ATLAS_WEBSITE_URL", "http://google.com/");
    }
}
