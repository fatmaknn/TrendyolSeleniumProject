package io.testinium.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-translate");
        options.addArguments("test-type");
        //options.addArguments("headless");
        setWebDriver(new ChromeDriver(options));
        getWebDriver().get("https://www.google.com.tr");
    }

    @After
    /*
    public void close(){
        webDriver.close();
    }*/
    public void tearDown() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
