package com.cybertek.tests.group_mentor_tasks;

import com.cybertek.utils.WebDriverFactory;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GasMileageCalculatorTest {
    /*
    Gas Mileage Calculator Automation Test - Add a new class GasMileageCalculatorTest
- Goto https://www.calculator.net
- Search for “gas mileage” using search box
- Click on the “Gas Mileage Calculator” link
 - On Next page verify:
o Title equals: “Gas Mileage Calculator”
o “Gas Mileage Calculator” label is displayed
 - Locate, clear and type “7925” into “Current odometer” field
- Locate, clear and type “7550” into “Previous odometer” field
- Locate, clear and type “16” into “Gas added” field
- Locate, clear and type “3.55” into “Gas price” field and Click on Calculate button
 - Locate and print the mpg value

     */
    String url="https://www.calculator.net";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void gasMileage(){

        WebElement searchBox= driver.findElement(By.id("calcSearchTerm"));
        searchBox.sendKeys("gas mileage");
        WebElement gasMileageCalc= driver.findElement(By.linkText("Gas Mileage Calculator"));
        gasMileageCalc.click();
        String expTitle= "Gas Mileage Calculator";

        Assert.assertEquals(driver.getTitle(),expTitle);
        Boolean displayed = driver.findElement(By.tagName("h1")).isDisplayed();
        //String displayedText= gasMileageText.getText();

        //gasMileageText.isDisplayed();
        Assert.assertTrue(displayed);


        WebElement currentOdometer= driver.findElement(By.id("uscodreading"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");

        WebElement previousOdometer= driver.findElement(By.id("uspodreading"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

        WebElement gasAdded= driver.findElement(By.id("usgasputin"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

        WebElement gasPrice= driver.findElement(By.id("usgasprice"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");
        WebElement calcButton= driver.findElement(By.xpath("(//input[@value='Calculate'])[1]"));
        calcButton.click();

        WebElement mileageAmount= driver.findElement(By.xpath("//p[@class='verybigtext']//b"));
        System.out.println("mileageAmount = " + mileageAmount.getText());
    }

}
