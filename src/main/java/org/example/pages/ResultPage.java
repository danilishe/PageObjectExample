package org.example.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class ResultPage {
    public ResultPage() {
        $x("//*[@id='hdtb']").shouldBe(Condition.visible);
    }

    public GoogleCalc googleCalc() {
        return new GoogleCalc();
    }

    public GoogleVideoResult googleVideoResult() {
        return new GoogleVideoResult();
    }
}
