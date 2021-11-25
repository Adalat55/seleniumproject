package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElements {
    public static void main(String[] args) {
        String url = "http://practice.cybertekschool.com/add_remove_elements/";

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();;
        driver.get(url);

        WebElement addElement= driver.findElement(By.xpath("//button[.='Add Element']"));

        for(int i =0;i<50;i++) {
            addElement.click();
        }

        List<WebElement> deleteButtons= driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));

        if(deleteButtons.size()==50){
            System.out.println("50 delete buttons displayed");
        }else{
            System.out.println("50 delete buttons Failed");
        }

        //WebElement deleteButton= driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        for (WebElement deleteButton : deleteButtons) {
           deleteButton.click();
        }
        List<WebElement> remainDeleteButtons= driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        if(remainDeleteButtons.size()==0){
            System.out.println("All buttons deleted");
            System.out.println(remainDeleteButtons.size());

        }else {
            System.out.println("Failed to delete all buttons");
            System.out.println(remainDeleteButtons.size());
        }













      //  List<WebElement> deleteButtons = driver.findElements()



    }
}
