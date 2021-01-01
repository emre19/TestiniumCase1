package com.trend.pages;

import com.trend.utility.BrowserFactory;
import com.trend.utility.ConfigDataProvider;
import com.trend.utility.ExcelDataProvider;
import com.trend.utility.Helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class BaseClass {

    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;

    @BeforeSuite
    public void setupSuite(){
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();
    }

    @BeforeClass
    public void setup(){
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
    }

    @AfterClass
    public void tearDown(){
        //BrowserFactory.quitBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            Helper.captureScreenshot(driver);
        }
    }

    public static void scrollElement(WebDriver driver,WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(3000);
    }
}
