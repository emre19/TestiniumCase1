package com.trend.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SearchPage {

    WebDriver driver;

    public static String pName;
    public static String pPrice;

    public SearchPage(WebDriver driver){
        driver = this.driver;
    }

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchInput;

    @FindBy(xpath = "//img[@alt='Samsung Galaxy Tab A 8 SM-T290 32GB Tablet Gümüş']")
    WebElement selectedProduct;

    @FindBy(className = "ph-gl-img") // pr-new-br
    WebElement productName;

    @FindBy(className = "prc-slg")
    WebElement productPrice;

    public void searchComputer(String key){
        searchInput.sendKeys(key);
        searchInput.sendKeys(Keys.ENTER);
        selectedProduct.click();
    }

    public void writeProductText(){

        pName = productName.getAttribute("alt");
        pPrice = productPrice.getText();

        File file = new File("./TestData/productText.txt");
        try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
            br.write("product name: "+ pName);
            br.newLine();
            br.write("product price: "+ pPrice);
            br.newLine();
            br.write("----------------------------");
        } catch (IOException e) {
            System.out.println("Unable to read file " +file.toString());
        }

    }
}

