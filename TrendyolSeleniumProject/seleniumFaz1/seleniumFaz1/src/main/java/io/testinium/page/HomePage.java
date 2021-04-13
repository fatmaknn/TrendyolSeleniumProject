package io.testinium.page;

import io.testinium.base.BasePage;
import org.openqa.selenium.WebDriver;

import static io.testinium.constant.ConstantsHomePage.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage openHomePage() {
        navigateUrl("https://www.trendyol.com/");
        logger.info("SAYFA AÇILDI...");
        return this;
    }

    public HomePage selectWomen() throws Exception {
        //hoverElement(WOMEN);
        timeUnitSeconds(2);
        click(WOMEN);
        logger.info("KADIN SEÇENEĞİ SEÇİLDİ!!");
        timeUnitSeconds(2);
        //takeSnapShot("screenshot/accoun.png");
        return this;
    }

    public HomePage searchProduct() {
        sendKeys(SEARCH, "Webcam");
        sendEnter(SEARCH);
        timeUnitSeconds(2);
        logger.info("WEBCAM ÜRÜNÜ ARATILDI!!!");


        return this;
    }

    public HomePage selectProduct() {
        click(PRODUCT);
        timeUnitSeconds(2);
        logger.info("MARKA SEÇİLDİ!!");
        selectByValue(SELECT,"PRICE_BY_ASC");
        timeUnitSeconds(3);
        logger.info("FİYATLAR SIRALANDI!!");
        click(WEBCAM);
        switchTab(EVALUATION);
        //logger.info(getText(EVALUATION));

        return this;
    }

    public HomePage changeProduct(){

        click(PRODUCT);
        timeUnitSeconds(1);
        click(CHANGE_PRODUCT);
        logger.info("MARKA DEĞİŞTİRİLDİ!!");
        click(ASC_PRODUCT);
        logger.info("EN UCUZ ÜRÜN SEÇİLDİ!!");
        timeUnitSeconds(3);
        switchTab(COMMENT);
        //logger.info(getText(COMMENT));
        click(ADD_TO_CHART);
        logger.info("ÜRÜN SEPETE EKLENDİ!!");
        return this;
    }


}
