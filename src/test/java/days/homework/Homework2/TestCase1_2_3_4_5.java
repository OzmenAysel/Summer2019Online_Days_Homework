package days.homework.Homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase1_2_3_4_5 {
    /*
    Please create test scripts from 1 through 5 in the same class, with implementing
    @Before method for driver setup, and @After method for driver close.
    Also, do the same thing for tests cases from 9 through 12.
    */
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
    }
    @Test (description = "The date of birth is not valid")
    public void test1(){
        driver.findElement(By.cssSelector("input[name='birthday'] ")).sendKeys("wrong_dob");
        WebElement warningMessage = driver.findElement(By.cssSelector("[data-bv-result='INVALID'] "));
        Assert.assertEquals(warningMessage.getText(), "The date of birth is not valid");
    }
    @Test (description = "c++, java, JavaScript")
    public void test2(){
      //  WebElement languages = driver.findElement(By.xpath("(//div[@*='col-sm-5'])[1]"));
        WebElement c = driver.findElement(By.xpath("//label[contains(text(), 'C++')]"));
        Assert.assertEquals(c.getText(),"C++");
        WebElement java = driver.findElement(By.cssSelector("[for='inlineCheckbox2']"));
        Assert.assertEquals(java.getText(),"Java");
        WebElement javaScript = driver.findElement(By.xpath("//label[contains(text(),'JavaScript')]"));
        Assert.assertEquals(javaScript.getText(),"JavaScript");
    }
    @Test (description = "first name must be more than 2 and less than 64 characters long")
    public void test3(){
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("a");
        WebElement warningMessage = driver.findElement(By.xpath("//small[contains(text(), 'first name must')]"));
        Assert.assertEquals(warningMessage.getText(),"first name must be more than 2 and less than 64 characters long");
    }
    @Test
    public void test4(){
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("b");
        WebElement warningMessage = driver.findElement(By.xpath("//small[contains(text(), 'The last name m')]"));
        Assert.assertEquals(warningMessage.getText(), "The last name must be more than 2 and less than 64 characters long");
    }
    @Test (description = "You've successfully completed registration!")
    public void test5(){
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Aysel");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Dalcicek");
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("AyselD");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("ayseltanzanya@hotmail.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("02October2018.");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("425-615-0443");
        driver.findElement(By.cssSelector("[value='female']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("10/15/1982");
            WebElement dropdown1 = driver.findElement(By.cssSelector("[name='department']"));
            Select select1 = new Select (dropdown1);
            select1.selectByVisibleText("Department of Engineering");
            BrowserUtils.wait(2);
           // Assert.assertEquals(select1.getFirstSelectedOption().getText(), "Department of Engineering");
        WebElement dropdown2 = driver.findElement(By.cssSelector("[name='job_title']"));
        Select  select2 = new Select (dropdown2);
        select2.selectByVisibleText("QA");
        BrowserUtils.wait(2);
      //  Assert.assertEquals(select2.getFirstSelectedOption().getText(),"QA");
        driver.findElement(By.cssSelector("[id*='inlineCheckbox2']")).click();
      //  driver.findElement(By.cssSelector("[value='cplusplus']")).click();
        driver.findElement(By.id("wooden_spoon")).click();


       WebElement warningMessage = driver.findElement(By.cssSelector("div p")); //*[@id=\"content\"]/div/div/p
        Assert.assertEquals(warningMessage.getText(), "You've successfully completed registration!");

    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }

     /*
    Test case #1
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
    Step 2. Click on “Registration Form”
    Step 3. Enter “wrong_dob” into date of birth input box.
    Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     */
      /*
     Test case #2
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
    Step 2. Click on “Registration Form”
    Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
     */

      /*
    Test case #3
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com/”
    Step 2. Click on “Registration Form”
    Step 3. Enter only one alphabetic character into ﬁrst name input box.
    Step 4. Verify that warning message is displayed: “ﬁrst name must be more than 2 and less than 64 characters long”
     */

      /*
    Test case #4
    Step 1. Go to https://practicecybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter only one alphabetic character into last name input box.
    Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
     */

      /*
    Test case #5
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    Step 3. Enter any valid ﬁrst name.
    Step 4. Enter any valid last name.
    Step 5. Enter any valid user name.
    Step 6. Enter any valid password.
    Step 7. Enter any valid phone number.
    Step 8. Select gender.
    Step 9. Enter any valid date of birth.
    Step 10. Select any department.
    Step 11. Enter any job title.
    Step 12. Select java as a programming language.
    Step 13. Click Sign up.
    Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
    --------------------------------------------------------
    Note: for using dropdown, please refer to the documentation:
    https://selenium.dev/selenium/ docs/api/java/org/openqa/selenium/support/ui/ Select.html
    or, please watch short video about dropdowns that is posted on canvas.
     */
}
