package com.days.day3;

import org.openqa.selenium.WebDriver;
import com.utils.BrowserFactory;

public class BrowserFactoryTest {

    public static void main(String[] args) {
        // Vasily
        //now we can get webdriver like this
        //getDriver() method will return webdriver object
        //and we can use reference variable to work with that object
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com");
        //how we can print a source code of the page?
        System.out.println(driver.getPageSource());
        //to finish test execution
        driver.quit();
    }
}

/*
public static void testLogin(WebDriver driver) {
     if(driver.getCurrentUrl().equals("<expectedPageURL>"))
     {
       String pageSource = driver.getPageSource();
       Assert.assertTrue("Login was not successful!", pageSource.contains("Welcome to the page!"));
       System.out.println(pageSource);
     }
     else
     {
         System.out.println("Not navigated to the correct page");
     }
  }
 */

