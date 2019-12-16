package org.example.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class StartGooglePage {
    public StartGooglePage open() {
        Selenide.open("https://google.com");
        return this;
    }

    public ResultPage search(String s) {
        $(By.name("q")).sendKeys(s, Keys.ENTER);
        return new ResultPage();
    }
}
