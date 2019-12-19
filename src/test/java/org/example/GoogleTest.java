package org.example;

import com.codeborne.selenide.Selenide;
import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.example.pages.GoogleCalc;
import org.example.pages.StartGooglePage;

import java.io.IOException;
import java.nio.file.Files;

@CucumberOptions(glue = "org.example.steps", features = "src/test/resources/feature")
public class GoogleTest extends AbstractTestNGCucumberTests {
    GoogleCalc calc;

/*    public static Object[][] positive() {
        return new Object[][]{
                {"1 + 2 - 3 =", "0"},
                {"5 * 7 =", "35"},
                {"14 / 7 % * 80 =", "16000"},
                {"1 / 0 =", "Infinity"},
                {"999999999 x! =", "Infinity"},
        };
    }*/

    public void setUp() {
        calc = new StartGooglePage().open()
                .search("1-1")
                .googleCalc();
    }

    public void clearResult() throws IOException {
        String screen = Selenide.screenshot("screen");
        calc.clearAll();
    }

}
