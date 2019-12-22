package org.example.pages.elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.WebElement;

public interface ResultField extends AtlasWebElement<WebElement> {
    default String get() {
        return this.getText();
    }
}
