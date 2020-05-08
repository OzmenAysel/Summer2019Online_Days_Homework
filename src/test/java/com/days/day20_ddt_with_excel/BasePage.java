package com.days.day20_ddt_with_excel;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.BrowserUtils;
import com.utils.Driver;

//everything that is in common among pages
//can go here
//for example top menu elements don't belong to specific page
//top menu appears on every single page
//so we can keep them here
public class BasePage {

    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    public BasePage() {
        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.get(), this);
    }

    /*
     * While this loading screen present, html code is a not complete
     * Some elements can be missing
     * Also, you won't be able to interact with any elements
     * All actions will be intercepted
     * Waits until loader mask (loading bar, spinning wheel) disappears
     *
     * @return true if loader mask is gone, false if something went wrong
     */
    public boolean waitUntilLoaderMaskDisappear() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 30);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='loader-mask shown']")));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Loader mask not found!");
            e.printStackTrace();
            return true; // no loader mask, all good, return true
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
     * This method stands for navigation in vytrack app
     * provide tab name, for example "Fleet" as a String
     * and module name, for example "Vehicles" as a String as well
     * then based on these values, locators will be created
     *
     * @param moduleName
     * @param subModuleName normalize-space() same line .trim() in java
     */

     // marufjon's
     public void navigateTo(String moduleName, String subModuleName) {
         String tabLocator = "//span[normalize-space()='" + moduleName + "' and contains(@class, 'title title-level-1')]";
         String moduleLocator = "//span[normalize-space()='" + subModuleName + "' and contains(@class, 'title title-level-2')]";
         try {
             BrowserUtils.waitForClickablity(Driver.get().findElement(By.xpath(tabLocator)),5);
             WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
             new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
         } catch (Exception e) {
             BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
         }
         try {
             BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
             BrowserUtils.waitForClickablity(Driver.get().findElement(By.xpath(moduleLocator)),5);
             BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
             Driver.get().findElement(By.xpath(moduleLocator)).click();
         } catch (Exception e) {
             BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
             BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);
         }
     }


    // Vasily"s
//    public void navigateTo(String moduleName, String subModuleName) {
//        Actions actions = new Actions(Driver.get());
//        String moduleLocator = "//*[normalize-space()='" + moduleName + "' and @class='title title-level-1']";
//        String subModuleLocator = "//*[normalize-space()='" + subModuleName + "' and @class='title title-level-2']";
//
//        WebDriverWait wait = new WebDriverWait(Driver.get(), 20);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator)));
//
//        WebElement module = Driver.get().findElement(By.xpath(moduleLocator));
//        wait.until(ExpectedConditions.visibilityOf(module));
//        wait.until(ExpectedConditions.elementToBeClickable(module));
//
//        waitUntilLoaderMaskDisappear();
//
//        BrowserUtils.clickWithWait(module); //if click is not working well
//        WebElement subModule = Driver.get().findElement(By.xpath(subModuleLocator));
//        if (!subModule.isDisplayed()) {
//            actions.doubleClick(module).doubleClick().build().perform();
//            try {
//                wait.until(ExpectedConditions.visibilityOf(subModule));
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                BrowserUtils.clickWithJS(module);
//            }
//        }
//        BrowserUtils.clickWithWait(subModule); //if click is not working well
//        //it waits until page is loaded and ajax calls are done
//        BrowserUtils.waitForPageToLoad(10);
//    }

    /*
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }

    public String getUserName() {
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }

    public void logOut() {
        BrowserUtils.wait(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }

    public void goToMyUser() {
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForClickablity(userName, 5).click();
        BrowserUtils.waitForClickablity(myUser, 5).click();
    }

    public void waitForPageSubTitle(String pageSubtitleText) {
        new WebDriverWait(Driver.get(), 10).until(ExpectedConditions.textToBe(By.cssSelector("h1[class='oro-subtitle']"), pageSubtitleText));
    }

}