package com.toladata.tests.projectphasestestcases;

import com.toladata.assertions.projectassertions.ProjectAssertions;
import com.toladata.config.ConfigLoader;
import com.toladata.driver.BaseTest;
import com.toladata.pages.details.Details;
import com.toladata.pages.homepage.HomePage;
import com.toladata.pages.loginpage.LoginPage;
import com.toladata.utils.RandomDataSets;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PhasesTestCases extends BaseTest {
    protected HomePage homePage;
    private Details details;
    protected LoginPage login;
    protected ConfigLoader config;
    protected ProjectAssertions projectAssertions;

    @BeforeClass
    public void setupPageObjects() {
        //Initialize Page Objects
        homePage = new HomePage(driver);
        details = new Details(driver);
        login = new LoginPage(driver);
        config = new ConfigLoader("config.properties");
        projectAssertions = new ProjectAssertions(driver);

        //Login onto toladata platform
        String tUserName = config.getValue("validUsername");
        String tPassword = config.getValue("validPassword");
        login.userLogin(tUserName, tPassword);
        login.clickOnCaptcha();
        login.clickOnLogin();
    }

    @AfterClass
    public void tearDownPageObjects() {
        homePage = null;
        details = null;
        login = null;
        projectAssertions = null;
    }

    @Test(priority = 0)
    public void testCreateNewProjectSuccessFully() {
        homePage.projectMenu();
        homePage.addNewProject();
        homePage.populateProjectData(RandomDataSets.randomProjectNames());
        homePage.saveProject();

        //Assert project has been created successfully
        Assert.assertTrue(projectAssertions.getActualProjectCreatedMessageAlert().contains(projectAssertions.getExpectedProjectCreatedMessageAlert()));
        projectAssertions.waitUntilProjectSuccessMessageHasDisappeared();
    }

    @Test(priority = 1)
    public void testCreateNewPhaseToExistingProject() {
        details.projectDetails();
        details.phasesTab();
        details.addANewPhase();
        details.populateProjectPhaseData(RandomDataSets.randomPhaseNames());
        details.saveProject();

        //Assert project phase has been created successfully
        Assert.assertTrue(projectAssertions.getActualProjectCreatedMessageAlert().contains(projectAssertions.getExpectedProjectPhaseCreatedMessageAlert()));
        projectAssertions.waitUntilProjectSuccessMessageHasDisappeared();
    }

    @Test(priority = 2)
    public void testEditAlreadyCreatedPhaseSuccessfully() {
        details.editPhase(RandomDataSets.randomPhaseNames());

        //Assert project has been edited successfully
        Assert.assertTrue(projectAssertions.getActualProjectCreatedMessageAlert().contains(projectAssertions.getExpectedProjectPhaseUpdatedMessageAlert()));
        projectAssertions.waitUntilProjectSuccessMessageHasDisappeared();
    }

    @Test(priority = 3)
    public void testDeleteAlreadyCreatedPhaseSuccessfully() {
        details.deletePhase();
        //Assert project has been deleted successfully
        Assert.assertTrue(projectAssertions.getActualProjectCreatedMessageAlert().contains(projectAssertions.getExpectedProjectPhaseDeletedMessageAlert()));
        projectAssertions.waitUntilProjectSuccessMessageHasDisappeared();
    }
}
