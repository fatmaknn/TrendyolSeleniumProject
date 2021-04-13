package io.testinium.page;

import io.testinium.base.BasePage;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage openMainPage(){
        return this;
    }
}
