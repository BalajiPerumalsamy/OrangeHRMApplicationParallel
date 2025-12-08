package com.orangeHRMPages;

import com.utilsPages.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteEmployee_Page extends Base_Page
{
    public DeleteEmployee_Page()
    {
        super();
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    //All Employee data delete that time use this
    @FindBy(xpath="//div[@class='oxd-checkbox-wrapper']/label")
    WebElement selectAllEmployee;

    @FindBy(xpath="//button[contains(@class,'label-danger')]")
    WebElement clickDelete;

    //Specific Employee Data delete that time use this
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button[2]/i")
    WebElement deleteEmployee;

    @FindBy(xpath="//button[normalize-space()='Yes, Delete']")
    WebElement confirmDeleteButton;

    @FindBy(xpath="//p[contains(@class,'oxd-text--toast-message')]")
    WebElement message;

    public void delete()
    {
        clickButton(deleteEmployee);
        //clickButton(selectAllEmployee);
        //clickButton(clickDelete);
        wait.until(ExpectedConditions.visibilityOf(confirmDeleteButton));
        clickButton(confirmDeleteButton);
    }

    public String actualOutput()
    {
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText();
    }

    public String expectedOutput()
    {
        return "Successfully Deleted";
    }
}