package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalkPage {

    @FindBy(xpath = "//button[@data-original-title='null']")
    public WebElement createANewGroupConversation;
    @FindBy(xpath = "//input[@class='conversation-name']")
    public WebElement conversationNameInputBox;
    @FindBy(xpath = "//button[@class='navigation__button navigation__button-right primary']")
    public WebElement addParticipantsButton;
    @FindBy(xpath = "//span[.='admin']")
    public WebElement addContactAdmin;
    @FindBy(xpath = "//span[.='Employee10']")
    public WebElement addContactEmployee10;
    @FindBy(xpath = "//span[.='Employee100']")
    public WebElement addContactEmployee100;
    @FindBy(xpath = "//div[@class='selected-participants']")
    public WebElement selectedParticipants;
    @FindBy(xpath = "//button[@class='navigation__button navigation__button-right primary']")
    public WebElement createConversationButton;
    @FindBy(xpath = "//a[@aria-label='Conversation, friends']")
    public WebElement newChatName;
    @FindBy(xpath = "//a[@id='participants']")
    public WebElement participantsTab;
    @FindBy(xpath = "//span[.='admin']")
    public WebElement contactAdmin;
    @FindBy(xpath = "//span[.='Employee10']")
    public WebElement contactEmployee10;
    @FindBy(xpath = "//span[.='Employee100']")
    public WebElement contactEmployee100;
    @FindBy(xpath = "//button[@aria-label='Participant settings']")
    public WebElement threeDotsParticipant;
    @FindBy(xpath = "//span[.='Remove participant']")
    public WebElement removeParticipant;
    @FindBy(xpath = "//section[@id='tab-participants']")
    public WebElement participantTable;
    @FindBy(xpath = "//button[@aria-label='Conversation settings']")
    public WebElement conversationThreeDots;
    @FindBy(xpath = "//span[.='Delete conversation']")
    public WebElement deleteConversationButton;
    @FindBy(xpath = "//button[.='Yes']")
    public WebElement yesButton;
    @FindBy(xpath = "//ul[@class='app-navigation__list']")
    public WebElement conversationList;

    public TalkPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
