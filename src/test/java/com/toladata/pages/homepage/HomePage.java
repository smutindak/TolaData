package com.toladata.pages.homepage;

import com.toladata.config.TestDataLoader;
import com.toladata.utils.WebDriverWaitStrategies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    WebDriverWaitStrategies wait;
    TestDataLoader dataLoader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWaitStrategies(driver);
        this.dataLoader = new TestDataLoader("projectTestData.properties");
        PageFactory.initElements(driver, this);
    }

    /**
     * Define Web Element Locators
     */
    @FindBy(xpath = "//span[normalize-space()='Project']")
    private WebElement project;
    @FindBy(xpath = "//mg-ui-button[@icon='plus']//button[@type='button']")
    private WebElement addNewProjectButton;
    @FindBy(id = "name")
    private WebElement projectName;
    @FindBy(xpath = "//mg-ui-date-picker-grid[@controlname='start_date']//span[@class='mg-ui-date-picker-grid__icon icon-calendar']")
    private WebElement projectStartDate;
    @FindBy(xpath = "//mg-ui-date-picker-grid[@controlname='end_date']//span[@class='mg-ui-date-picker-grid__icon icon-calendar']")
    private WebElement projectEndDate;
    @FindBy(css = "div[class='ml-1'] button[type='submit']")
    private WebElement saveProject;
    @FindBy(xpath = "//div[@class='myDpMonthYearText']")
    private WebElement calendarMonthYear;
    @FindBy(xpath = "//button[@aria-label='Previous Month']")
    private WebElement navigateToPreviousMonth;
    @FindBy(xpath = "//button[@aria-label='Next Month']")
    private WebElement navigateToNextMonth;
    @FindBy(xpath = "//span[@aria-label='Thursday, June 1, 2023']")
    private WebElement calendar01June2023;
    @FindBy(xpath = "//span[@aria-label='Saturday, September 30, 2023']")
    private WebElement calendar30September2023;

    public void projectMenu() {
        wait.waitForElementToBeClickable(project);
        project.click();
    }

    public void addNewProject() {
        wait.waitForElementToBeVisibleAndClickable(addNewProjectButton, addNewProjectButton);
        addNewProjectButton.click();
    }

    public void populateProjectData(String randomProjectName) {
        //Populate random Project name
        wait.waitForElementToBeVisible(projectName);
        projectName.sendKeys(randomProjectName);

        //Populate Start Date
        projectStartDate.click();

        // Locate the month and year element and set the desired month and year
        String desiredStartMonthYear = dataLoader.getValue("projectStartMonth");
        wait.waitForElementToBeVisible(calendarMonthYear);

        while (!calendarMonthYear.getText().equals(desiredStartMonthYear)) {
            wait.waitForElementToBeVisible(navigateToPreviousMonth);
            navigateToPreviousMonth.click();
        }
        // Locate the date element for June 1, 2023, and click on it
        calendar01June2023.click();

        //Populate End Date
        projectEndDate.click();

        // Locate the month and year element and set the desired month and year
        String desiredEndMonthYear = dataLoader.getValue("projectEndMonth");
        wait.waitForElementToBeVisible(calendarMonthYear);

        while (!calendarMonthYear.getText().equals(desiredEndMonthYear)) {
            wait.waitForElementToBeVisible(navigateToNextMonth);
            navigateToNextMonth.click();
        }
        // Locate the date element for Sep 30, 2023, and click on it
        calendar30September2023.click();
    }

    public void saveProject() {
        wait.waitForElementToBeClickable(saveProject);
        saveProject.click();
    }


}
