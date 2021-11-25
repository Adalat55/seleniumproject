package com.cybertek.tests.day10_dropdowns_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CarGurusUsedCarSelectTest {

    String url = "https://www.cargurus.com/";
    WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void searchForMinivan(){

        String expTitle = "Buy & Sell Cars: Reviews, Prices, and Financing - CarGurus";
        Assert.assertEquals(driver.getTitle(), expTitle);


        Select make = new Select(driver.findElement(By.id("carPickerUsed_makerSelect")));
        make.selectByValue("m7");

        Select model = new Select(driver.findElement(By.id("carPickerUsed_modelSelect")));
        model.selectByVisibleText("Sienna");

        WebElement zip = driver.findElement(By.id("dealFinderZipUsedId_dealFinderForm"));
        zip.sendKeys("91364");

        System.out.println("Selected make: "+make.getFirstSelectedOption().getText());
        System.out.println("Selected model: "+model.getFirstSelectedOption().getText());

        WebElement searchButton = driver.findElement(By.id("dealFinderForm_0"));
        searchButton.click();

        WebElement results = driver.findElement(By.xpath("//span/strong[2]"));
        System.out.println("results = " + results.getText());

        int count= Integer.parseInt(results.getText());

        Assert.assertTrue(count>0);


    }









}
