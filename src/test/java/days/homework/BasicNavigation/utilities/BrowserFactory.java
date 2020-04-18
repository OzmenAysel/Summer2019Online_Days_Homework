package tests.BasicNavigation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 /*
        Utilities
    1. Create class BrowserFactory under utilities package.
    2. Create a public static method getDriver which takes a string argument.
    3. If you are using Windows, and if the String argument is `safari`, return null. If
    you are using Mac, and if the String argument is `edge`, return null.
    NOTE For this step, you need to research how to find out your operating
    system programmatically using Java.
    4. In all other cases, return a new WebDriver object for ChromeDriver,
    FirefoxDriver, EdgeDriver or SafariDriver based on the value of the string
    argument.
    NOTE For this exercise, you need to research how to launch Edge using
    Selenium if you are using Windows.
    NOTE For this exercise, you need to research how to launch Safari using
    Selenium if you are using Mac.
     */

public class BrowserFactory {

        public static WebDriver getDriver(String browser){

            if(browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }else if (browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            return null;
        }
    }

