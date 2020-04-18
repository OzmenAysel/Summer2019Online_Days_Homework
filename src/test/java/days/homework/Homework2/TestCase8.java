package days.homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BrowserFactory;

public class TestCase8 {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.cssSelector("[id='myCountry']")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[type='button']")).click();
        WebElement message = driver.findElement(By.id("result"));
        Assert.assertEquals(message.getText(), "You selected: United States of America");
        driver.quit();
    }
    /*
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. And click on “Autocomplete”.
    Step 3. Enter “United States of America” into country input box.
    Step 4. Verify that following message is displayed: “You selected: United States of America”
    -----------------------------------------------------------
    Optional: If you want to to be a real selenium hero, use @DataProvider for for tests cases
    from 9 through 12. Please use following documentation:
    https:// testng.org/doc/documentationmain.html#parameters-dataproviders
     */
}
