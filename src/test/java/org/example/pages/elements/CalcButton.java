package org.example.pages.elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.WebElement;

public interface CalcButton extends AtlasWebElement<WebElement> {
    default CalcButton press() {
        this.click();
        return this;
    }
}
