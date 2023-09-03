# TolaData.io Website Automation Testing with Selenium, TestNG, Webdriver Manager, Log4j, Maven and Jenkins

![Automated Testing](images/automation.png)

This is a test project to automate TolaData.io, where I have used Selenium for Java, TestNG, Webdriver Manager, Java Faker, Log4j and Jenkins to ensure the quality and reliability of the website.

## Tools Used

### Selenium

![Selenium Logo](images/selenium.png)

Selenium is a powerful tool for automating web browsers. It allows us to interact with web elements, perform actions on web pages, and verify expected outcomes.


### TestNG

![TestNG Logo](images/testng.png)

TestNG is a testing framework inspired by JUnit and NUnit. It provides advanced testing capabilities such as parallel execution, data-driven testing, and test suite management.


### Jenkins

Jenkins is a leading open-source automation server. We use Jenkins to automate our testing process, including triggering tests, generating reports, and managing our CI/CD pipeline.

![Jenkins Logo](images/jenkins.png)

### Log4J

![Log4J Logo](images/log4j.png)

Log4j, short for "Log for Java," is a widely-used logging framework for Java applications. It provides a flexible and configurable way to manage application logs.


### Webdriver Manager

![Webdriver Manager Logo](images/Webdriver_Manager.png)

WebDriver Manager is a utility tool designed to simplify the setup and management of web drivers for Selenium-based automation testing


### Apache Maven

![Apache Maven Logo](images/Apache_Maven_logo.svg.png)

Apache Maven is a powerful and widely-used build automation and project management tool primarily used for Java projects but capable of handling projects in 
other programming languages as well. Maven simplifies the build process by providing a structured way to define project dependencies, 
manage project lifecycles, compile source code, run tests, package and distribute applications, and more


## Test Cases for Login Functionality

Below are test cases for the login functionality for the toladata web application.

### Test Case 1: Successful Login

- **Test Scenario:** Verify that a user can log in successfully with valid credentials.
- **Steps:**
    1. Launch the website.
    2. Enter valid username and password.
    3. Click the "Login" button.
- **Expected Result:** The user should be logged in and redirected to the dashboard.

### Test Case 2: Invalid Credentials Handling

- **Test Scenario:** Verify that the system handles invalid credentials gracefully.
- **Steps:**
    1. Launch the website.
    2. Enter invalid username and password.
    3. Click the "Login" button.
- **Expected Result:** The system should display an error message and not allow access.

## Test Cases for Project Phases

Below are test cases for creating a project and a project phase in the toladata web application

### Test Case 1: Create a new project successfully

- **Test Scenario:** Verify that a user can create a project successfully.
- **Steps:**
  1. Launch the website.
  2. Enter valid username and password.
  3. Click the "Login" button.
  4. Click on "Project" on the left pane.
  5. Click on "Add New Project"
  6. Fill in the mandatory fields. i.e. Project Name, Start Date and End Date
  7. Click on "Save" to save the project.
- **Expected Result:** The user should get a validation message that the project has been created successfully and that project should be active on the project dropdown combo box.

### Test Case 2: Create a new phase for the already created project successfully

- **Test Scenario:** Verify that a user can create a project phase for an already existing project successfully.
- **Steps:**
  1. Launch the website.
  2. Enter valid username and password.
  3. Click the "Login" button.
  4. Click on "Project" on the left pane.
  5. Click on "Add New Project"
  6. Fill in the mandatory fields. i.e. Project Name, Start Date and End Date
  7. Click on "Save" to save the project.
  8. Click on "Details" on the left pane.
  9. Make sure your project is active on the project combo box drop down.
  10. Click on the phases tab.
  11. Click on "Add a phase".
  12. Fill in the fields. i.e. Phase Name, Start Date, End Date and Description
  13. Save the project phase by clicking on "Save"
- **Expected Result:** The user should get a validation message that the project phase has been created successfully.

### Test Case 3: Edit a project phase successfully

- **Test Scenario:** Verify that a user can edit a project phase successfully.
- **Steps:**
  1. Launch the website.
  2. Enter valid username and password.
  3. Click the "Login" button.
  4. Click on "Project" on the left pane.
  5. Click on "Add New Project"
  6. Fill in the mandatory fields. i.e. Project Name, Start Date and End Date
  7. Click on "Save" to save the project.
  8. Click on "Details" on the left pane.
  9. Make sure your project is active on the project combo box drop down.
  10. Click on the phases tab.
  11. Click on "Add a phase".
  12. Fill in the fields. i.e. Phase Name, Start Date, End Date and Description
  13. Save the project phase by clicking on "Save"
  14. Click on the phase at the bottom and click on the edit icon.
  15. Edit a parameter in the phase and click on save
- **Expected Result:** The user should get a validation message that the project phase has been updated successfully.

### Test Case 4: Delete a project phase successfully

- **Test Scenario:** Verify that a user can delete a project phase successfully.
- **Steps:**
  1. Launch the website.
  2. Enter valid username and password.
  3. Click the "Login" button.
  4. Click on "Project" on the left pane.
  5. Click on "Add New Project"
  6. Fill in the mandatory fields. i.e. Project Name, Start Date and End Date
  7. Click on "Save" to save the project.
  8. Click on "Details" on the left pane.
  9. Make sure your project is active on the project combo box drop down.
  10. Click on the phases tab.
  11. Click on "Add a phase".
  12. Fill in the fields. i.e. Phase Name, Start Date, End Date and Description
  13. Save the project phase by clicking on "Save"
  14. Click on the phase at the bottom and click on the delete icon.
  15. Click on "Delete" on the popup window.
- **Expected Result:** The user should get a validation message that the project phase has been deleted successfully.
