package com.cybertek.tests.day10_dropdowns_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultiSelectDropDown {
    String url="http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void selectMultipleLanguagesTest() throws InterruptedException {
        Select languages = new Select(driver.findElement(By.name("Languages")));

        languages.selectByVisibleText("Java");
//        languages.selectByVisibleText("JavaScript");
//        languages.selectByVisibleText("Python");

        System.out.println("languages.isMultiple() = " + languages.isMultiple());

        for(WebElement each: languages.getOptions()){
            each.click();
            Thread.sleep(1234);
        }

       // languages.deselectAll();


    }
}
