package com.trend.testcases;

import com.trend.pages.*;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void loginApp() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        logger.info("HomePage title control");
        homePage.homePageTitleTest();

        LoginPage loginPage = new LoginPage(driver);
        logger.info("LoginPage login");
        loginPage.loginToTrend(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
        logger.info("LoginPage login success control");
        loginPage.loginSuccessControl();

        SearchPage searchPage = new SearchPage(driver);
        logger.info("SearchPage Bilgisayar search");
        searchPage.searchComputer("Bilgisayar");
        logger.info("SearchPage write product text");
        searchPage.writeProductText();


        BasketPage basketPage = new BasketPage(driver);
        logger.info("BasketPage add product");
        basketPage.addProduct();
        logger.info("BasketPage product price compare");
        basketPage.priceCompare();

        logger.info("BasketPage product from 1 to 2");
        basketPage.countProductControl();
        logger.info("BasketPage product delete");
        basketPage.productDelete();
    }
}
