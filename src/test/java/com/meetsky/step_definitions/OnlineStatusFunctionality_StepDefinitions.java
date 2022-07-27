package com.meetsky.step_definitions;

import com.meetsky.pages.OnlineStatusFunctionalityPage;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineStatusFunctionality_StepDefinitions {
    OnlineStatusFunctionalityPage onlineStatusFunctionalityPage = new OnlineStatusFunctionalityPage();

    @Then("User goes to home page")
    public void userGoesToHomePage() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Files - Meetsky - QA"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    }

    @Given("user clicks to click on the profile icon on the right side of the page")
    public void userClicksToClickOnTheProfileIconOnTheRightSideOfThePage() {
        onlineStatusFunctionalityPage.EProfil.click();
    }

    @Then("user clicks on the set status text")
    public void userClicksOnTheSetStatusText() {
        onlineStatusFunctionalityPage.StatusButton.click();
    }

    @Then("user sees the online status page")
    public void userSeesTheOnlineStatusPage() {
        onlineStatusFunctionalityPage.SetStatusPage.isDisplayed();
    }

    @And("user can view the online status on the opened set status page")
    public void userCanViewTheOnlineStatusOnTheOpenedSetStatusPage() {
        onlineStatusFunctionalityPage.OnlineButton.isDisplayed();
    }

    @Then("user clicks the set online button")
    public void userClicksTheSetOnlineButton() {
        onlineStatusFunctionalityPage.StatusButton.click();

    }

    @And("user clicks the Away button on the online status page that opens")
    public void userClicksTheButtonOnTheOnlineStatusPageThatOpens() {
        onlineStatusFunctionalityPage.SetStatusPage.isDisplayed();

    }

    @Then("the User clicks the away button")
    public void theUserClicksTheAwayButton() {
        onlineStatusFunctionalityPage.AwayButton.click();
    }

    @Then("the user sees the set status page")
    public void theUserSeesTheOnlineStatusPage() {
        onlineStatusFunctionalityPage.OnlineButton.isDisplayed();
    }

    @And("the user selects a status message from the default option")
    public void theUserSelectsAStatusMessageFromTheDefaultOption() {
        onlineStatusFunctionalityPage.SickEmoji.click();
    }

    @Then("the user clicks the set status message button")
    public void theUserClicksTheSetStatusMessageButton() {
        onlineStatusFunctionalityPage.SetStatusMessageButton.click();
    }


    @Then("the user clicks sick")
    public void theUserClicksSick() {
        onlineStatusFunctionalityPage.SickEmoji.click();
    }

    @And("the user can set a custom status message using any emoji option")
    public void theUserCanSetACustomStatusMessageUsingAnyEmojiOption() {
        onlineStatusFunctionalityPage.SetStatusMessageButton.click();
    }

    @Then("the user should click on the set status message button")
    public void theUserShouldClickOnTheSetStatusMessageButton() {
        onlineStatusFunctionalityPage.SetStatusMessageButton.click();
    }

    @Given("User clicks on a selected exception message")
    public void userClicksOnASelectedExceptionMessage() {
        onlineStatusFunctionalityPage.StatusButton.click();
        onlineStatusFunctionalityPage.SickEmoji.click();
    }

    @Then("user clicks the clear status message button to clear the status message")
    public void userClicksTheClearStatusMessageButtonToClearTheStatusMessage() {
        onlineStatusFunctionalityPage.ClearStatusMessageButton.click();
    }

    @And("the user sees that the message has been deleted")
    public void theUserSeesThatTheMessageHasBeenDeleted() {
        onlineStatusFunctionalityPage.EProfil.click();
        onlineStatusFunctionalityPage.StatusButton.click();
    }

    @Then("user clicks the clear status after button to clear the status message automatically and can set a time")
    public void userClicksTheClearStatusAfterButtonToClearTheStatusMessageAutomaticallyAndCanSetATime() {
        onlineStatusFunctionalityPage.SetStatusPage.isDisplayed();
        onlineStatusFunctionalityPage.SickEmoji.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(onlineStatusFunctionalityPage.ClearAtSelect));

        onlineStatusFunctionalityPage.ClearAtSelect.click();
        onlineStatusFunctionalityPage.minutes30.click();
        onlineStatusFunctionalityPage.SetStatusMessageButton.click();
    }


    @Then("user click set status button")
    public void userClickSetStatusButton() {
        onlineStatusFunctionalityPage.StatusButton.click();
    }
}
