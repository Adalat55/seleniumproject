package com.cybertek.tests.day06;

import com.cybertek.utils.EmailGenerator;
import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://practice.cybertekschool.com/forgot_password";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(url);
        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        emailField.sendKeys(EmailGenerator.emailGenerator());


        for(int i =3; i<10;i++){

            Thread.sleep(3000);

            emailField.clear();
            emailField.sendKeys(EmailGenerator.emailGenerator());


        }
    }
}
