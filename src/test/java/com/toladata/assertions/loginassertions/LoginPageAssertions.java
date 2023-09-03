package com.toladata.assertions.loginassertions;

import com.toladata.config.ConfigLoader;
import com.toladata.utils.WebDriverWaitStrategies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAssertions {
    WebDriver driver;
    WebDriverWaitStrategies wait;

    public LoginPageAssertions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWaitStrategies(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Define Login Page Assertions
     */

    @FindBy(css = ".logo--top-bar")
    private WebElement landingPageHomeLogo;
    @FindBy(xpath = "//span[@class='notification_content']")
    private WebElement invalidLoginError;
    @FindBy(id = "password")
    private WebElement password;

    public String getExpectedLandingPageUrl() {
        ConfigLoader config = new ConfigLoader("config.properties");

        String expectedLoginUrl = config.getValue("landingPageUrl");

        wait.waitForUrlToBe(expectedLoginUrl);
        return expectedLoginUrl;
    }

    public String getActualLandingPageUrl() {
        wait.waitForElementToBeVisible(landingPageHomeLogo);
        return driver.getCurrentUrl();
    }

    public String getExpectedInvalidLoginError() {
        return "undefined";
    }

    public String getActualInvalidLoginError() {
        wait.waitForElementToBeVisible(invalidLoginError);
        return invalidLoginError.getText();
    }

    public String verifyPasswordIsMaskedType() {
        wait.waitForElementToBeVisible(password);
        return password.getAttribute("type");
    }

    public String verifyExpectedPasswordIsMaskedType() {
        return "password";
    }
}
