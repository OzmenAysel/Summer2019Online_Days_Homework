package com.homework.Homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utils.BrowserFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases {

    private WebDriver driver;
    private WebDriverWait wait;

        @BeforeMethod
        public void setup(){
            driver = BrowserFactory.getDriver("chrome");
            //explicit wait
            wait = new WebDriverWait(driver, 10);
            //implicit wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //maximize browser
            driver.manage().window().maximize();
            driver.get("https://qa1.vytrack.com/");
            driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
            driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

            WebElement loaderMask= null;

            if(driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size()>0) {
                loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
                wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            }

            WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
            wait.until(ExpectedConditions.visibilityOf(activitiesElement));
            wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
            activitiesElement.click();

            WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
            wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
            wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
            calendarEventsElement.click();

            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }

    @Test(description = "Verify that page subtitle 'Options' is displayed")
    public void tes1(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Options')]")).isDisplayed());
    }

    @Test (description = "Verify that page number is equals to '1' ")
    public void test2(){
        Assert.assertEquals(driver.findElement(By.cssSelector("input[value='1']")).getAttribute("value"), "1");
    }

    @Test(description = "Verify that view per page number is equals to '25' ")
    public void test3(){
        String actualPageNumber = driver.findElement(By.cssSelector("[class='btn dropdown-toggle ']")).getText();
        Assert.assertEquals(actualPageNumber, "25");
    }

    @Test (description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4() {
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));
        int numberOfCalenderEvents = rows.size();
        String numberOfRecords = driver.findElement(By.xpath("//label[@class='dib'][3] ")).getText();
        Assert.assertTrue(numberOfRecords.contains("" + numberOfCalenderEvents));
    }

        @Test (description =  "Verify that all calendar events were selected")
        public void test5() {
            driver.findElement(By.xpath("//i[@class='caret']/preceding-sibling::input")).click();
            List<WebElement> All = driver.findElements(By.xpath("//tbody//tr//td//input"));
           for(WebElement checkboxes : All){
               Assert.assertTrue(checkboxes.isSelected());
           }
            }

            @Test(description = "Verify that following data is displayed:")
            public void test6 () throws InterruptedException {
                WebElement TestersMeeting = driver.findElement(By.xpath("//table//tbody//tr[13]"));

                wait.until(ExpectedConditions.visibilityOf(TestersMeeting));
                wait.until(ExpectedConditions.elementToBeClickable(TestersMeeting));
                TestersMeeting.click();

                List<WebElement> titleText = driver.findElements(By.xpath("//label[@class='control-label']"));
                for(WebElement each: titleText){
                    wait.until(ExpectedConditions.visibilityOf(each));
                    Assert.assertTrue(each.isDisplayed());
                }

                List<WebElement> testersMeetingText = driver.findElements(By.xpath("//div[@class='control-label']"));
                for (WebElement each : testersMeetingText){
                    wait.until(ExpectedConditions.visibilityOf(each));
                    Assert.assertTrue(each.isDisplayed());
                }

            }

            @AfterMethod
            public void teardown () {
            driver.quit();
            }
        }

/*
      Test case #1
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Verify that page subtitle "Options" is displayed

    Test case #2
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Verify that page number is equals to "1

    /*Test case #3
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Verify that view per page number is equals to "25"

    Test case #4
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Verify that number of calendar events (rows in the table) is equals to number of records
    Hint: In HTML, <table> tag represents table, <thread> - table header, <tr> tag represents table row element,
     <th> table header cell and <td> table data.
      Css selector: table > tr

     Test case #5
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on the top checkbox to select all
    5. Verify that all calendar events were selected

     Test case #6
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Select “Testers meeting”
    5. Verify that following data is displayed:

 */

