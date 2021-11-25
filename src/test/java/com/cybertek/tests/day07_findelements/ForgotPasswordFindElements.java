package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ForgotPasswordFindElements {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();;
        String appUrl= "http://practice.cybertekschool.com/forgot_password";
        driver.get(appUrl);

        List<WebElement> links = new ArrayList<>();
        links = driver.findElements(By.tagName("a"));

        System.out.println(links.get(0));








    }
}
