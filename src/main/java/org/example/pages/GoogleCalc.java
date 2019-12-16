package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleCalc {
    final SelenideElement calc = $x("//h2[text()='Калькулятор']/following-sibling::div");
    private final SelenideElement calcResult = calc.$x(".//*[@id='cwos']");

    public GoogleCalc() {
        calc.shouldBe(Condition.visible);
    }

    public String getResult() {
        return calcResult.getText();
    }

    public GoogleCalc type(String s) {
        for (String token : s.trim().split("\\s+")) {
            switch (token) {
                case "-":
                    pressButton("−");
                    break;
                case "*":
                    pressButton("×");
                    break;
                case "/":
                    pressButton("÷");
                    break;

                case "x!":
                    pressButton("x!");
                    break;
                default:
                    if (token.length() > 1 && token.matches("\\D+"))
                        throw new IllegalArgumentException("Значения в выражении должны быть разделены пробелом, " +
                                "либо состоять только из цифр: [" + token + "] - не подходит");
                    for (Character key : token.toCharArray()) {
                        pressButton(key.toString());
                    }
            }
        }
        return this;
    }

    public GoogleCalc pressButton(String key) {
        $x(".//div[text()='" + key + "']").click();
        return this;
    }

    public void clearAll() {
        $x("//div[text()='AC']").click();
    }

    public void removeSymbol() {
        $x("//div[text()='CE']").click();
    }
}
