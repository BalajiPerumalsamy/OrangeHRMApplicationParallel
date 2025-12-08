package com.orangeHRMPages;

import com.utilsPages.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class ForgotPassword_Page extends Base_Page
{
    public ForgotPassword_Page()
    {
        super();
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    @FindBy(xpath="//p[text()='Forgot your password? ']")
    WebElement forgotPassword;

    @FindBy(xpath="//input[@name='username']")
    WebElement userName;

    @FindBy(xpath="//button[@type='submit']")
    WebElement submit;

    @FindBy(xpath="//h6[text()='Reset Password link sent successfully']")
    WebElement verifyResetPassword;

    public void passwordReset(String user)
    {
        clickButton(forgotPassword);
        writeText(user,userName);
        clickButton(submit);
    }

    public String actualOutput()
    {
        return verifyResetPassword.getText();
    }

    public String expectedOutput()
    {
        return "Reset Password link sent successfully";
    }
}