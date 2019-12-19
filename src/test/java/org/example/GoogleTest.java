package org.example;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        glue = {"org.example.steps", "org.example.hooks"},
        features = "src/test/resources/feature",
        tags = {"@mul"}
)
public class GoogleTest extends AbstractTestNGCucumberTests {
//    @DataProvider
//    public static Object[][] positive() {
//        return new Object[][]{
//                {"1 + 2 - 3 =", "0"},
//                {"5 * 7 =", "35"},
//                {"14 / 7 % * 80 =", "16000"},
//                {"1 / 0 =", "Infinity"},
//                {"999999999 x! =", "Infinity"},
//        };
//    }
//
//    @BeforeMethod(description = "Открытие страницы калькулятора")
//    public void setUp() {
//
//    }
//
//    @Test(dataProvider = "positive", description = "Проверка выражения")
//    public void testDigits(String input, String exResult) {
//        final String result = calc.type(input)
//                .getResult();
//        Assert.assertEquals(result, exResult);
//    }
//
//    @AfterTest
//    public void clearResult() throws IOException {
//        String screen = Selenide.screenshot("screen");
//        saveScreenshot(Files.readAllBytes(Selenide.$("body").screenshot().toPath()));
//        calc.clearAll();
//    }
//
//    @Attachment(value = "Скриншот", type = "image/png")
//    public byte[] saveScreenshot(byte[] screenShot) {
//        return screenShot;
//    }
}
