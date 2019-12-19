package org.example.steps;


import io.cucumber.java.ru.*;

public class GoogleTestSteps {
    @Дано("открыта страница с калькулятором")
    public void открытаСтраницаСКалькулятором() {
    }

    @Если("набрать на калькуляторе при помощи клавиш {string}")
    public void набратьНаКалькулятореПриПомощиКлавиш(String expression) {

    }

    @Тогда("в поле результата будет отображено {string}")
    public void вПолеРезультатаБудетОтображено(String expectedResult) {

    }
}
