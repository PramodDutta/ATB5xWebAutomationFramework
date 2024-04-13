package com.thetestingacademy.pages.PageFactory;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.pages.PageObjectModel.DashboardPage_POM;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends CommonToAllPage {
    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }


    //  Page Locators


    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;


    // Page Actions
    public String loginToVWOInvalidCreds() {
        enterInput(username, PropertyReader.readyKey("username"));
        enterInput(password, "admin");
        clickElement(signButton);
//        presenceOfElement(error_message);
//        visibilityOfElement(error_message);
        return getElement(null).getText();

    }

    public void loginToVWOValidCreds() {
        enterInput(username, PropertyReader.readyKey("username"));
        enterInput(password, PropertyReader.readyKey("password"));
        clickElement(signButton);
        // Dashboard
    }

    public DashboardPage_POM afterLoginVWOValidCreds() {
        return new DashboardPage_POM();
    }


}
