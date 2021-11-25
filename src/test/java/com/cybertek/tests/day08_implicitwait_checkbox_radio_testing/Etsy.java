package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Etsy {
    public static void main(String[] args) throws InterruptedException {

        String url ="https://www.etsy.com/";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        WebElement searchBox= driver.findElement(By.xpath("//input[@name='search_query']"));
        searchBox.sendKeys("Wooden Spoon"+ Keys.ENTER);
        WebElement filter= driver.findElement(By.xpath("//span[@class='wt-hide-xs wt-show-md filter-expander']"));
        filter.click();
        WebElement freeShipping= driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeShipping.click();
        WebElement onSale = driver.findElement(By.xpath("//label[@for='special-offers-on-sale']"));
        onSale.click();
        WebElement under25= driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under25.click();
        WebElement apllyButton= driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']"));
        apllyButton.click();
        Thread.sleep(2000);

        WebElement results= driver.findElement(By.xpath("//span[@class='wt-display-inline-flex-sm']/span[1]"));
        System.out.println(results.getText());
    }
}
