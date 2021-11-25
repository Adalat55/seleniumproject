package com.cybertek.tests.practice;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NadirsTask {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/");
        List<WebElement> expectedList= new ArrayList<>();
        ;//li[@class='dropdown dropdown-level-1']");




    }
}
