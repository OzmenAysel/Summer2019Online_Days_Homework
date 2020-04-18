package tests.BasicNavigation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchAntalya {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("Antalya", Keys.ENTER);

    }
    }
