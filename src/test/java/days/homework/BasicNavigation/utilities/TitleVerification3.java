package tests.BasicNavigation.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

    /*
    1. Create a new class TitleVerification3 under utilities package and create a main method.
    2. Do the same test case as in the previous exercise, except this time open and close a
    new browser for each web site.
     */

public class TitleVerification3 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://walmart.com", "https://westelm.com");
        WebDriver driver1 = BrowserFactory.getDriver("chrome");
        driver1.get(urls.get(0));
        String title1 = driver1.getTitle();
        String t1 = title1.toLowerCase().replace(" ","");
        String Url1 = driver1.getCurrentUrl();
        System.out.println(StringUtility.verifyContains(Url1,t1));
        driver1.close();
        WebDriver driver2 = BrowserFactory.getDriver("chrome");
        driver2.get(urls.get(1));
        String title2 = driver2.getTitle();
        String t2 = title2.toLowerCase().replace(" ","");
        String Url2 = driver2.getCurrentUrl();
        System.out.println(StringUtility.verifyContains(Url2,t2));
        driver2.close();
        WebDriver driver3 = BrowserFactory.getDriver("chrome");
        driver3.get(urls.get(2));
        String title3 = driver3.getTitle();
        String t3= title3.toLowerCase().replace(" ","");
        String Url3 = driver3.getCurrentUrl();
        System.out.println(StringUtility.verifyContains(Url3,t3));
        driver3.close();
        WebDriver driver4 = BrowserFactory.getDriver("chrome");
        driver4.get(urls.get(3));
        String title4 = driver4.getTitle();
        String t4=title4.toLowerCase().replace(" ","");
        String Url4 = driver4.getCurrentUrl();
        System.out.println(StringUtility.verifyContains(Url4,t4));
        driver4.close();
    }
}
