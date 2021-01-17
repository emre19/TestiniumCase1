package com.trend.pages;

import com.trend.commonfunctions.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends CommonMethods {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void loginToTrend(String usernameApplication, String passwordApplication) throws InterruptedException {
        Sendkeys(driver,"id",uname,usernameApplication);
        Sendkeys(driver,"id",pass,passwordApplication);
        clickButton(driver,"css selector",loginButton);
    }

    public void loginSuccessControl() throws InterruptedException {
        clickButton(driver,"id",popup2);
        String title = driver.getTitle();
        Assert.assertEquals(title,"Erkek Giyim, Erkek Kıyafetleri, Erkek Modası | Trendyol");
    }
}
