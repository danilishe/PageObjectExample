package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleCalc {
    final SelenideElement calc = $x("//h2[text()='Калькулятор']/following-sibling::div");

    public GoogleCalc() {
        calc.shouldBe(Condition.visible);
    }

    public GoogleCalc press_oneBtn() {
        calc.$x(".//div[text()='1']").click();
        return this;
    }

    public GoogleCalc press_twoBtn() {
        $x(".//div[text()='2']").click();
        return this;
    }

    public GoogleCalc press_threeBtn() {
        $x(".//div[text()='3']").click();
        return this;
    }

    public GoogleCalc press_minusBtn() {
        $x(".//div[text()='−']").click();
        return this;
    }

    public GoogleCalc press_equalBtn() {
        $x(".//div[text()='=']").click();
        return this;
    }

    public GoogleCalc press_plusBtn() {
        $x(".//div[text()='+']").click();
        return this;
    }

    public String result() {
        return $x(".//*[@id='cwos']").getText();
    }


    public GoogleCalc type(String s) {
        for (char c : s.toCharArray()) {
            switch (c) {
                case '1':
                    press_oneBtn();
                    break;
                case '2':
                    press_twoBtn();
                    break;
                case '3':
                    press_threeBtn();
                    break;
                case '+':
                    press_plusBtn();
                    break;
                case '-':
                    press_minusBtn();
                    break;
            }
        }
        return this;
    }
}
