package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineStatusFunctionalityPage {

    //div[@class='avatardiv avatardiv-shown']
    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']")
    public WebElement EProfil;
    @FindBy(xpath = "//a[@class='user-status-menu-item__toggle']")
    //a[@class='user-status-menu-item__toggle']
    public WebElement StatusButton;
    @FindBy(xpath = "//label[@for='user-status-online-status-online']")
    //label[@for='user-status-online-status-online']
    public WebElement OnlineButton;
    @FindBy(xpath = "//label[@for='user-status-online-status-away']")
    public WebElement AwayButton;
    //label[@for='user-status-online-status-online']
    @FindBy(xpath = "//button[@class='status-buttons__select']")
    public WebElement ClearStatusMessageButton;
    //label[@for=['user-status-online-status-away']
    @FindBy(xpath = "//button[@class='status-buttons__select']")
    public WebElement SetStatusMessageButton;
    //button[@class='status-buttons__select']
    @FindBy(xpath = "//div[@class='modal-title']")
    public WebElement SetStatusPage;
    //button[@class='status-buttons__primary primary']
    @FindBy(xpath = "(//span[@class='predefined-status__message'])[4]")
    public WebElement SickEmoji;
    //div[@class='modal-title']
    @FindBy(xpath = "//span[@class='multiselect__single']")
    public WebElement ClearAtSelect;
    //span[@class='predefined-status__message'])[4]
    @FindBy(xpath = "//div[@title='30 minutes']")
    public WebElement minutes30;
    //span[@class='clear-at-select__label']

    public OnlineStatusFunctionalityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //div[@title='30 minutes']

    //input[@placeholder='Select option']

    //input[@class='multiselect__input']

    //span[@class='multiselect__single']
}
