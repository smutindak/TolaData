package com.toladata.driver;

import com.toladata.pages.loginpage.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    private static final Map<String, ITestResult> failedTests = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() throws Exception {

        /* Set up the chrome driver using bonigarcia package */
        WebDriverManager.chromedriver().setup();

        //Initialize Chrome Driver
        driver = new ChromeDriver();

        //Start Chrome Browser in maximized state
        driver.manage().window().maximize();

        //Navigate to Login Page
        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLoginUrl();

        logger.info("Login Successful");
    }

    @AfterClass
    public void teardown() {
        // Quit the WebDriver instance to close the browser session
        driver.quit();
    }

    private void takeScreenshot(String screenshotName) {
        // Convert WebDriver instance to TakesScreenshot
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

        // Capture the screenshot as a file
        File sourceFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

        // Specify the destination path for the screenshot
        String destinationPath = ".\\src" + screenshotName + ".png";

        try {
            // Copy the source file to the destination path
            Files.copy(sourceFile.toPath(), Path.of(destinationPath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void recordFailedTest(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Take a screenshot and save it immediately
            takeScreenshot(result.getName());
        }
    }
}
