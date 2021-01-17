package com.trend.pages;

import com.trend.commonfunctions.CommonMethods;
import org.openqa.selenium.WebDriver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SearchPage extends CommonMethods {

    WebDriver driver;

    public static String pName;
    public static String pPrice;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchComputer(String key) throws InterruptedException {
        Sendkeys(driver,"css selector",searchInput,key);
        keyEnter(driver,"css selector", searchInput);
        scroll(driver,"css selector",selectedProduct);
        clickButton(driver,"css selector", selectedProduct);
    }

    public void writeProductText(){
        pPrice = getText(driver,"xpath",productPrice);
        pName = getText(driver,"xpath",productName);

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

