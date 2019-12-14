package org.example.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleVideoResult {
    public GoogleVideoResult() {
        $x("//div[./h3[text()='Видео']]/following-sibling::div").shouldBe(Condition.visible);
    }
}
