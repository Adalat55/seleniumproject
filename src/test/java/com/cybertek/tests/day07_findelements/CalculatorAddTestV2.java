package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CalculatorAddTestV2 {
    public static void main(String[] args) {



        String appUrl = "https://www.calculator.net";
        int num1 = 724, num2 = 4; //7 2 4
        int expectedResult = num1+num2;
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        String [] numOne= (num1+"").split("");  //[7,2,4]

        List<String> names = new ArrayList<>();

        List<WebElement> elements = driver.findElements(By.className("java"));

        WebElement num1Elem = driver.findElement(By.xpath("//span[.='"+num1+"']"));
        WebElement num2Elem = driver.findElement(By.xpath("//span[.='"+num2+"']"));
        WebElement elementPlusOperator=driver.findElement(By.xpath("//span[.='+']"));
        WebElement elementEquals= driver.findElement(By.xpath("//span[.='=']"));
        num1Elem.click();
        elementPlusOperator.click();
        num2Elem.click();
        elementEquals.click();
        WebElement result= driver.findElement(By.cssSelector("#sciOutPut"));
        System.out.println(result.getText());

      //  for (WebElement element : elements) {

        }






    }


