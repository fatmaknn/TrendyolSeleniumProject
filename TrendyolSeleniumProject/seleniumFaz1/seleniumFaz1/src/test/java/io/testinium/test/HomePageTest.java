package io.testinium.test;

import io.testinium.base.BaseTest;
import io.testinium.page.HomePage;
import org.junit.Before;
import org.junit.Test;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTest extends BaseTest {

    HomePage homePage;

    @Before
    public void install() {
        homePage = new HomePage(getWebDriver());
    }

    @Test
    public void openHomePageTest() throws Exception {

        homePage.openHomePage().selectWomen().searchProduct().selectProduct().changeProduct().callMainPage().openMainPage();
    }

    /*
    @Test
    public void searchProductTest() throws Exception{
        homePage.openHomePage().searchProduct().callMainPage().openMainPage();
    }

    @Test
    public void selectProductTest() throws Exception{
        homePage.openHomePage().selectProduct().callMainPage().openMainPage();
    }*/
}
