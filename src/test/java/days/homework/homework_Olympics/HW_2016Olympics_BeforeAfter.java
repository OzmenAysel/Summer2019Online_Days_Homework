package days.homework.homework_Olympics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.Driver;

import java.util.ArrayList;

public class HW_2016Olympics_BeforeAfter {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        Driver.get().manage().window().maximize();
    }

    @Test(description = "verify that the table is now sorted by the country names.")
    public void test1(){

        ArrayList<WebElement> rows = (ArrayList<WebElement>) Driver.get().findElements(By.xpath("//table[contains(@class, 'wikitable sortable')]//td[1]"));
        int[] nums = new int[rows.size()-2];
        for(int a=0; a<rows.size()-2; a++){
            nums[a] = Integer.parseInt(rows.get(a).getText());
        }
       // Assert.assertTrue(isSorted(nums), "Test failed");
        /*

        int[] nums = new int[rows.size()-2];
        for (int a=0; a<rows.size()-2; a++){
           nums[a]= Integer.parseInt(rows.get(a).getText());
       }
        Assert.assertTrue(isSorted(nums),"Test failed");
    }
         */
    }


     @AfterMethod

    public void teardown(){
        driver.close();
     }

}
