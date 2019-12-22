package org.example.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.Тогда;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.core.context.RetryerContext;
import io.qameta.atlas.core.internal.DefaultRetryer;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.example.pages.ResultPage;
import org.example.pages.StartGooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class CommonSteps {
    private Atlas atlas;
    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.atlas = new Atlas(new WebDriverConfiguration(webDriver))
                .context(new RetryerContext(new DefaultRetryer(10_000L, 1_000L, Collections.singletonList(Throwable.class))));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

    protected <T> T atPage(Class<T> tClass) {
        return atlas.create(webDriver, tClass);
    }

    @Дано("открыта страница Google с калькулятором")
    public void открытаСтраницаGoogleСКалькулятором() {
        atPage(StartGooglePage.class).open();
        atPage(StartGooglePage.class).search("1-1");
        Assert.assertTrue(atPage(ResultPage.class).calc().isDisplayed(), "Калькулятор не отобразился");
    }

    @Если("набрать на клавиатуре калькулятора {string}")
    public void набратьНаКлавиатуреКалькулятора(String expression) {
        atPage(ResultPage.class)
                .calc().type(expression);
    }

    @Тогда("в поле результата будет {string}")
    public void вПолеРезультатаБудет(String exResult) {
        final String actualResult = atPage(ResultPage.class).calc().calcResult().get();
        Assert.assertEquals(actualResult, exResult,
                "Результат операции не соответствует");
    }
}
