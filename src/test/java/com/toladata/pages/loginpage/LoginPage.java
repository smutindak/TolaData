package com.toladata.pages.loginpage;

import com.toladata.config.ConfigLoader;
import com.toladata.utils.WebDriverWaitStrategies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWaitStrategies wait;
    ConfigLoader configLoader;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWaitStrategies(driver);
        this.configLoader = new ConfigLoader("config.properties");
        PageFactory.initElements(driver, this);
    }

    /**
     * Define Web Element Locators
     */
    @FindBy(id = "emailAddress")
    private WebElement emailAddress;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(id = "recaptcha-anchor")
    private WebElement iAmNotARobotCheckBox;
    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    private WebElement captchaIFrame;

    public void userLogin(String userName, String userPassword) {
        wait.waitForElementToBeVisible(emailAddress);
        emailAddress.clear();
        emailAddress.sendKeys(userName);
        wait.waitForElementToBeVisible(password);
        password.clear();
        password.sendKeys(userPassword);
    }

    public void navigateToLoginUrl() {

        String loginPageUrl = configLoader.getValue("loginUrl");

        driver.get(loginPageUrl);
    }

    public void clickOnCaptcha() {
        //Switch To iframe to interact with recaptcha
        wait.waitForFrameToBeAvailableAndSwitchToIt(captchaIFrame);
        wait.waitForElementToBeClickable(iAmNotARobotCheckBox);
        iAmNotARobotCheckBox.click();

        //Switch back to the normal dom to interact with the elements outside the capture iframe
        driver.switchTo().defaultContent();
    }

    public void clickOnLogin() {
        wait.waitForElementToBeVisibleAndClickable(loginButton, loginButton);
        loginButton.click();
    }


}
