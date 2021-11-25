package com.cybertek.tests.practice;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CVSTask {
    public static void main(String[] args) {
        String url= " https://www.cvs.com/";
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);
        WebElement clinicLocator= driver.findElement(By.xpath("//*[text()='MinuteClinic']"));
        clinicLocator.click();
    }
}
