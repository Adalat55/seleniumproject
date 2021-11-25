package com.cybertek.tests.day09_testng_dropdowns;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Dropdown {

    String url="http://practice.cybertekschool.com/dropdown";
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.out.println("Setting up Webdriver...");
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void titleTest(){

        System.out.println("Title of the page= " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice");

    }
    @Test
    public void simpleDropdownTest(){

        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select simpleDropDown = new Select(dropDown);
        simpleDropDown.selectByValue("1");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Closing Browser ...");
        //driver.quit();
}





}
