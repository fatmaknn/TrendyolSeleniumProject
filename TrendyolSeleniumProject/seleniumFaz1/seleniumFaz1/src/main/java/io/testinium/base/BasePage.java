package io.testinium.base;

import io.testinium.page.MainPage;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public final Logger logger = LogManager.getLogger(BasePage.class);
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10, 400);
    }

    public WebElement findElement(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void findElements(By by, int value){
        List<WebElement> elements = webDriver.findElements(by);

        elements.get(value).click();

    }

    public void sendKeys(By by, CharSequence text) {
        WebElement element = findElement(by);
        element.clear();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
    }

    public void click(By by) {
        WebElement element = findElement(by);
        if (element != null && !element.isDisplayed()) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public Select select(By by) {
        return new Select(findElement(by));
    }

    public void selectByVisibleText(By by, String text) {
        select(by).selectByVisibleText(text);
    }

    public void selectByValue(By by, String value) {
        select(by).selectByValue(value);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void navigateUrl(String url) {
        webDriver.navigate().to(url);
    }

    public void takeSnapShot(String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webDriver);

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile = new File(fileWithPath);

        FileUtils.copyFile(SrcFile, DestFile);
    }
    public void timeUnitSeconds(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendEnter(By by){
        WebElement element = findElement(by);
        element.sendKeys(Keys.ENTER);
    }

    public void closeTab() {
        webDriver.close();
    }
    
    public void switchTab(By by){
        String parentWindow = webDriver.getWindowHandle();

        for(String childWindow:webDriver.getWindowHandles()) {
                webDriver.switchTo().window(childWindow);
        }
        logger.info(findElement(by).getText());
        webDriver.close();
        webDriver.switchTo().window(parentWindow);
    }


    public MainPage callMainPage() {
        return new MainPage(webDriver);
    }
}
