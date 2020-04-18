package tests.BasicNavigation.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    /*
    1. Create a new class TitleVerification2 under utilities package and create a main method.
    2. Add this ArrayList declaration to the main method:
    List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
    "https://wayfair.com/", "https://walmart.com, "https:// westelm.com/");
    3. Visit all websites one by one.
    4. Verify that URL of the website contains the title of the website. Ignore spaces and case
    in comparison. For example, title of in the first website title is Lulu and Giorgia and the
    URL is https://lulugandgeorgia.com. So, this test case must pass.
    5. Close the browser at the end of the test.
         */

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/",
                "https://walmart.com/",
                "https://westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));
        String title1 = driver.getTitle();
        String t1 = title1.toLowerCase().replace(" ","");
        String Url1 = driver.getCurrentUrl();
        System.out.println(StringUtility.verifyContains(Url1,t1));
        driver.get(urls.get(1));
        String title2 = driver.getTitle();
        String t2 = title2.toLowerCase().replace(" ","");
        String Url2 = driver.getCurrentUrl();
        System.out.println(StringUtility.verifyContains(Url2,t2));
        driver.get(urls.get(2));
        String title3 = driver.getTitle();
        String t3= title3.toLowerCase().replace(" ","");
        String Url3 = driver.getCurrentUrl();
        System.out.println(StringUtility.verifyContains(Url3,t3));
        driver.get(urls.get(3));
        String title4 = driver.getTitle();
        String t4=title4.toLowerCase().replace(" ","");
        String Url4 = driver.getCurrentUrl();
        System.out.println(StringUtility.verifyContains(Url4,t4));
        driver.quit();
    }
}
