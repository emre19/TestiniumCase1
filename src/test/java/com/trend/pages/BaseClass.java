package com.trend.pages;

import com.trend.utility.BrowserFactory;
import com.trend.utility.ConfigDataProvider;
import com.trend.utility.ExcelDataProvider;
import com.trend.utility.Helper;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class BaseClass {

    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;

    public Logger logger;

    @BeforeSuite
    public void setupSuite(){
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();
    }

    @BeforeClass
    public void setup(){
        logger = Logger.getLogger("Trend API");
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);

        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.quitBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            Helper.captureScreenshot(driver);
        }
    }
}
