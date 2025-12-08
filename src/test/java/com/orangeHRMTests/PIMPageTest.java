package com.orangeHRMTests;

import com.orangeHRMPages.Base_Page;
import com.orangeHRMPages.Dashboard_Page;
import com.orangeHRMPages.Login_Page;
import com.orangeHRMPages.PIM_Page;
import com.utilsPages.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PIMPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public PIM_Page pimPage;
    public  Properties properties;

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
        loginPage=new Login_Page();
        dashboardPage=new Dashboard_Page();
        pimPage=new PIM_Page();
        loginPage.login(properties.getProperty("userName"),properties.getProperty("password"));
        dashboardPage.navigateToPIM();
    }
    @Test(priority=1)
    public void verifyAddEmployee()
    {
        pimPage.navigateToAddEmployee();
        Assert.assertEquals(pimPage.actualAddEmployee(),pimPage.expectedAddEmployee(),"Couldn't Navigate to Add Employee Page");
    }
    @Test(priority=2)
    public void verifyEmployeeList()
    {
        pimPage.navigateToEmployeeList();
        Assert.assertEquals(pimPage.actualEmployeeList(),pimPage.expectedEmployeeList(),"Couldn't Navigate to Employee List Page");
    }
    @Test(priority=3)
    public void verifyReport()
    {
        pimPage.navigateToReport();
        Assert.assertEquals(pimPage.actualEmployeeReport(),pimPage.expectedEmployeeReport(),"Couldn't Navigate to Employee Reports Page");
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