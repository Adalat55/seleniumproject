package com.cybertek.tests.practice;

import com.cybertek.utils.EmailGenerator;
import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhpTravelsRegistrationTest {
    public static void main(String[] args) throws InterruptedException {
        String randomEmail= EmailGenerator.emailGenerator();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        String url =  "https://www.phptravels.net";
        driver.get(url);


        String randomPassword= "999jamesBond@@";


        WebElement signupButton=driver.findElement(By.linkText("Signup"));
        signupButton.click();
        WebElement firstName=driver.findElement(By.xpath("//input[@class ='form-control']"));
        firstName.sendKeys("James");
        WebElement lastName=driver.findElement(By.xpath("//input[@placeholder ='Last Name']"));
        lastName.sendKeys("Bond");
        WebElement phone=driver.findElement(By.xpath("//input[@placeholder ='Phone']"));
        phone.sendKeys("55555555");
        WebElement email=driver.findElement(By.xpath("//input[@placeholder ='Email']"));
        email.sendKeys(randomEmail);
        Thread.sleep(4000);
        WebElement password=driver.findElement(By.xpath("//input[@placeholder ='Password']"));
        password.sendKeys(randomPassword+Keys.ENTER);




        Thread.sleep(3000);



        String expTitle = "Login - PHPTRAVELS";
        String actTitle = driver.getTitle();


        if(expTitle.equalsIgnoreCase(actTitle)){
           System.out.println("Passed: title verified");
          }else{
            System.out.println("Failed: title failed");
        }

        WebElement entranceEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        entranceEmail.sendKeys(randomEmail);

        WebElement entrancePassword=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input"));
        entrancePassword.sendKeys(randomPassword+Keys.ENTER);


        WebElement actWelcomeName = driver.findElement(By.xpath("//Strong[@style='text-transform:capitalize']"));

        if(actWelcomeName.getText().contains("James")){
            System.out.println("Passed: Name verification passed");
        }
        else
        {
            System.out.println("failed: name verification failed");
        }



 }
}
