package com.orangeHRMTests;

import com.orangeHRMPages.*;
import com.utilsPages.DriverFactory;
import com.utilsPages.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AddEmployeePageTest
{
    public Base_Page basePage;
    public Properties properties;
    public Login_Page loginPage;
    public Dashboard_Page dashboardPage;
    public PIM_Page pimPage;
    public AddEmployee_Page addEmployeePage;

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
        addEmployeePage=new AddEmployee_Page();
        loginPage.login(properties.getProperty("userName"),properties.getProperty("password"));
        dashboardPage.navigateToPIM();
        pimPage.navigateToAddEmployee();
        Assert.assertEquals(pimPage.actualAddEmployee(),pimPage.expectedAddEmployee(),"Couldn't navigate to Add Employee page");
    }
    @DataProvider(name="excelData")
    public Object[][] getEmployeeData()
    {
        String filePath="C://Users//ELCOT//Desktop//Test case//InputData.xlsx";
        return ExcelUtils.getExcelData(filePath, "Sheet1");
    }

    @Test(dataProvider="excelData")
    public void verifyAddEmployee(String firstName, String lastName,String licenceNum,String licenceExpDate,String dofBirth)
    {
        addEmployeePage.AddEmployee(firstName,lastName,licenceNum,licenceExpDate,dofBirth);
        Assert.assertEquals(addEmployeePage.actualDataSaved(),addEmployeePage.expectedDataSaved(),"Couldn't save user data");
        Assert.assertEquals(addEmployeePage.actualDataUpdated(),addEmployeePage.expectedDataUpdated(),"Couldn't update user data");
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
