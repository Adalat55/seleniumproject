package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioBoxTest {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://practice.cybertekschool.com/radio_buttons";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        WebElement red = driver.findElement(By.id("red"));
        if(red.isSelected()) {
            red.click();
        }

        WebElement football = driver.findElement(By.id("football"));
        if(!football.isSelected()) {
            football.click();
        }


        List<WebElement> radioButtons= driver.findElements(By.xpath("//input[@type='radio']"));

        for (WebElement radioButton : radioButtons) {

            if(radioButton.isEnabled()) {
                radioButton.click();
                Thread.sleep(1234);
            }
        }




    }
}
