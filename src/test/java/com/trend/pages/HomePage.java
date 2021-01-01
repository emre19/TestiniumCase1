package com.trend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    @FindBy(xpath = "//i[@class='i-user-orange hover-icon']")
    WebElement accountButton;

    @FindBy(xpath = "//a[@title='Close']")
    WebElement popup;

    public void homePageTitleTest() throws InterruptedException {

        popup.click();
        String title = driver.getTitle();
        Assert.assertEquals(title,"En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da");
        accountButton.click();
    }
}
