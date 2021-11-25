package com.cybertek.tests.day09_testng_dropdowns;
import static  org.testng.Assert.*;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNGIntro {
    String url= "https://www.etsy.com";
    String exp= "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";


    @BeforeClass  //it will run once before all the tests
    public void setUp(){
        System.out.println("Beforeclass setup method...");
        System.out.println("opened browser and navigating to "+url);
        System.out.println("========================================");
    }
    @BeforeMethod
    public void setUpApp(){
        System.out.println("@BeforeMethod setup method is running");
        System.out.println("Navigating back to "+url);
        System.out.println("=================================");
    }

//    String url= "https://www.etsy.com";
//
//    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @Test(priority = 1)
    public void test1(){
        System.out.println("test1 is running");
        int num=10;
        assertEquals(10,num);
        System.out.println("===============");
//
//
//        driver.get(url);
//        assertEquals(driver.getTitle(),exp);
    }

   @Test(priority = 2)
   public void test2(){
       System.out.println("Test 2 is running");
       System.out.println("=================");
   }
    //@BeforeMethod-> runs before every test


    @AfterMethod
    public void tearDown(){
        System.out.println("AfterMethod is running");
        System.out.println("======================");
    }




}
