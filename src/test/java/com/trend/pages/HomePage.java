package com.trend.pages;

import com.trend.commonfunctions.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends CommonMethods {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void homePageTitleTest() throws InterruptedException {
        clickButton(driver,"css selector", popup);
        String title = driver.getTitle();
        Assert.assertEquals(title,"En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da");
        clickButton(driver,"css selector", accountButton);
    }
}
