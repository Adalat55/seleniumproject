package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTest {
    public static void main(String[] args) {


    /*Try to use CSS or Xpath for this task.
You are writing an automation test to verify if the calculator is working as expected.
1) Add a class CalculatorAddTest
2) Declare variables String appUrl = “https://www.calculator.net”
int num1 = 5, num2 = 3
int expectedResult = 8
3) Launch selenium, maximize and navigate to the url
4) Locate 4 elements “5”, “3”, “+” , “=” using css or xpath and store into WebElement
objects
5) Click the elements in right order as you would do normally,
Add Thread.sleep(1234) in between steps to slow it down a little - not needed if you
have a cheap computer like mine :)
6) Locate result area and store into webElement object
7) Read the text of the result element, remove any unneeded characters and convert
into int. int expectedResult = Integer.parseInt(result);
8) Using if statement compare actualResult and the expectedResult . print pass or fail
accordingly.
9) Quit selenium and go home */

    String appUrl = "https://www.calculator.net";
    int num1 = 5, num2 = 3;
    int expectedResult = 8;
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.get(appUrl);
    WebElement elementFive= driver.findElement(By.xpath("//span[.='5']"));
    elementFive.click();

    WebElement elementPlusOperator=driver.findElement(By.xpath("//span[.='+']"));
    elementPlusOperator.click();

    WebElement elementThree= driver.findElement(By.xpath("//span[.='3']"));
    elementThree.click();

    WebElement elementEquals= driver.findElement(By.xpath("//span[.='=']"));
    elementEquals.click();

    WebElement result= driver.findElement(By.cssSelector("#sciOutPut"));
        System.out.println(num1+" + "+num2+" = "+result.getText());
        String resultValue= result.getText();

        resultValue= resultValue.trim();

        int actualResult = Integer.parseInt(resultValue);

        if(actualResult==expectedResult){
            System.out.println("Passed: Calculation passed");
        }else{
            System.out.println("Failed: Calculation failed");
        }

          driver.quit();






}
}