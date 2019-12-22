package org.example.pages;

import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ResultPage extends WebPage {
    @FindBy("//h2[text()='Калькулятор']/following-sibling::div")
    GoogleCalc calc();
}
