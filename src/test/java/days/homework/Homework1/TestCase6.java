package days.homework.Homework1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase6 {

        /*
    Step 1. Go to https://practicecybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “user” into username input box.
    Step 4. Verify that warning message is displayed:
    “The username must be more than 6 and less than 30 characters long”
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("username")).sendKeys("user");
        WebElement warningMessage = driver.findElement(By.xpath("//small[@style='display: block;']"));
        System.out.println(warningMessage.getText());

        String expectedResult = "The username must be more than 6 and less than 30 characters long";
        String actualResult = warningMessage.getText();
        if(actualResult.equals(expectedResult)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        Thread.sleep(2000);
        driver.quit();

    }
}