package com.utilsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver() {
        driver.set(new ChromeDriver());
    }

    public static void initializeBrowser(String url)
    {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
