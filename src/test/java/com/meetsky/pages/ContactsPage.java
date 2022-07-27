package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage extends BasePage {

    @FindBy(id = "new-contact-button")
    public WebElement newContactButton;

    @FindBy(id = "contact-fullname")
    public WebElement newContactFullnameInput;

    @FindBy(id = "contact-org")
    public WebElement companyInput;

    @FindBy(id = "contact-title")
    public WebElement titleInput;

    @FindBy(xpath = "//section[1]//h3//div[2]")
    public List<WebElement> presentInputs;

    @FindBy(xpath = "//input[@placeholder='Choose property type']")
    public WebElement propertiesMenuLink;

    //use title attribute to get the value
    @FindBy(xpath = "//span[contains(text(),'Choose property type')]/../..//li//div")
    public List<WebElement> propertiesToBeSelected;

    @FindBy(xpath = "//div[contains(text(),'Post office box')]/following-sibling::input")
    public WebElement postOfficeBoxInput;

    @FindBy(xpath = "//div[contains(text(),'Address')]/following-sibling::input")
    public WebElement addressInput;

    @FindBy(xpath = "//div[contains(text(),'Extended address')]/following-sibling::input")
    public WebElement extendedAddressInput;

    @FindBy(xpath = "//div[contains(text(),'Postal code')]/following-sibling::input")
    public WebElement postalCodeInput;

    @FindBy(xpath = "//div[contains(text(),'City')]/following-sibling::input")
    public WebElement cityInput;

    @FindBy(xpath = "//div[contains(text(),'State or province')]/following-sibling::input")
    public WebElement stateOrProvinceInput;

    @FindBy(xpath = "//div[contains(text(),'Country')]/following-sibling::input")
    public WebElement countryInput;

    @FindBy(xpath = "//div[contains(text(),'Nickname')]/../following-sibling::div//input")
    public WebElement nicknameInput;

    @FindBy(xpath = "//div[contains(text(),'Timezone')]/../following-sibling::div//input")
    public WebElement timezoneMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Timezone')]/../following-sibling::div//li//div")
    public List<WebElement> timezoneOptions; // use getAttribute("title")

    @FindBy(xpath = "//div[contains(text(),'Spoken languages')]/../following-sibling::div//input")
    public WebElement spokenLanguagesMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Spoken languages')]/../following-sibling::div//li//div")
    public List<WebElement> spokenLanguagesOptions; // use getAttribute("title")

    @FindBy(xpath = "(//div[contains(text(),'Phone')]/../..//input)[1]")
    public WebElement phoneTypeMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Phone')]/../..//div[@class='name-parts']")
    public List<WebElement> phoneTypeOptions; // use getAttribute("title")

    @FindBy(xpath = "(//div[contains(text(),'Phone')]/../following-sibling::div//input)[2]")
    public WebElement phoneInput;

    @FindBy(xpath = "(//div[contains(text(),'Email')]/../following-sibling::div//input)[2]")
    public WebElement emailInput;

    @FindBy(xpath = "(//div[contains(text(),'Email')]/../..//input)[1]")
    public WebElement emailTypeMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Email')]/../..//div[@class='name-parts']")
    public List<WebElement> emailTypeOptions; // use getAttribute("title")

    @FindBy(xpath = "//div[contains(text(),'Location')]/../following-sibling::div//input")
    public WebElement locationInput;

    @FindBy(xpath = "(//div[contains(text(),'Instant messaging')]/../following-sibling::div//input)[2]")
    public WebElement instantMessagingInput;

    @FindBy(xpath = "(//div[contains(text(),'Instant')]/../..//input)[1]")
    public WebElement instantMessagingTypeMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Instant')]/../..//div[@class='name-parts']")
    public List<WebElement> instantMessaggingTypeOptions; // use getAttribute("title")

    @FindBy(xpath = "(//div[contains(text(),'Federated Cloud ID')]/../following-sibling::div//input)[2]")
    public WebElement federatedCloudIDInput;

    @FindBy(xpath = "(//div[contains(text(),'Federated')]/../..//input)[1]")
    public WebElement federatedCloudIDTypeMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Federated')]/../..//div[@class='name-parts']")
    public List<WebElement> federatedCloudIDTypeOptions;

    @FindBy(xpath = "//div[contains(text(),'Anniversary')]/../following-sibling::div//input")
    public WebElement anniversaryDateInput; // "Mmm d, yyyy" format (Mmm in letters)

    @FindBy(xpath = "//div[contains(text(),'Birthday')]/../following-sibling::div//input")
    public WebElement birthdayDateInput; // "Mmm d, yyyy" format (Mmm in letters)

    @FindBy(xpath = "//div[contains(text(),'Date of death')]/../following-sibling::div//input")
    public WebElement dateOfDeathInput;  // "Mmm d, yyyy" format (Mmm in letters)

    @FindBy(xpath = "//div[contains(text(),'Website')]/../following-sibling::div//input")
    public WebElement websiteInput;

    @FindBy(xpath = "(//div[contains(text(),'Related contacts')]/../following-sibling::div//input)[2]")
    public WebElement relatedContactsInput;

    @FindBy(xpath = "(//div[contains(text(),'Related')]/../..//input)[1]")
    public WebElement relatedContactsTypeMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Related')]/../..//div[@class='name-parts']")
    public List<WebElement> relatedContactsTypeOptions; // use getAttribute("title")

    @FindBy(xpath = "//div[contains(text(),'Relationship to you')]/../following-sibling::div//input")
    public WebElement relationshipToYouMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Relationship to you')]/../following-sibling::div//li//div")
    public List<WebElement> relationshipToYouOptions; // use getAttribute("title")

    @FindBy(xpath = "//div[contains(text(),'Gender')]/..//input")
    public WebElement genderMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Gender')]/..//li//div")
    public List<WebElement> genderOptions; // use getAttribute("title")

    @FindBy(id = "textarea")
    public WebElement notesTextArea;

    @FindBy(xpath = "//div[contains(text(),'Groups')]/..//input")
    public WebElement groupsMenuLink;

    @FindBy(xpath = "//div[contains(text(),'Groups')]/../..//div[@class='name-parts']")
    public List<WebElement> groupsOptions; // use getAttribute("title")

    @FindBy(xpath = "//div[contains(text(),'Groups')]/..//span[@class='multiselect__tag']/span")
    public List<WebElement> selectedGroups; // use getText()

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    public List<WebElement> deleteButtonsForInputs;

    @FindBy(xpath = "(//div[contains(text(),'Social network')]/../following-sibling::div//input)[2]")
    public WebElement socialNetworkInput;

    @FindBy(xpath = "(//div[contains(text(),'Social network')]/../..//input)[1]")
    public WebElement socialNetWorksLink;

    @FindBy(xpath = "//div[contains(text(),'Social network')]/../..//li[@class='multiselect__element']//div")
    public List<WebElement> socialNetworkTypeOptions; // use getAttribute("title")

    @FindBy(xpath = "//span[contains(text(),'All contacts')]/..")
    public WebElement allContactsLink;

    @FindBy(xpath = "//li[@id='everyone']//div[@class='app-navigation-entry__counter']")
    public WebElement numberOfContacts; // use getText() method

    @FindBy(xpath = "//div[@class='vue-recycle-scroller__item-view']")
    public List<WebElement> contactsInTheMiddleColumn;

    @FindBy(xpath = "//div[@class='vue-recycle-scroller__item-view']/div/div[2]")
    public List<WebElement> contactsInTheMiddleColumnForText;

    @FindBy(xpath = "//button[@class='icon action-item__menutoggle icon-picture-force-white']")
    public WebElement changePictureButton;

    @FindBy(xpath = "//span[contains(text(),'Choose from files')]/..")
    public WebElement chooseFromFilesButton;

    @FindBy(xpath = "//span[contains(text(),'jpeg')]/../..")
    public WebElement pictureWillBeSelected;

    @FindBy(xpath = "//button[contains(text(),'Choose')]")
    public WebElement chooseButton;

    @FindBy(xpath = "//div[@class='contact-header-avatar__photo']")
    public WebElement profilePicture;

    @FindBy(xpath = "//body/div[5]/div[2]/div[1]/img[1]")
    public WebElement expandedProfilePicture;

    @FindBy(xpath = "//div[@class='action-item header-menu']//button")
    public WebElement threeDotsMenuButton;

    @FindBy(xpath = "//div[@class='popover vue-popover-theme open']//li[3]")
    public WebElement deleteContactButton;


    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}