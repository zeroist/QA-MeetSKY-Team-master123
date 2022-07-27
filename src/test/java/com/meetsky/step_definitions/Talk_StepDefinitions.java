package com.meetsky.step_definitions;

import com.meetsky.pages.BasePage;
import com.meetsky.pages.LoginPage;
import com.meetsky.pages.TalkPage;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class Talk_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    TalkPage talkPage = new TalkPage();


    @Then("User goes to Talk page")
    public void user_goes_to_talk_page() {
        basePage.talkPageLink.click();
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Talk - Meetsky - QA"));
    }

    @Given("User clicks to plus sign on the left side of the page")
    public void user_clicks_to_plus_sign_on_the_left_side_of_the_page() {
        talkPage.createANewGroupConversation.click();
    }

    @Given("User enters the {string} conversation name")
    public void userEntersTheConversationName(String arg0) {
        talkPage.conversationNameInputBox.sendKeys("friends");
    }
    
    @Then("User clicks Add Participants button")
    public void user_clicks_add_participants_button() {
        talkPage.addParticipantsButton.click();
    }

    @Then("User chooses any of the contacts from the contacts list")
    public void user_user_chooses_any_of_the_contacts_from_the_contacts_list() {
        talkPage.addContactAdmin.click();
        talkPage.addContactEmployee10.click();
        talkPage.addContactEmployee100.click();

        Assert.assertTrue(talkPage.selectedParticipants.getText().contains("admin"));
        Assert.assertTrue(talkPage.selectedParticipants.getText().contains("Employee10"));
        Assert.assertTrue(talkPage.selectedParticipants.getText().contains("Employee100"));
    }

    @Then("User clicks Create Conversation button")
    public void user_clicks_create_conversation_button() {
        talkPage.createConversationButton.click();
    }

    @Then("User verify {string} has created")
    public void userVerifyHasCreated(String arg0) {
        Assert.assertTrue(talkPage.newChatName.getText().contains("friends"));
    }

    @Given("User clicks to {string} group on the left side of the page")
    public void userClicksToGroupOnTheLeftSideOfThePage(String arg0)
    {talkPage.newChatName.click();
    }
    
    @Then("User verify that he or she can see the participants of the group conversation under Participants tab")
    public void userVerifyThatHeSheCanSeeTheParticipantsOfTheGroupConversationUnderParticipantsTab() {
        Assert.assertTrue(talkPage.participantsTab.isDisplayed());
        Assert.assertTrue(talkPage.contactAdmin.isDisplayed());
        Assert.assertTrue(talkPage.contactEmployee10.isDisplayed());
        Assert.assertTrue(talkPage.contactEmployee100.isDisplayed());
    }

    @Then("User locates the participants of the group conversation under Participants tab")
    public void userLocatesTheParticipantsOfTheGroupConversationUnderParticipantsTab() {
        Assert.assertTrue(talkPage.participantsTab.isDisplayed());
        Assert.assertTrue(talkPage.contactAdmin.isDisplayed());
        Assert.assertTrue(talkPage.contactEmployee10.isDisplayed());
        Assert.assertTrue(talkPage.contactEmployee100.isDisplayed());
    }

    @And("User clicks to the three dots next to participant name")
    public void userClicksToTheThreeDotsNextToParticipantName() {
        talkPage.threeDotsParticipant.click();
    }

    @And("User clicks to the Remove participant button")
    public void userClicksToTheRemoveParticipantButton() {
        talkPage.removeParticipant.click();
    }

    @Then("User verify the participant has been succesfully removed from the group")
    public void userVerifyTheParticipantHasBeenSuccesfullyRemovedFromTheGroup() {
        Assert.assertFalse(talkPage.participantTable.getText().contains("admin"));
    }

    @Given("User clicks to three dots on the right side of the {string}")
    public void userClicksToThreeDotsOnTheRightSideOfThe(String arg0) {
        talkPage.conversationThreeDots.click();}


    @Then("User clicks to the Delete conversation button")
    public void userClicksToTheDeleteConversationButton() {
        talkPage.deleteConversationButton.click();
    }

    @Then("User clicks to Yes button on the pop-up asking Do you really want to delete friends?")
    public void user_clicks_to_yes_button_on_the_pop_up_asking_do_you_really_want_to_delete_friends() {
        talkPage.yesButton.click();
    }


    @Then("User verify that deleted group conversation is not existing inside the available group conversations")
    public void userVerifyThatDeletedGroupConversationIsNotExistingInsideTheAvailableGroupConversations() {
        Assert.assertFalse(talkPage.conversationList.getText().contains("friends"));
    }



}
