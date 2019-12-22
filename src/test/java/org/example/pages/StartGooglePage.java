package org.example.pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.Keys;

public interface StartGooglePage extends WebPage {
    @FindBy("//*[@name='q']")
    AtlasWebElement searchField();

    default void search(String s) {
        searchField().sendKeys(s, Keys.ENTER);
    }
}
