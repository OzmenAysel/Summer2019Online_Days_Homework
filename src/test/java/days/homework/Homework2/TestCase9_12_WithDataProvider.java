package days.homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestCase9_12_WithDataProvider {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Status Codes")).click();
    }
    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][]{  {"200","This page returned a 200 status code.\n\n" +
                "For a definition and common list of HTTP status codes, go here"},
                {"301","This page returned a 301 status code.\n\n" +
                        "For a definition and common list of HTTP status codes, go here"},
                {"404","This page returned a 404 status code.\n\n" +
                        "For a definition and common list of HTTP status codes, go here"},
                {"500","This page returned a 500 status code.\n\n" +
                        "For a definition and common list of HTTP status codes, go here"} };
    }
    @Test(dataProvider = "testData") // this test will run twice, because we have 2 sets of data
    public void testWithDataProvider(String url, String text) {
        driver.findElement(By.partialLinkText(url)).click();
        String actual = driver.findElement(By.cssSelector("div p")).getText();
        Assert.assertEquals(actual,text);
    }
    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}