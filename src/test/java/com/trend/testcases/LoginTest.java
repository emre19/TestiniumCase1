package com.trend.testcases;


import com.trend.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void loginApp() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.homePageTitleTest();

        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.loginToTrend(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
        loginPage.loginSuccessControl();

        SearchPage searchPage = PageFactory.initElements(driver,SearchPage.class);
        searchPage.searchComputer("Bilgisayar");
        searchPage.writeProductText();

        BasketPage basketPage = PageFactory.initElements(driver,BasketPage.class);
        basketPage.addProduct();
        basketPage.priceCompare();
        basketPage.countProductControl();
        basketPage.productDelete();

    }

}
