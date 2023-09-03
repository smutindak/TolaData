package com.toladata.tests.logintestcases;

import com.toladata.config.ConfigLoader;
import com.toladata.driver.BaseTest;
import com.toladata.assertions.loginassertions.LoginPageAssertions;
import com.toladata.pages.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestCases extends BaseTest {
    protected LoginPage login;
    protected LoginPageAssertions loginAssertions;
    protected ConfigLoader config;

    @BeforeClass
    public void setupPageObjects() {
        //Initialize Page Objects
        login = new LoginPage(driver);
        loginAssertions = new LoginPageAssertions(driver);
        config = new ConfigLoader("config.properties");
    }

    @AfterClass
    public void tearDownPageObjects() {
        login = null;
        loginAssertions = null;
        config = null;
    }

    @Test(priority = 0)
    public void testInvalidLoginIsWorkingCorrectly() throws InterruptedException {
        //Derive Credentials from property file
        String tUserName = config.getValue("invalidUsername");
        String tPassword = config.getValue("invalidPassword");

        login.userLogin(tUserName, tPassword);
        login.clickOnCaptcha();
        login.clickOnLogin();

        Assert.assertEquals(loginAssertions.getActualInvalidLoginError(), loginAssertions.getExpectedInvalidLoginError());
    }

    @Test(priority = 1)
    public void testInvalidUserNameValidPasswordLoginWontAllowLoginSuccess() throws InterruptedException {
        //Derive Credentials from property file
        String tUserName = config.getValue("invalidUsername");
        String tPassword = config.getValue("validPassword");

        login.userLogin(tUserName, tPassword);
        login.clickOnCaptcha();
        login.clickOnLogin();

        Assert.assertEquals(loginAssertions.getActualInvalidLoginError(), loginAssertions.getExpectedInvalidLoginError());
    }

    @Test(priority = 2)
    public void testPasswordIsMaskedCorrectly() throws InterruptedException {
        //Derive Credentials from property file
        String tUserName = config.getValue("invalidUsername");
        String tPassword = config.getValue("invalidPassword");

        login.userLogin(tUserName, tPassword);

        Assert.assertEquals(loginAssertions.verifyPasswordIsMaskedType(), loginAssertions.verifyExpectedPasswordIsMaskedType());
    }

    @Test(priority = 3)
    public void testSuccessfulUserLogin() throws InterruptedException {
        //Derive Credentials from property file
        String tUserName = config.getValue("validUsername");
        String tPassword = config.getValue("validPassword");

        login.userLogin(tUserName, tPassword);
        login.clickOnCaptcha();
        login.clickOnLogin();

        //Assert Login is successful
        Assert.assertEquals(loginAssertions.getActualLandingPageUrl(), loginAssertions.getExpectedLandingPageUrl());
    }
}
