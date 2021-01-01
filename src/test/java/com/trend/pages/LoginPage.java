package com.trend.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(name = "login email")
    WebElement uname;

    @FindBy(name = "login-password")
    WebElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@title='Kapat']")
    WebElement popup2;

    public void loginToTrend(String usernameApplication, String passwordApplication){

        uname.sendKeys(usernameApplication);
        pass.sendKeys(passwordApplication);
        loginButton.click();

    }

    public void loginSuccessControl(){
        popup2.click();
        String title = driver.getTitle();
        Assert.assertEquals(title,"Erkek Giyim, Erkek Kıyafetleri, Erkek Modası | Trendyol");
    }
}
