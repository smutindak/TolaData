package com.toladata.assertions.projectassertions;

import com.toladata.utils.WebDriverWaitStrategies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectAssertions {
    WebDriver driver;
    WebDriverWaitStrategies wait;

    public ProjectAssertions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWaitStrategies(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Define Web Element Locators
     */

    @FindBy(xpath = "//span[@class='notification_content']")
    private WebElement projectPhaseCreatedSuccessfullyAlert;

    /**
     * Expected Assertions
     */
    public String getExpectedProjectCreatedMessageAlert() {
        return "was successfully created.";
    }

    public String getExpectedProjectPhaseCreatedMessageAlert() {
        return "was successfully added.";
    }

    public String getExpectedProjectPhaseUpdatedMessageAlert() {
        return "was successfully updated.";
    }

    public String getExpectedProjectPhaseDeletedMessageAlert() {
        return "was successfully deleted.";
    }

    /**
     * Actual Assertions
     */
    public String getActualProjectCreatedMessageAlert() {
        wait.waitForElementToBeVisible(projectPhaseCreatedSuccessfullyAlert);
        return projectPhaseCreatedSuccessfullyAlert.getText();
    }

    public void waitUntilProjectSuccessMessageHasDisappeared() {
        wait.waitForElementToBeInvisible(projectPhaseCreatedSuccessfullyAlert);
    }
}
