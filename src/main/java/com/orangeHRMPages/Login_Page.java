package com.orangeHRMPages;

import com.utilsPages.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends Base_Page
{
    public Login_Page()
    {
        super();
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    @FindBy(xpath="//input[@name='username']")
    WebElement userName;

    @FindBy(xpath="//input[@name='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath="//h6[text()='Dashboard']")
    WebElement verifyLoginFunction;

    public void login(String username,String pass)
    {
        writeText(username,userName);
        writeText(pass,password);
        clickButton(loginButton);
    }

    public String actualOutput()
    {
        return verifyLoginFunction.getText();
    }

    public String expectedOutput()
    {
        return "Dashboard";
    }
}