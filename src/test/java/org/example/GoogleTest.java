package org.example;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import org.example.pages.GoogleCalc;
import org.example.pages.StartGooglePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

@Epic("Тестирование калькулятора")
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

    @BeforeMethod(description = "Открытие страницы калькулятора")
    public void setUp() {
        calc = new StartGooglePage().open()
                .search("1-1")
                .googleCalc();
    }

    @Test(dataProvider = "positive", description = "Проверка выражения")
    public void testDigits(String input, String exResult) {
        final String result = calc.type(input)
                .getResult();
        Assert.assertEquals(result, exResult);
    }

    @AfterTest
    public void clearResult() throws IOException {
        String screen = Selenide.screenshot("screen");
        saveScreenshot(Files.readAllBytes(Selenide.$("body").screenshot().toPath()));
        calc.clearAll();
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
