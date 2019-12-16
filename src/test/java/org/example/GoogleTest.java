package org.example;

import org.example.pages.GoogleCalc;
import org.example.pages.StartGooglePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest {
    GoogleCalc calc;

    @DataProvider
    public static Object[][] positive() {
        return new Object[][]{
                {"1 + 2 - 3 =", "0"},
                {"5 * 7 =", "35"},
                {"14 / 7 % * 80 =", "16000"},
                {"1 / 0 =", "Infinity"},
                {"999999999 x! =", "Infinity"},
        };
    }

    @BeforeTest
    public void setUp() {
        calc = new StartGooglePage().open()
                .search("1-1")
                .googleCalc();
    }

    @Test(dataProvider = "positive")
    public void testDigits(String input, String exResult) {
        final String result = calc.type(input)
                .getResult();
        Assert.assertEquals(result, exResult);
    }

    @AfterTest
    public void clearResult() {
        calc.clearAll();
    }

}
