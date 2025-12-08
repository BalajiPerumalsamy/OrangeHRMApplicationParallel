package com.orangeHRMTests;

import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.ForgotPassword_Page;
import com.utilsPages.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ForgotPasswordPageTest
{
    Base_Page basePage;
    ForgotPassword_Page forgotPasswordPage;
    Properties properties;

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
        forgotPasswordPage=new ForgotPassword_Page();

    }
    @Test
    public void verifyForgotPassword()
    {
        forgotPasswordPage.passwordReset(properties.getProperty("userName"));
        Assert.assertEquals(forgotPasswordPage.actualOutput(),forgotPasswordPage.expectedOutput(),"Couldn't Reset password");
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