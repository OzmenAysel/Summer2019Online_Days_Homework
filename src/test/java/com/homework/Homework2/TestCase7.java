package com.homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.utils.BrowserFactory;

public class TestCase7 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();
        WebElement file = driver.findElement(By.id("file-upload"));
        file.sendKeys("C:\\Users\\aysel\\Desktop\\08 13 2019 packages-commands.txt");
        Thread.sleep(3000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);

        String subjectExpected = "File Uploaded!";
        String actualSubject = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(subjectExpected,actualSubject);

        String expectedFileName = "08 13 2019 packages-commands.txt";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedFileName);

        Thread.sleep(3000);
        driver.quit();
    }
    /*
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. And click on “File Upload".
    Step 3. Upload any ﬁle with .txt extension from your computer.
    Step 4. Click “Upload” button.
    Step 5. Verify that subject is: “File Uploaded!”
    Step 6. Verify that uploaded ﬁle name is displayed.
    -----------------------------------------------------
    Note: use element.sendKeys(“/ﬁle/path”) with specifying path to the ﬁle for uploading.
    Run this method against “Choose File” button.
     */
}
