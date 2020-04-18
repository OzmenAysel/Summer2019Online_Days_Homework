package days.homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestCase9_10_11_12 {
    /*
    Optional: If you want to to be a real selenium hero, use @DataProvider for
    for tests cases from 9 through 12. Please use following documentation:
    https:// testng.org/doc/documentationmain.html#parameters-dataproviders
     */
    /*
    Please create test scripts from 1 through 5 in the same class, with implementing
     @Before method for driver setup, and @After method for driver close.
     Also, do the same thing for tests cases from 9 through 12.
     */

    private WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Status Codes")).click();
    }
    @Test (description = "This page returned a 200 status code.")
    public void test9() throws InterruptedException {
        driver.findElement(By.partialLinkText("200")).click();
        String message = driver.findElement(By.cssSelector("div p")).getText();
        //System.out.println(message);

//        String expectedMessage ="This page returned a 200 status code.\n" +
//                "\n" +
//                "For a definition and common list of HTTP status codes, go here";
//         Assert.assertEquals(message, expectedMessage);

        Assert.assertTrue(message.contains("200"), "Wrong Error code");
   }
    @Test (description = "This page returned a 301 status code.")
    public void  test10() throws InterruptedException {
        driver.findElement(By.partialLinkText("301")).click();
        String message = driver.findElement(By.cssSelector("div p")).getText();
       // System.out.println(message);
        String expectedMessage = "This page returned a 301 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        Assert.assertEquals(message, expectedMessage);
    }

    @Test (description = "This page returned a 404 status code.")
    public void  test11() throws InterruptedException {
        driver.findElement(By.cssSelector("[href='status_codes/404']")).click();
        String message = driver.findElement(By.cssSelector("div p")).getText();
        //System.out.println(message);
        String expectedMessage = "This page returned a 404 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        Assert.assertEquals(message, expectedMessage);
    }
    @Test (description = "This page returned a 500 status code.")
    public void  test12() throws InterruptedException {
        driver.findElement(By.cssSelector("[href='status_codes/500']")).click();
        String message = driver.findElement(By.cssSelector("div p")).getText();
        //System.out.println(message);
        String expectedMessage = "This page returned a 500 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        Assert.assertEquals(message, expectedMessage);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    /*
    Test Case #9
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. And click on “Status Codes”.
    Step 3. Then click on “200”.
    Step 4. Verify that following message is displayed: “This page returned a 200 status code”
    */

      /*
    Test Case #10
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. And click on “Status Codes”.
    Step 3. Then click on “301”.
    Step 4. Verify that following message is displayed: “This page returned a 301 status code”
     */

       /*
    Test Case #11
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 3. And click on “Status Codes”.
    Step 4. Then click on “404”.
    Step 5. Verify that following message is displayed: “This page returned a 404 status code”
     */

        /*
    Test Case #12
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 3. And click on “Status Codes”.
    Step 4. Then click on “500”.
    Step 5. Verify that following message is displayed: “This page returned a 500 status code”
     */
}
