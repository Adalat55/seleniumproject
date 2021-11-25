package com.cybertek.tests.day10_dropdowns_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class AmazonDepartmentNamesListTest {

    String url = "https://www.amazon.com/";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver =getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
}
    @Test
    public void amazonDepartmentTest(){

        String expTitle= "Amazon.com. Spend less. Smile more.";

        Assert.assertEquals(driver.getTitle(),expTitle);



        Select departments = new Select(driver.findElement(By.id("searchDropdownBox")));

//        departments.selectByVisibleText("Books");
//        Assert.assertEquals(departments.getFirstSelectedOption().getText(),"Books");


        List<WebElement> allOptions =  departments.getOptions();


        allOptions.forEach(dep -> System.out.println(dep.getText()));

        int countofDepartments = allOptions.size();
        System.out.println("countofDepartments = " + countofDepartments);

        assertTrue(countofDepartments>10,"Too Many Deparments");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        for(WebElement dept: allOptions){
            departments.selectByVisibleText(dept.getText());
        }
        searchBox.sendKeys("");

    }





}

