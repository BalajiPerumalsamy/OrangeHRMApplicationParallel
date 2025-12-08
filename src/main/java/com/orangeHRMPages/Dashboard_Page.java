package com.orangeHRMPages;

import com.utilsPages.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Page extends Base_Page
{
    public Dashboard_Page()
    {
        super();
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    @FindBy(xpath="//span[text()='PIM']")
    WebElement pim;

    @FindBy(xpath="//h6[text()='PIM']")
    WebElement verifyPIM;

    public void navigateToPIM()
    {
        clickButton(pim);
    }

    public String actualOutput()
    {
        return verifyPIM.getText();
    }

    public String ExpectedOutput()
    {
        return "PIM";
    }
}