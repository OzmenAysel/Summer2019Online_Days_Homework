package days.homework.Homework4;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class TestCases_7_8_9_10_11_12 {

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

    @Test(description = " Verify that “All-Day Event” checkbox is selected\n" +
            "  Verify that start and end time input boxes are not displayed\n" +
            "  Verify that start and end date input boxes are displayed")
    public void test7() {
        driver.findElement(By.cssSelector("a[title='Create Calendar event']")).click();
        WebElement loaderMask = null;
        loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement allDayEvent = driver.findElement(By.cssSelector("[data-name='field__all-day']"));
        wait.until(ExpectedConditions.visibilityOf(allDayEvent));
        allDayEvent.click();
        Assert.assertTrue(allDayEvent.isSelected());

        WebElement startTimeBox = driver.findElement(By.xpath("(//input[@placeholder='time'])[1]"));
        wait.until(ExpectedConditions.invisibilityOf(startTimeBox));
        Assert.assertFalse(startTimeBox.isDisplayed());
        WebElement endTimeBox = driver.findElement(By.xpath("(//input[@placeholder='time'])[2]"));
        Assert.assertFalse(endTimeBox.isDisplayed());

        WebElement startDateBox = driver.findElement(By.xpath("(//input[@placeholder='Choose a date'])[1]"));
        Assert.assertTrue(startDateBox.isDisplayed());
        WebElement endDateBox = driver.findElement(By.xpath("(//input[@placeholder='Choose a date'])[1]"));
        Assert.assertTrue(endDateBox.isDisplayed());   //  ???????????

    }


    @Test(description = "Verify that “Repeat” checkbox is selected\n" +
            " Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:")
    public void test8() throws InterruptedException {
        driver.findElement(By.cssSelector("a[title='Create Calendar event']")).click();
        WebElement loaderMask = null;
        loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement repeatBox = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        repeatBox.click();
        Assert.assertTrue(repeatBox.isSelected());

        WebElement daily = driver.findElement(By.cssSelector("[style='width: 292px; user-select: none;']"));
        System.out.println(daily.getText());
        Assert.assertTrue(daily.isEnabled());


    }

    @Test(description = "Verify that following message as a summary is displayed: Summary: Daily every 1 day")
    public void test9() throws InterruptedException {
        driver.findElement(By.cssSelector("a[title='Create Calendar event']")).click();
        WebElement loaderMask = null;
        loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement repeatBox = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        repeatBox.click();
        Assert.assertTrue(repeatBox.isSelected());

        Assert.assertTrue(driver.findElement(By.cssSelector("input[checked='checked']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='radio'])[3]")).isSelected());

        WebElement message = driver.findElement(By.xpath("(//div[@class='controls'])[17]"));
        WebElement summaryMessage = driver.findElement(By.xpath("//label[text()='Summary:']"));

        System.out.println(summaryMessage.getText());
        System.out.println(message.getText());

        Assert.assertTrue(summaryMessage.isDisplayed());
        Assert.assertTrue(message.isDisplayed());
        ;


    }

    @Test(description = "Verify that following message as a summary is displayed: Summary: Daily every 1 day")
    public void test10() throws InterruptedException {
        driver.findElement(By.cssSelector("a[title='Create Calendar event']")).click();
        WebElement loaderMask = null;
        loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement repeatBox = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        repeatBox.click();

        WebElement after10occurrences = driver.findElement(By.xpath("(//input[@type='radio'])[4]"));
        after10occurrences.click();

        driver.findElement(By.xpath("(//input[@type='text'])[16]")).sendKeys("10");

        driver.findElement(By.xpath("//span[text()='occurrences']")).click();

        WebElement message = driver.findElement(By.xpath("(//div[@class='controls'])[17]"));
        WebElement summaryMessage = driver.findElement(By.xpath("//label[text()='Summary:']"));

        System.out.println(summaryMessage.getText());
        System.out.println(message.getText());

        Assert.assertTrue(summaryMessage.isDisplayed());
        Assert.assertTrue(message.isDisplayed());
        ;
    }

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”")
    public void test11() {
        driver.findElement(By.cssSelector("a[title='Create Calendar event']")).click();
        WebElement loaderMask = null;
        loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement repeatBox = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        repeatBox.click();

        WebElement endsOptionBy = driver.findElement(By.xpath("(//input[@type='radio'])[5]"));
        endsOptionBy.click();

        driver.findElement(By.xpath("(//input[@placeholder='Choose a date'])[3]")).click();

        WebElement month = driver.findElement(By.cssSelector("[data-handler='selectMonth']"));
        wait.until(ExpectedConditions.visibilityOf(month));
        month.click();

        driver.findElement(By.cssSelector("[data-handler='selectYear']")).click();
        driver.findElement(By.cssSelector("[value='2021']")).click();

        driver.findElement(By.xpath("//a[text()='18']")).click();

        WebElement message = driver.findElement(By.xpath("(//div[@class='controls'])[17]"));
        WebElement summaryMessage = driver.findElement(By.xpath("//label[text()='Summary:']"));
        System.out.println(summaryMessage.getText());
        System.out.println(message.getText());
        Assert.assertTrue(summaryMessage.isDisplayed());
        Assert.assertTrue(message.isDisplayed());
        ;
    }

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”")
    public void test12() {

        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        WebElement repeat = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        repeat.click();
        Assert.assertTrue(repeat.isSelected());
        WebElement Daily = driver.findElement(By.className("recurrence-repeats__select"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", Daily);
        Select select = new Select(Daily);
        select.selectByVisibleText("Weekly");
        driver.findElement(By.xpath("(//*[@value='monday'])[3]")).click();
        driver.findElement(By.xpath("(//*[@value='friday'])[3]")).click();
        String actualText = driver.findElement(By.cssSelector(".control-group.recurrence-summary.alert-info")).getText();
        String expectedText = "Summary:\nWeekly every 1 week on Monday, Friday";
        Assert.assertEquals(actualText, expectedText);
    }
    
    @Test
    public void teardown(){
        driver.quit();
    }

}
/*
    Test Case #7
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on “Create Calendar Event” button
    5. Select “All-Day Event” checkbox
    6. Verify that “All-Day Event” checkbox is selected
    7. Verify that start and end time input boxes are not displayed
    8. Verify that start and end date input boxes are displayed

    Test Case #8
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on “Create Calendar Event” button
    5. Select “Repeat” checkbox
    6. Verify that “Repeat” checkbox is selected
    7. Verify that “Daily” is selected by default and following options are available in   “Repeats” drop-down:

     Test Case #9
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on “Create Calendar Event” button
    5. Select “Repeat” checkbox
    6. Verify that “Repeat” checkbox is selected
    7. Verify that “Repeat Every” radio button is selected
    8. Verify that “Never” radio button is selected as an “Ends” option.
    9. Verify that following message as a summary is displayed: “Summary: Daily every 1 day”

     Test Case #10
    1.Test Case #10 1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on “Create Calendar Event” button
    5. Select “Repeat” checkbox
    6. Select “After 10 occurrences” as an “Ends” option.
    7. Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end after 10 occurrences”

    Test Case #11
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on “Create Calendar Event” button
    5. Select “Repeat” checkbox
    6. Select “By Nov 18, 2021” as an “Ends” option.
    7. Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”

    Test Case #12
    1. Go to “https://qa1.vytrack.com/"
    2. Login as a store manager
    3. Navigate to “Activities -> Calendar Events”
    4. Click on “Create Calendar Event” button
    5. Select “Repeat” checkbox
    6. Select “Weekly” options as a “Repeat” option
    7. Select “Monday and Friday” options as a “Repeat On” options
    8. Verify that “Monday and Friday” options are selected
    9. Verify that following message as a summary is displayed: “Summary: Weekly every 1 week on Monday, Friday”

   */
