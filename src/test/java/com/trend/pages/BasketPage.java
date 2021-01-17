package com.trend.pages;

import com.trend.commonfunctions.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasketPage extends CommonMethods {

    WebDriver driver;

    public BasketPage(WebDriver driver){
        this.driver = driver;
    }

    public void addProduct() throws InterruptedException {
        scroll(driver,"css selector",basketProduct);
        clickButton(driver,"css selector",basketProduct);
    }

    public void priceCompare() throws InterruptedException {
        scroll(driver,"css selector",basketButton);
        clickButton(driver,"css selector",basketButton);
        Assert.assertTrue(getText(driver,"css selector",basketPprice).contains(SearchPage.pPrice));
    }

    public void countProductControl() throws InterruptedException {
        clickButton(driver,"css selector",countProduct);
        Thread.sleep(3000);
        String count = getAttribute(driver,"css selector",countValue,"value");
        Assert.assertEquals(count,"2");
    }

    public void productDelete() throws InterruptedException {
        clickButton(driver,"css selector",deleteProd);
        clickButton(driver,"css selector",deleteProdVerify);
        Thread.sleep(3000);
        Assert.assertEquals(getText(driver,"xpath",deleteProdMessage), "Sepetinizde ürün bulunmamaktadır.");
    }
}
