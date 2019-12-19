package org.example.steps;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.Тогда;
import org.example.pages.GoogleCalc;
import org.example.pages.StartGooglePage;
import org.testng.Assert;

public class CommonSteps {
    GoogleCalc calc;

    @Дано("открыта страница Google с калькулятором")
    public void открытаСтраницаGoogleСКалькулятором() {
        calc = new StartGooglePage().open()
                .search("1-1")
                .googleCalc();
    }

    @Если("набрать на клавиатуре калькулятора {string}")
    public void набратьНаКлавиатуреКалькулятора(String expression) {
        calc.type(expression);
    }

    @Тогда("в поле результата будет {string}")
    public void вПолеРезультатаБудет(String exResult) {
        String actualResult = calc.getResult();
        Assert.assertEquals(actualResult, exResult,
                "Результат операции не соответствует");
    }
}
