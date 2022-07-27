package com.meetsky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Serpil_ProfileSettingsPage extends BasePage {


    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']")
    public WebElement accountMenu;

    @FindBy(xpath = "//input[@id='displayname']")
    public WebElement profileSettingsNameBox;

  /*
  @FindBy(xpath = "(//span[@class='icon-triangle-s'] )[2]")
  public WebElement nameOptionsButton;

  @FindBy(xpath = "//strong[.='Private']")
  public WebElement namePrivateOption;

    @FindBy(xpath = "//strong[.='Trusted']")
    public WebElement nameTrustedOption;

      @FindBy(xpath = "//strong[.='Public']")
    public WebElement namePublicOption;

   */


    @FindBy(xpath = "//h2[.='Authentication required ']")
    public WebElement nameAuthenticationNoticeMessage;

    @FindBy(xpath = "//input[@id='oc-dialog-2-content-input']")
    public WebElement nameAuthenticationInputBox;

    @FindBy(xpath = "//button[.='Confirm']")
    public WebElement nameAuthenticationConfirmButton;


    @FindBy(xpath = "//input[@id='phone']")
    public WebElement profileSettingsPhoneBox;

    @FindBy(xpath = "(//span[@class='icon-triangle-s'] )[4]")
    public WebElement phoneOptionsButton;


    @FindBy(xpath = "//input[@id='phonescope']")
    public WebElement phoneOptionsButton2;

    @FindBy(xpath = "//label[.='Full name']")
    public WebElement fullNameTitle;


    @FindBy(xpath = "//label[.='Email']")
    public WebElement emailTitle;


    @FindBy(xpath = "//label[.='Phone number']")
    public WebElement phoneNumberTitle;

    @FindBy(xpath = "//strong[.='Private']")
    public WebElement phonePrivateOption;

    @FindBy(xpath = "//input[@id='oc-dialog-0-content-input']")
    public WebElement phoneAuthenticationInputBox;

    @FindBy(xpath = "//button[.='Confirm']")
    public WebElement phoneAuthenticationConfirmButton;

    @FindBy(xpath = "//h2[.='Authentication required ']")
    public WebElement phoneAuthenticationNoticeMessage;


    @FindBy(xpath = "//span[@id='localeexample-time']")
    public WebElement localTime;


    /*
     @FindBy(xpath = "//input[@id='email']")
    public WebElement profileSettingsEmailBox;

    @FindBy(xpath = "(//span[@class='icon-triangle-s'] )[3]")
    public WebElement emailOptionsButton;


    @FindBy(xpath = "//input[@id='address']")
    public WebElement profileSettingsAddressBox;

    @FindBy(xpath = "(//span[@class='icon-triangle-s'] )[5]")
    public WebElement addressOptionsButton;


    @FindBy(xpath = "//select[@id='languageinput']")
    public WebElement profileSettingsLanguageBox;

    @FindBy(xpath = "//select[@id='localeinput']")
    public WebElement profileSettingsLocaleBox;

    @FindBy(xpath = "//input[@id='website']")
    public WebElement profileSettingsWebsiteBox;

    @FindBy(xpath = "(//span[@class='icon-triangle-s'] )[6]")
    public WebElement websiteOptionsButton;


    @FindBy(xpath = "//input[@id='twitter']")
    public WebElement profileSettingsTwitterBox;

    @FindBy(xpath = "(//span[@class='icon-triangle-s'] )[7]")
    public WebElement twitterOptionsButton;


    @FindBy(xpath = "//label[@id='uploadavatarbutton']")
    public WebElement pictureUploadingButton;

    @FindBy(xpath = "//div[@id='selectavatar']")
    public WebElement pictureSelectingButton;




*/


}
