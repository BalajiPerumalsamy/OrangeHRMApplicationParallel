package com.orangeHRMTests;

import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.Login_Page;
import com.utilsPages.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Properties properties;
    @BeforeMethod
    public void setUp()
    {
        try
        {
            String file="C:\\Users\\ELCOT\\IdeaProjects\\Selenium_with_Parallel\\src\\test\\java\\com\\orangeHRMTests\\InputData.properties";
            properties=new Properties();
            FileInputStream input=new FileInputStream(file);
            properties.load(input);

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        DriverFactory.setDriver();
        DriverFactory.initializeBrowser(properties.getProperty("url"));
        basePage=new Base_Page();
    }
    @Test
    public void verifyLogin()
    {
        loginPage=new Login_Page();
        loginPage.login(properties.getProperty("userName"),properties.getProperty("password"));
        Assert.assertEquals(loginPage.actualOutput(),loginPage.expectedOutput(),"Couldn't navigate to Dashboard page");
    }
    @AfterMethod
    public void tearDown()
    {
        try
        {
            Thread.sleep(10000);
            basePage.quit();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}