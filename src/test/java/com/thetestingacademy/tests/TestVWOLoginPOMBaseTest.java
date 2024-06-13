package com.thetestingacademy.tests;

import com.thetestingacademy.basetest.CommonToAllTest;
import com.thetestingacademy.pages.PageObjectModel.DashboardPage_POM;
import com.thetestingacademy.pages.PageObjectModel.LoginPage_POM;
import com.thetestingacademy.utils.PropertyReader;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLoginPOMBaseTest extends CommonToAllTest {


    @Test(groups = {"smoke"}, priority = 1)
    public void testLoginNegative() {

        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.openVWOLoginURL();
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds();

        // TestNG
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");

        // AssertJ
        Assertions.assertThat(error_msg_text )
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readyKey("error_message"));
    }

//    @Test(priority = 2)
//    public void testLoginPositive() {
//        LoginPage_POM loginPagePom = new LoginPage_POM();
//        loginPagePom.openVWOLoginURL();
//        loginPagePom.loginToVWOValidCreds();
//        DashboardPage_POM dashboardPagePom = loginPagePom.afterLoginVWOValidCreds();
//        String expected_username = dashboardPagePom.loggedInUserName();
//
//        // TestNG
//        Assert.assertEquals(expected_username, PropertyReader.readyKey("expected_username"));
//
//        // AssertJ
//        Assertions.assertThat(expected_username)
//                .isNotNull()
//                .isNotBlank()
//                .contains(PropertyReader.readyKey("expected_username"));
//
//    }


}
