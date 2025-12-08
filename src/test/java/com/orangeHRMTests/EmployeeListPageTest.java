package com.orangeHRMTests;

import com.orangeHRMPages.*;
import com.utilsPages.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EmployeeListPageTest
{
    public Base_Page basePage;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public PIM_Page pimPage;
    public EmployeeList_Page employeeList;
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
        employeeList=new EmployeeList_Page();
        loginPage.login(properties.getProperty("userName"),properties.getProperty("password"));
        dashboardPage.navigateToPIM();
        pimPage.navigateToEmployeeList();
    }
    @Test
    public void verifyEmployeeList()
    {
        employeeList.clickSearchButton(properties.getProperty("empName"),properties.getProperty("empID"));
        Assert.assertEquals(pimPage.actualEmployeeList(),pimPage.expectedEmployeeList(),"Couldn't navigate to Employee list page");
        Assert.assertEquals(employeeList.actualOutput(),employeeList.expectedOutput(),"No employee record found");
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
