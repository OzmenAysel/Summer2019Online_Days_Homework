package com.homework.Homework4;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utils.BrowserFactory;
import com.utils.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class TestCases_1_2_3_4_5_6 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
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

        WebElement loaderMask = null;

        if (driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size() > 0) {
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

    @Test(description = "Verify that “view”, “edit” and “delete” options are available")
    public void test1() {

        Actions action = new Actions(driver);
        WebElement dots = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[17]"));
        action.moveToElement(dots).perform();
        BrowserUtils.wait(3);

//        for (int i = 1; i <= 3; i++) {
//            WebElement title = driver.findElement(By.cssSelector("[class='launcher-item']:nth-of-type(" + i + ")"));
//            System.out.println(title);
//            Assert.assertTrue(title.isDisplayed());
//        }
//??????????????????????

//        WebElement viewOption = driver.findElement(By.xpath("(//a[@title='View'])[3]"));
//       // Assert.assertTrue(viewOption.isDisplayed()); ?????????????????????/
//        WebElement editOption = driver.findElement(By.xpath("(//a[@title='Edit'])[3]"));
//
//        WebElement deleteOption = driver.findElement(By.xpath("(//a[@title='Delete'])[3]"));

    }

    @Test(description = "Verify that “Title” column still displayed")
    public void test2() {
        driver.findElement(By.cssSelector("[title='Grid Settings']")).click();

        WebElement table = driver.findElement(By.cssSelector("div[class='dropdown-menu']"));
        wait.until(ExpectedConditions.visibilityOf(table));
        for (int i =2; i<8; i++) {
            WebElement checkbox = driver.findElement(By.xpath("(//*[@class='visibility-cell'])[" + i + "]"));
            if(!checkbox.isSelected()){
                checkbox.click();

            }
            Assert.assertFalse(checkbox.isSelected());
        }

   }

    @Test(description = "Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void test3() throws InterruptedException {
        driver.findElement(By.cssSelector("a[title='Create Calendar event']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[class='caret']")).click();

        WebElement SaveAndClose = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        System.out.println(SaveAndClose.getText());
        Assert.assertTrue(SaveAndClose.isEnabled());

        WebElement SaveAnnNew = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
        System.out.println(SaveAnnNew.getText());
        Assert.assertTrue(SaveAnnNew.isEnabled());

        WebElement Save = driver.findElement(By.xpath("(//button[@type='submit'])[4]"));
        System.out.println(Save.getText());
        Assert.assertTrue(Save.isEnabled());

    }


    @Test(description = "Verify that “All Calendar Events” page subtitle is displayed")
    public void test4() throws InterruptedException {
        driver.findElement(By.cssSelector("a[title='Create Calendar event']")).click();

        WebElement loaderMask = null;
        loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        driver.findElement(By.cssSelector("a[title='Cancel']")).click();
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement subTitle = driver.findElement(By.cssSelector("h1[class='oro-subtitle']"));
        System.out.println("SubTitle is :"+subTitle.getText());
        Assert.assertTrue(subTitle.isDisplayed());
    }

         @Test(description = "Verify that difference between end and start time is exactly 1 hour")
        public void test5(){
            driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
            WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            WebElement start = driver.findElement(By.cssSelector("[class*='start ui']"));
            String startTime = start.getAttribute("value");
            System.out.println(startTime);
            WebElement end = driver.findElement(By.cssSelector("[class*='end ui']"));
            wait.until(ExpectedConditions.elementToBeClickable(end));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", end);
            String  endTime = driver.findElement(By.cssSelector("[class*='ui-timepicker-selected']")).getText();
            System.out.println(endTime);
            Assert.assertEquals(-1, (Integer.parseInt(startTime.substring(0, startTime.indexOf(":")))-Integer.parseInt(endTime.substring(0,startTime.indexOf(":")))));

    }

    @Test(description = "Verify that end time is equals to “10:00 PM")
    public void test6() throws InterruptedException {
        driver.findElement(By.cssSelector("a[title='Create Calendar event']")).click();

        WebElement loaderMask = null;
        loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        driver.findElement(By.xpath("(//input[@placeholder='time'])[1]")).click();

        WebElement start = driver.findElement(By.xpath("(//*[@class='ui-timepicker-pm'])[19]"));
        wait.until(ExpectedConditions.visibilityOf(start));
        start.click();

        WebElement end = driver.findElement(By.cssSelector("[class*='end ui']"));
        wait.until(ExpectedConditions.visibilityOf(end));
        end.click();

        String endTime = driver.findElement(By.xpath("(//li[@class='ui-timepicker-pm ui-timepicker-selected'])[2]  ")).getText();
        String expectedTime = "10:00 PM";
        System.out.println("end time " + endTime);
        Assert.assertEquals(endTime,expectedTime);  //  ?????????

    }

    @Test
    public void teardown(){
       driver.quit();
    }

}

  /*
    Test Case #1
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Hover on three dots “…” for “Testers meeting” calendar event
    5. Verify that “view”, “edit” and “delete” options are available

    Test Case #2
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on “Grid Options” button
    5. Deselect all options except “Title”
    6. Verify that “Title” column still displayed

    Test Case #3
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events
    4. Click on “Create Calendar Event” button
    5. Expand “Save And Close” menu
    6. Verify that “Save And Close”, “Save And New” and “Save” options are available

    Test Case #4
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on “Create Calendar Event” button
    5. Then, click on “Cancel” button
    6. Verify that “All Calendar Events” page subtitle is displayed

    Test Case #5
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on “Create Calendar Event” button
    5. Verify that difference between end and start time is exactly 1 hour

   Test Case #6
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on “Create Calendar Event” button
    5. Select “9:00 PM” as a start time
    6. Verify that end time is equals to “10:00 PM

   */