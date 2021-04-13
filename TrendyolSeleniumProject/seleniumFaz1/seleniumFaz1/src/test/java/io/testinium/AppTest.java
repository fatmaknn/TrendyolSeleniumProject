package io.testinium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-translate");
        options.addArguments("test-type");
        //options.addArguments("headless");
        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.google.com.tr");
    }


    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {

        WebElement element = webDriver.findElement(By.name("q"));
        element.sendKeys("TESTINIUM EĞİTİM");
        element.submit();

        TimeUnit.SECONDS.sleep(2);


        List<WebElement> webElements = webDriver.findElements(By.cssSelector("div#search div.g"));
        System.out.println("SIZE: " + webElements.size());
        System.out.println("TAG NAME: " + webElements.get(0).getTagName());
        System.out.println("ATTR VALUE: " + webElements.get(0).getAttribute("class"));

        //System.out.println("SOURCE" + webDriver.getPageSource());
        System.out.println("TITLE: " + webDriver.getTitle());
        System.out.println("TITLE: " + webDriver.getCurrentUrl());


        //webElements.get(0).click();
        //TimeUnit.SECONDS.sleep(2);

    }

    @Test
    public void selectOptionTest() throws InterruptedException {
        webDriver.navigate().to("https://iki-tarih-arasindaki-gun-sayisini.hesaplama.net/");
        Select select = new Select(webDriver.findElement(By.id("gun")));
        select.selectByVisibleText("6");
        TimeUnit.SECONDS.sleep(2);
        Select selectMonth = new Select(webDriver.findElement(By.name("ay")));
        selectMonth.selectByValue("6");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("SELECTED: " + selectMonth.getFirstSelectedOption().getText());
    }

    @Test
    public void deneme() throws Exception {
        webDriver.navigate().to("https://www.trendyol.com/");

    }

    @Test
    public void actionsTest() throws InterruptedException {
        webDriver.navigate().to("https://www.hepsiburada.com");
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.id("myAccount"))).build().perform();
        TimeUnit.SECONDS.sleep(5);

        WebElement element = webDriver.findElement(By.cssSelector(""));
        boolean isDisplayed = element.isDisplayed();

    }

    @Test
    public void shouldAnswerWith() throws InterruptedException {
        //webDriver.get("https://www.google.com.tr");

        WebElement element = webDriver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("EĞİTİM");

        TimeUnit.SECONDS.sleep(2);

    }

    @Test
    public void switchToTest() {
        webDriver.getWindowHandle();
        webDriver.getWindowHandles();
        webDriver.switchTo().window("");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
