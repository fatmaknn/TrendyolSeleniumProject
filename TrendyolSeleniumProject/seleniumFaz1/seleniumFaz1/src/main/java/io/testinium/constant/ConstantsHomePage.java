package io.testinium.constant;

import org.openqa.selenium.By;

public class ConstantsHomePage extends ConstantsMainPage {

    public static final By WOMEN = By.className("homepage-popup-img");
    public static final By SEARCH = By.className("search-box");
    public static final By PRODUCT = By.xpath("//div[contains(text(), 'logitech')]");
    public static final By SELECT = By.xpath("//*[@class='sort-fltr-cntnr']/select");
    public static final By WEBCAM = By.xpath("//*[@data-id='2378692']");
    public static final By EVALUATION = By.xpath("//*[@class='pr-rnr-sm-p-s']");
    public static final By CHANGE_PRODUCT = By.xpath("//div[contains(text(), 'A4 Tech')]");
    public static final By ASC_PRODUCT = By.xpath("//*[@data-id='49365487']");
    public static final By COMMENT = By.xpath("//*[@class='rnr-com-w']");
    public static final By ADD_TO_CHART = By.xpath("//*[@data-id='49365487']//*[@class='add-to-basket-button']");

}
