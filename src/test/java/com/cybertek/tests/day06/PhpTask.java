package com.cybertek.tests.day06;

import com.cybertek.utils.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhpTask {
    public static void main(String[] args) throws InterruptedException {

        String appUrl = "https://www.amazon.com";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);
//<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">

          WebElement searchElement= driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));


//        WebElement searchElement2= driver.findElement(By.cssSelector("input[aria-label='Search']"));
//        WebElement searchElement3= driver.findElement(By.cssSelector("input[name='field-keywords']"))

            searchElement.sendKeys("phone case"+Keys.ENTER);
            Thread.sleep(3000);


            searchElement=driver.findElement(By.cssSelector("input[class='nav-input nav-progressive-attribute']"));
            Thread.sleep(3000);
            searchElement.clear();
            searchElement.sendKeys("Wooden Spoon");
            WebElement serachBotton= driver.findElement(By.cssSelector("div[class='nav-search-submit nav-sprite']"));
            serachBotton.click();
    }
}
