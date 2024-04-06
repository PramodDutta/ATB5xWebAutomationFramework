package com.thetestingacademy.tests;

import com.thetestingacademy.pages.PageObjectModel.LoginPage_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestVWOLoginPOM {


    @Test
    public void testLoginNegative(){
        LoginPage_POM loginPagePom = new LoginPage_POM();
        String error_msg_text  = loginPagePom.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");
    }



}
