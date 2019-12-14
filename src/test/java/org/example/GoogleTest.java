package org.example;

import org.example.pages.GoogleCalc;
import org.example.pages.StartGooglePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {
    GoogleCalc calc;

    @BeforeTest
    public void setUp() {
        calc = new StartGooglePage()
                .search("1-1")
                .googleCalc();
    }

    // 1 + 2 - 3 = 0
    @Test
    public void testDigits() {
        final String result = calc.type("1 + 2 - 3")
                .press_equalBtn()
                .result();

        Assert.assertEquals(result, "0");
    }
}
