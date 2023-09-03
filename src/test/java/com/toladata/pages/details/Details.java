package com.toladata.pages.details;

import com.toladata.config.TestDataLoader;
import com.toladata.utils.WebDriverWaitStrategies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Details {
    WebDriver driver;
    WebDriverWaitStrategies wait;
    TestDataLoader dataLoader;

    public Details(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWaitStrategies(driver);
        this.dataLoader = new TestDataLoader("projectPhaseTestData.properties");
        PageFactory.initElements(driver, this);
    }

    /**
     * Define Web Element Locators
     */
    @FindBy(xpath = "//span[normalize-space()='Details']")
    private WebElement projectDetails;
    @FindBy(xpath = "//a[normalize-space()='Phases']")
    private WebElement projectDetailsPhases;
    @FindBy(xpath = "//button[@class='mg-ui-button mg-ui-button--primary']")
    private WebElement addPhase;
    @FindBy(xpath = "//p[@class='font-italic color--gray-light']")
    private WebElement noPhasesCurrently;
    @FindBy(xpath = "//input[@name='phase-start-date']")
    private WebElement phaseStartDate;
    @FindBy(xpath = "//input[@name='phase-end-date']")
    private WebElement phaseEndDate;
    @FindBy(id = "description")
    private WebElement phaseDescription;
    @FindBy(xpath = "//button[@class='mg-ui-button mg-ui-button--primary'] [@type='submit']")
    private WebElement savePhase;
    @FindBy(id = "name")
    private WebElement phaseName;
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
    @FindBy(xpath = "//*[name()='rect' and contains(@class,'bar-progre')]")
    private WebElement phaseElement;
    @FindBy(xpath = "//*[name()='i' and contains(@class,'icon-edit')]")
    private WebElement editPhase;
    @FindBy(xpath = "//*[name()='i' and contains(@class,'icon-trash')]")
    private WebElement deletePhase;
    @FindBy(xpath = "//button[@class='mg-ui-button mg-ui-button--primary mg-ui-button--danger']")
    private WebElement deletePhaseButton;

    public void projectDetails() {
        wait.waitForElementToBeClickable(projectDetails);
        projectDetails.click();
    }

    public void phasesTab() {
        wait.waitForElementToBeClickable(projectDetailsPhases);
        projectDetailsPhases.click();
    }

    public void addANewPhase() {
        wait.waitForElementToBeVisible(noPhasesCurrently);
        wait.waitForElementToBeVisibleAndClickable(addPhase, addPhase);
        addPhase.click();
    }

    public void populateProjectPhaseData(String randomPhaseName) {

        wait.waitForElementToBeVisible(phaseName);
        phaseName.sendKeys(randomPhaseName);

        //Populate Start Date
        wait.waitForElementToBeClickable(phaseStartDate);
        phaseStartDate.click();

        // Locate the month and year element and set the desired month and year
        String desiredStartMonthYear = dataLoader.getValue("phaseStartMonth");
        wait.waitForElementToBeVisible(calendarMonthYear);

        while (!calendarMonthYear.getText().equals(desiredStartMonthYear)) {
            wait.waitForElementToBeVisible(navigateToPreviousMonth);
            navigateToPreviousMonth.click();
        }
        // Locate the date element for June 1, 2023, and click on it
        calendar01June2023.click();

        //Populate End Date
        wait.waitForElementToBeClickable(phaseEndDate);
        phaseEndDate.click();

        // Locate the month and year element and set the desired month and year
        String desiredEndMonthYear = dataLoader.getValue("phaseEndMonth");
        wait.waitForElementToBeVisible(calendarMonthYear);

        while (!calendarMonthYear.getText().equals(desiredEndMonthYear)) {
            wait.waitForElementToBeVisible(navigateToNextMonth);
            navigateToNextMonth.click();
        }
        // Locate the date element for Sep 30, 2023, and click on it
        calendar30September2023.click();

        String tDescription = dataLoader.getValue("phaseDescription");

        phaseDescription.sendKeys(tDescription);
    }

    public void saveProject() {
        wait.waitForElementToBeClickable(savePhase);
        savePhase.click();
    }

    public void editPhase(String randomPhaseName) {
        wait.waitForElementToBeVisible(phaseElement);
        Actions builder = new Actions(driver);
        builder.click(phaseElement).build().perform();

        wait.waitForElementToBeClickable(editPhase);
        builder.click(editPhase).build().perform();

        wait.waitForElementToBeVisible(phaseName);
        phaseName.clear();
        phaseName.sendKeys(randomPhaseName);

        wait.waitForElementToBeClickable(savePhase);
        savePhase.click();
    }

    public void deletePhase() {
        wait.waitForElementToBeVisible(phaseElement);
        Actions builder = new Actions(driver);
        builder.click(phaseElement).build().perform();

        wait.waitForElementToBeClickable(deletePhase);
        builder.click(deletePhase).build().perform();

        wait.waitForElementToBeClickable(deletePhaseButton);
        deletePhaseButton.click();
    }


}
