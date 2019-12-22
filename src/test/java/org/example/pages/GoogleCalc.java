package org.example.pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.example.pages.elements.CalcButton;
import org.example.pages.elements.ResultField;
import org.openqa.selenium.WebElement;


public interface GoogleCalc extends AtlasWebElement<WebElement> {

    @FindBy(".//*[@id='cwos']")
    ResultField calcResult();

    default GoogleCalc type(String s) {
        for (String token : s.trim().split("\\s+")) {
            switch (token) {
                case "-":
                    button("−").click();
                    break;
                case "*":
                    button("×").click();
                case "/":
                    button("÷").click();
                    break;
                case "x!":
                    button("x!").click();
                    break;
                default:
                    if (token.length() > 1 && token.matches("\\D+"))
                        throw new IllegalArgumentException("Значения в выражении должны быть разделены пробелом, " +
                                "либо состоять только из цифр: [" + token + "] - не подходит");
                    for (Character key : token.toCharArray()) {
                        button(key.toString()).click();
                    }
            }
        }
        return this;
    }

    @FindBy(".//div[text()='{{ text }}']")
    CalcButton button(@Param("text") String key);

    default GoogleCalc clearAll() {
        button("AC").click();
        return this;
    }

    default GoogleCalc removeSymbol() {
        button("CE").click();
        return this;
    }
}
