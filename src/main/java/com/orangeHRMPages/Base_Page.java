package com.orangeHRMPages;

import com.utilsPages.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_Page
{
    public WebDriver driver;
    public WebDriverWait wait;

    public Base_Page()
    {
        driver=DriverFactory.getDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    public void writeText(String text, WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    public void clickButton(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void quit()
    {
        driver.quit();
    }
}