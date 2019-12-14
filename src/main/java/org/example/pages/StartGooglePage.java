package org.example.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class StartGooglePage {
    public StartGooglePage() {
        Selenide.open("https://google.com");
    }

    public ResultPage search(String s) {
        $(By.name("q")).sendKeys(s, Keys.ENTER);
        return new ResultPage();
    }
}
