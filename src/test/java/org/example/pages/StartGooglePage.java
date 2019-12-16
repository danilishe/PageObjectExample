package org.example.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class StartGooglePage {
    @Step("Открываем страницу Google")
    public StartGooglePage open() {
        Selenide.open("https://google.com");
        return this;
    }

    @Step("Выполняем поиск на стартовой странице \"{s}\"")
    public ResultPage search(String s) {
        $(By.name("q")).sendKeys(s, Keys.ENTER);
        return new ResultPage();
    }
}
