package com.trend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class BasketPage {

    WebDriver driver;

    public BasketPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(className = "add-to-bs-wrp")
    WebElement basketProduct;

    @FindBy(className = "pb-item")
    WebElement basketPname;

    @FindBy(className = "pb-basket-item-price")
    WebElement basketPprice;

    @FindBy(xpath = "//i[@class='i-bagg-orange hover-icon']")
    WebElement basketButton;

    @FindBy(xpath = "//button[@class='ty-numeric-counter-button']")
    WebElement countProduct;

    @FindBy(xpath = "//input[@class='counter-content']")
    WebElement countValue;

    @FindBy(xpath = "//i[@class='i-trash']")
    WebElement deleteProd;

    @FindBy(xpath = "//button[@class='btn-item btn-remove']")
    WebElement deleteProdVerify;

    @FindBy(xpath = "//div[@class='col-lg-8 col-md-8 col-xs-8']")
    WebElement deleteProdMessage;


    public void addProduct() throws InterruptedException {

        BaseClass.scrollElement(driver,basketProduct);
        basketProduct.click();
    }

    public void priceCompare() throws InterruptedException {

        BaseClass.scrollElement(driver, basketButton);
        basketButton.click();
        Assert.assertTrue(basketPprice.getText().contains(SearchPage.pPrice));

    }

    public void countProductControl() throws InterruptedException {

        countProduct.click();
        Thread.sleep(3000);
        String count = countValue.getAttribute("value");
        Assert.assertEquals(count,"2");
    }

    public void productDelete() throws InterruptedException {

        deleteProd.click();
        deleteProdVerify.click();
        Thread.sleep(3000);
        Assert.assertEquals(deleteProdMessage.getText(), "Sepetinizde ürün bulunmamaktadır.");

    }
}
