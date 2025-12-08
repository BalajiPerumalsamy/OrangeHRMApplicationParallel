package com.orangeHRMPages;

import com.utilsPages.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIM_Page extends Base_Page
{
    public PIM_Page()
    {
        super();
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    @FindBy(xpath="//a[text()='Add Employee']")
    WebElement addEmp;

    @FindBy(xpath="//a[text()='Employee List']")
    WebElement empList;

    @FindBy(xpath="//a[text()='Reports']")
    WebElement report;

    @FindBy(xpath="//h6[text()='Add Employee']")
    WebElement addEmployee;

    @FindBy(xpath="//h5[text()='Employee Information']")
    WebElement employeeList;

    @FindBy(xpath="//h5[text()='Employee Reports']")
    WebElement employeeReport;

    public void navigateToAddEmployee()
    {
        clickButton(addEmp);
    }

    public void navigateToEmployeeList()
    {
        clickButton(empList);
    }

    public void navigateToReport()
    {
        clickButton(report);
    }

    public String actualAddEmployee()
    {
        return addEmployee.getText();
    }

    public String expectedAddEmployee()
    {
        return "Add Employee";
    }

    public String actualEmployeeList()
    {
        return employeeList.getText();
    }

    public String expectedEmployeeList()
    {
        return "Employee Information";
    }

    public String actualEmployeeReport()
    {
        return employeeReport.getText();
    }

    public String expectedEmployeeReport()
    {
        return "Employee Reports";
    }
}