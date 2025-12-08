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

public class DeleteEmployeePageTest
{
    Base_Page basePage;
    Login_Page loginPage;
    Dashboard_Page dashboardPage;
    PIM_Page pimPage;
    AddEmployee_Page addEmployeePage;
    EmployeeList_Page employeeListPage;
    DeleteEmployee_Page deleteEmployeePage;
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
        loginPage=new Login_Page();
        loginPage.login(properties.getProperty("userName"),properties.getProperty("password"));
        dashboardPage=new Dashboard_Page();
        dashboardPage.navigateToPIM();
        pimPage=new PIM_Page();
        pimPage.navigateToEmployeeList();
        employeeListPage=new EmployeeList_Page();
        employeeListPage.clickSearchButton(properties.getProperty("empName"),properties.getProperty("empID"));
    }
    @Test
    public void verifyDelete()
    {
        deleteEmployeePage=new DeleteEmployee_Page();
        deleteEmployeePage.delete();
        Assert.assertEquals(deleteEmployeePage.actualOutput(),deleteEmployeePage.expectedOutput(),"Couldn't Delete user data");
    }
    @AfterMethod
    public void tearDown()
    {
        try
        {
            Thread.sleep(15000);
            basePage.quit();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}