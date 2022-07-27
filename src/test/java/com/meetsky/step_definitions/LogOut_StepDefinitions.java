package com.meetsky.step_definitions;

import com.meetsky.pages.BasePage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOut_StepDefinitions extends BasePage {

    private static final String login_page_url = ConfigurationReader.getProperty("login_page_url");
    private LoginPage loginPage = new LoginPage();
    private Login_StepDefinitions loginSteps = new Login_StepDefinitions();

    @Given("User click to settings expand button on top-right corner")
    public void userClickToSettingsExpandButtonOnTopRightCorner() {
        topRightSettingsExpandButton.click();
    }

    @Then("Click to Log out button")
    public void clickToLogOutButton() {
        accountMenuLogoutButton.click();
    }

    @Then("User should be able to logged out successfully and can see the login page")
    public void userShouldBeAbleToLoggedOutSuccessfullyAndCanSeeTheLoginPage() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().startsWith(login_page_url));
    }

    @And("User should not be able to go to home page again by clicking step back button")
    public void userShouldNotBeAbleToGoToHomePageAgainByClickingStepBackButton() {
        Driver.getDriver().navigate().back();
        new WebDriverWait(Driver.getDriver(), 10).until(
                webDriver -> webDriver.getCurrentUrl().startsWith(login_page_url));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }

    @Given("User logs in with valid credentials")
    public void userLogsInWitValidCredentials() {
        loginSteps.userGoesToLoginPage();
        loginPage.login(
                ConfigurationReader.getProperty("valid_username"),
                ConfigurationReader.getProperty("valid_password"));
        loginSteps.userShouldBeLoggedIn();
    }
}