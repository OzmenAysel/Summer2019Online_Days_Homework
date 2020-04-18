package tests.BasicNavigation.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import com.cbt.utilities.Wait;
import org.openqa.selenium.WebDriver;

public class NavigationTest {
       /* Tests
    1. Create class NavigationTests under tests package.
    2. Automate the provided test case using 3 different browsers.
    3. Create a separate test method for each browser.
        a. If you are using Windows, create test methods for Chrome, Firefox, Edge.
        b. If you are using Mac, create test methods for Chrome, Firefox, Safari.
    4. Each test should close the browser after completion.
    5. Test methods must use the utilities.
    6. Run all three test methods from the main method.
        Test Case
        1. Open browser
        2. Go to website https://google.com
        3. Save the title in a string variable
        4. Go to https://etsy.com
        5. Save the title in a string variable
        6. Navigate back to previous page
        7. Verify that title is same is in step 3
        8. Navigate forward to previous page
        9. Verify that title is same is in step 5
     */

    public static void main(String[] args) {
         // getChrome();
         // getFireFox();
        getEdge();
    }
    public static void getChrome(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        String titleFirst = driver.getTitle();
        System.out.println(titleFirst);
        Wait.wait(1);
        driver.navigate().to("https://etsy.com");
        String titleSecond = driver.getTitle();
        System.out.println(titleSecond);
        Wait.wait(1);
        driver.navigate().back();
        System.out.println(StringUtility.verifyEquals(titleFirst,driver.getTitle()));
        driver.navigate().forward();
        System.out.println(StringUtility.verifyEquals(titleSecond,driver.getTitle()));
        driver.quit();
    }

    public static void getFireFox(){
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("http://google.com");
        String titleFirst = driver.getTitle();
        System.out.println(titleFirst);
        Wait.wait(1);
        driver.navigate().to("https://etsy.com");
        String titleSecond = driver.getTitle();
        System.out.println(titleSecond);
        Wait.wait(1);
        driver.navigate().back();
        System.out.println(StringUtility.verifyEquals(titleFirst,driver.getTitle()));
        driver.navigate().forward();
        System.out.println(StringUtility.verifyEquals(titleSecond,driver.getTitle()));
        driver.quit();
    }

    public static void getEdge() {
        WebDriver driver = BrowserFactory.getDriver("edge");
        driver.get("http://google.com");
        String titleFirst = driver.getTitle();
        System.out.println(titleFirst);
        Wait.wait(1);
        driver.navigate().to("https://etsy.com");
        String titleSecond = driver.getTitle();
        System.out.println(titleSecond);
        Wait.wait(1);
        driver.navigate().back();
        System.out.println(StringUtility.verifyEquals(titleFirst, driver.getTitle()));
        driver.navigate().forward();
        System.out.println(StringUtility.verifyEquals(titleSecond, driver.getTitle()));
        driver.quit();
    }

}
