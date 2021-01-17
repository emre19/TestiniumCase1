package com.trend.commonfunctions;

import org.openqa.selenium.*;

public class CommonMethods extends PageConstants {

     public String clickButton(WebDriver driver, String strLocType, String strLocValue)
            throws InterruptedException {
        switch (strLocType) {
            case "id":
                driver.findElement(By.id(strLocValue)).click();
                break;
            case "xpath":
                driver.findElement(By.xpath(strLocValue)).click();
                break;
            case "name":
                driver.findElement(By.name(strLocValue)).click();
                break;
            case "css selector":
                driver.findElement(By.cssSelector(strLocValue)).click();
                break;
        }
        return strLocValue;
    }

    public static String Sendkeys(WebDriver driver, String strLocType, String strLocValue, String param1)
            throws InterruptedException {
        switch (strLocType) {
            case "id":
                driver.findElement(By.id(strLocValue)).sendKeys(param1);
                break;
            case "xpath":
                driver.findElement(By.xpath(strLocValue)).sendKeys(param1);
                break;
            case "name":
                driver.findElement(By.name(strLocValue)).sendKeys(param1);
                break;
            case "css selector":
                driver.findElement(By.cssSelector(strLocValue)).sendKeys(param1);
                break;
        }
        return param1;
    }

    public static void keyEnter(WebDriver driver, String strLocType, String strLocValue){
        driver.findElement(By.cssSelector(strLocValue)).sendKeys(Keys.ENTER);
    }

    public static String getAttribute(WebDriver driver, String strLocType, String strLocValue, String key){

         String attributeValue;

         if (strLocType.equals("id")){
             attributeValue = driver.findElement(By.id(strLocValue)).getAttribute(key);
             return attributeValue;
         }
         else if (strLocType.equals("xpath")){
             attributeValue = driver.findElement(By.xpath(strLocValue)).getAttribute(key);
             return attributeValue;
         }
         else if (strLocType.equals("name")){
             attributeValue = driver.findElement(By.name(strLocValue)).getAttribute(key);
             return attributeValue;
         }
         else if (strLocType.equals("css selector")){
             attributeValue = driver.findElement(By.cssSelector(strLocValue)).getAttribute(key);
             return attributeValue;
         }
         else return "Invalid GetAttribute()";

    }

    public static String getText(WebDriver driver, String strLocType, String strLocValue){

        String attributeValue;

        if (strLocType.equals("id")){
            attributeValue = driver.findElement(By.id(strLocValue)).getText();
            return attributeValue;
        }
        else if (strLocType.equals("xpath")){
            attributeValue = driver.findElement(By.xpath(strLocValue)).getText();
            return attributeValue;
        }
        else if (strLocType.equals("name")){
            attributeValue = driver.findElement(By.name(strLocValue)).getText();
            return attributeValue;
        }
        else if (strLocType.equals("css selector")){
            attributeValue = driver.findElement(By.cssSelector(strLocValue)).getText();
            return attributeValue;
        }
        else return "Invalid GetText()";
    }

    static public String scroll(WebDriver driver, String strLocType, String strLocValue) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element;

        switch (strLocType) {
            case "id":
                Element = driver.findElement(By.id(strLocValue));
                js.executeScript("arguments[0].scrollIntoView();", Element);
                break;
            case "xpath":
                Element = driver.findElement(By.xpath(strLocValue));
                js.executeScript("arguments[0].scrollIntoView();", Element);
                break;
            case "name":
                Element = driver.findElement(By.name(strLocValue));
                js.executeScript("arguments[0].scrollIntoView();", Element);
                break;
            case "css selector":
                Element = driver.findElement(By.cssSelector(strLocValue));
                js.executeScript("arguments[0].scrollIntoView();", Element);
                break;
        }
        Thread.sleep(4000);
        return strLocValue;
    }
}
