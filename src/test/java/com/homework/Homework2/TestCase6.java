package com.homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.utils.BrowserFactory;

public class TestCase6 {
    public static void main(String[] args) throws InterruptedException {

    WebDriver driver = BrowserFactory.getDriver("chrome");
    driver.get("https://www.tempmailaddress.com/");
    WebElement email = driver.findElement(By.cssSelector("[id='email']"));
    String emailAddress = email.getText();

    driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
    driver.findElement(By.linkText("Sign Up For Mailing List")).click();
    driver.findElement(By.cssSelector("[name='full_name']")).sendKeys("Aysel Dalcicek");
    driver.findElement(By.cssSelector("[name='email']")).sendKeys(emailAddress);
    driver.findElement(By.name("wooden_spoon")).click();
    WebElement Message = driver.findElement(By.tagName("h3"));
    String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
    String actualMessage = Message.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
        driver.navigate().to("https://www.tempmailaddress.com/");

        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id='schranka']/tr[1]/td[1]")).click();
        String emailAddress2 = driver.findElement(By.cssSelector("[id='odesilatel']")).getText();
        Assert.assertEquals(emailAddress2,"do-not-reply@practice.cybertekschool.com");
        WebElement subject = driver.findElement(By.id("predmet"));
        Assert.assertEquals(subject.getText(),"Thanks for subscribing to practice.cybertekschool.com!");
        driver.quit();

    }

    /*
    Step 1. Go to "https://www.tempmailaddress.com/"
    Step 2. Copy and save email as a string.
    Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
    Step 4. And click on “Sign Up For Mailing List".
    Step 5. Enter any valid name.
    Step 6. Enter email from the Step 2.
    Step 7. Click Sign Up
    Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
    Step 9. Navigate back to the “https:// www.tempmailaddress.com/”
    Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
    Step 11. Click on that email to open it.
    Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
    Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
     */
}
