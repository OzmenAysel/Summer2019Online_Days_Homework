package tests.BasicNavigation.utilities;


import com.homework.BasicNavigation.utilities.BrowserFactory;
import com.homework.BasicNavigation.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    /*
    1. Create a new class TitleVerification under utilities package and create a main method.
    2. Add this ArrayList declaration to the main method:
    List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
    "http://practice.cybertekschool.com/dropdown",
    "http://practice.cybertekschool.com/login");
    3. Open chrome browser
    4. Visit all the websites from step 3 and verify that they all have the same title.
    5. Verify that all URLs of all pages start with http://practice.cybertekschool.com .
    6. Close the browser at the end of the test.
     */

           public static void main(String[] args) {

               List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                       "http://practice.cybertekschool.com/dropdown",
                       "http://practice.cybertekschool.com/login");

               WebDriver driver = BrowserFactory.getDriver("chrome");
               driver.get(urls.get(0));
               String firstPageTitle = driver.getTitle();
               String Url1 = driver.getCurrentUrl();
               System.out.println(StringUtility.verifyStartWith(Url1,"http://practice.cybertekschool.com"));
               driver.get(urls.get(1));
               String secondPageTitle = driver.getTitle();
               System.out.println(StringUtility.verifyEquals(firstPageTitle,secondPageTitle));
               String Url2 = driver.getCurrentUrl();
               System.out.println(StringUtility.verifyStartWith(Url2,"http://practice.cybertekschool.com"));
               driver.get(urls.get(2));
               String thirdPageTitle = driver.getTitle();
               System.out.println(StringUtility.verifyEquals(firstPageTitle,thirdPageTitle));
               String Url3 = driver.getCurrentUrl();
               System.out.println(StringUtility.verifyStartWith(Url3,"http://practice.cybertekschool.com"));
               driver.quit();
           }

           }



