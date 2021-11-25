package com.cybertek.tests.group_mentor_tasks;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifyingSimpleDropdownTest {
    /*
    TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”

     */
    WebDriver driver;
    String url="http://practice.cybertekschool.com/dropdown";

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test (priority = 1)
    public void  verifyDropdown(){

        String expTitle ="Practice";

        Assert.assertEquals(driver.getTitle(),expTitle);

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        String defaultSelected=dropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(defaultSelected,"Please select an option", "Simple dropdown is not selected correctly by default" );

        Select stateSelection = new Select(driver.findElement(By.id("state")));
        String selectedState =  stateSelection.getFirstSelectedOption().getText();

        Assert.assertEquals(selectedState, "Select a State");

    }
    /*
    TC #2: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
     */
    @Test (priority = 2)
    public void selectStatesTest() throws InterruptedException {
        Select stateSelection = new Select(driver.findElement(By.id("state")));
        stateSelection.selectByIndex(14);
        Thread.sleep(3000);
        stateSelection.selectByIndex(47);
        Thread.sleep(3000);
        stateSelection.selectByIndex(5);

        String finalSelected = stateSelection.getFirstSelectedOption().getText();

        Assert.assertEquals(finalSelected, "California");

    }
    /*
    TC #3: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select “December 1st, 1922” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number

     */
    @Test(priority = 3)
    public void VerifyDateTest(){
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1922");
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("11");
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByIndex(0);

        //below line is not necessary its optional
        String expDate= month.getFirstSelectedOption().getText()+" "+day.getFirstSelectedOption().getText()+"st, "+year.getFirstSelectedOption().getText();


        //this line used for verifying that correct date is selected
        Assert.assertEquals(expDate, "December 1st, 1922");

    }
    /*
    TC #4: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
     */

    @Test
    public void selectMultipleTest(){

        Select languages = new Select(driver.findElement(By.name("Languages")));
        List<WebElement> allOptions = languages.getOptions();

        Assert.assertTrue(languages.isMultiple());


        for(WebElement eachOption: allOptions){
            eachOption.click();
            System.out.print(eachOption.getText()+" ");
        }

        languages.deselectAll();

    }
    @Test
    public void verifyFacebookLogin(){

        /*
        TC #5: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
         */

        WebElement website = driver.findElement(By.id("dropdownMenuLink"));
        website.click();
        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        facebook.click();

        Assert.assertEquals(driver.getTitle(),"Facebook - Log In or Sign Up");
    }

}
