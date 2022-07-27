package com.meetsky.step_definitions;

import com.meetsky.pages.ContactsPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Contacts_StepDefinition {

    private static final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    private ContactsPage contactsPage = new ContactsPage();
    private int totalContacts;
    private WebElement contactWillBeDeleted;
    private String newContactName;

    @Then("User goes to Contacts page")
    public void user_goes_to_page() {
        contactsPage.contactsPageLink.click();
        BrowserUtils.waitFor(5);
    }

    @Given("User clicks to new contact button")
    public void userClicksToNewContactButton() {
        contactsPage.newContactButton.click();
    }


    @And("User fills {string} {string} {string} {string} {string} {string} {string} properties out")
    public void userFillsPropertiesOut(String fullname, String company, String title, String phone, String email, String city, String country) {

        selectUnselectedInputs();
        newContactName = fullname;
        wait.until(ExpectedConditions.visibilityOf(contactsPage.birthdayDateInput));
        contactsPage.newContactFullnameInput.clear();
        contactsPage.newContactFullnameInput.sendKeys(fullname);
        contactsPage.companyInput.sendKeys(company);
        contactsPage.titleInput.sendKeys(title);
        contactsPage.phoneInput.sendKeys(phone);
        contactsPage.emailInput.sendKeys(email);
        contactsPage.cityInput.sendKeys(city);
        contactsPage.countryInput.sendKeys(country);
        BrowserUtils.waitFor(2);
    }

    private void selectUnselectedInputs() {

        // find unselected inputs for info of new contact and get them into a list of String
        List<String> willClicked = new ArrayList<>(List.copyOf(contactsPage.propertiesToBeSelected
                .stream()
                .filter(element ->
                        !BrowserUtils
                                .getElementsText(contactsPage.presentInputs)
                                .contains(element.getAttribute("title"))
                )
                .map(element -> element.getAttribute("title"))
                .collect(Collectors.toList())));

        // click to every unselected element.
        // We use nested loop and an independent string list to manipulate it during loop to be able to avoid jump one element without clicking.
        // Once we click an element from the list it is getting removed from the list. So, the list is dynamic.
        for (String s : willClicked) {
            for (WebElement element : contactsPage.propertiesToBeSelected) {
                if (element.getAttribute("title").equals(s)) {
                    wait.until(ExpectedConditions.elementToBeClickable(contactsPage.propertiesMenuLink));
                    contactsPage.propertiesMenuLink.click();
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    element.click();
                    break;
                }
            }
        }

    }

    @Given("User clicks to All contacts link")
    public void userClicksToLink() {
        totalContacts = contactsPage.contactsInTheMiddleColumn.size();
        contactsPage.allContactsLink.click();
        BrowserUtils.waitFor(3);
    }

    @Then("User should be able to see all contacts in the middle column")
    public void userShouldBeAbleToSeeAllContactsInTheMiddleColumn() {
        int middleColumnCount = contactsPage.contactsInTheMiddleColumn.size();
        int allContactsNumber = Integer.parseInt(contactsPage.numberOfContacts.getText());
        assertThat(middleColumnCount, is(equalTo(allContactsNumber)));
    }

    @Then("User should be able to see the correct number near the \"All Contacts\" tab")
    public void userShouldBeAbleToSeeTheCorrectNumberNearTheAllContactsTab() {
        int middleColumnCount = contactsPage.contactsInTheMiddleColumn.size();
        int allContactsNumber = Integer.parseInt(contactsPage.numberOfContacts.getText());
        assertThat(allContactsNumber, is(equalTo(middleColumnCount)));
    }

    @And("User clicks to a random contact in the middle column")
    public void userClicksToARandomContactInTheMiddleColumn() {
        totalContacts = contactsPage.contactsInTheMiddleColumn.size();
        contactWillBeDeleted = contactsPage.contactsInTheMiddleColumn
                .get(new Random().nextInt(contactsPage.contactsInTheMiddleColumn.size()));
        totalContacts = contactsPage.contactsInTheMiddleColumn.size();
        contactWillBeDeleted.click();
    }

    @And("User clicks to Change Picture button")
    public void userClicksToChangePictureButton() {
        contactsPage.changePictureButton.click();
    }

    @And("User clicks to Choose From File button")
    public void userClicksToChooseFromFileButton() {
        contactsPage.chooseFromFilesButton.click();
    }

    @And("User selects a jpeg file by clicking")
    public void userSelectsAJpegFileByClicking() {
        contactsPage.pictureWillBeSelected.click();
    }

    @And("User clicks to Choose button")
    public void userClicksToChooseButton() {
        contactsPage.chooseButton.click();
    }

    @Then("User should be able to see the PP has been changed")
    public void userShouldBeAbleToSeeThePPHasBeenChanged() {
        Assert.assertTrue(contactsPage.profilePicture.isEnabled());
        contactsPage.profilePicture.click();
    }

    @And("User clicks to Three dot menu link")
    public void userClicksToThreeDotMenuLink() {
        contactsPage.threeDotsMenuButton.click();
    }

    @And("User clicks to Delete button")
    public void userClicksToDeleteButton() {
        contactsPage.deleteContactButton.click();
    }

    @Then("User should be able to see the contact has been deleted")
    public void userShouldBeAbleToSeeTheContactHasBeenDeleted() {
        BrowserUtils.waitFor(3);
        Assert.assertEquals(totalContacts - 1,
                Driver.getDriver().findElements(By.xpath("//div[@class='vue-recycle-scroller__item-view']"))
                        .size() - 1);
    }

    @Then("User should be able to see new created contact")
    public void userShouldBeAbleToSeeNewCreatedContact() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(BrowserUtils
                .getElementsText(contactsPage.contactsInTheMiddleColumnForText)
                .contains(newContactName));
    }

    @And("User fills these properties out")
    public void userFillsThesePropertiesOut(DataTable table) {
        Map<String, String> inputMap = table.asMap();

        newContactName = inputMap.get("Fullname");
        wait.until(ExpectedConditions.visibilityOf(contactsPage.birthdayDateInput));
        contactsPage.newContactFullnameInput.clear();
        contactsPage.newContactFullnameInput.sendKeys(inputMap.get("Fullname"));
        contactsPage.companyInput.sendKeys(inputMap.get("Company"));
        contactsPage.titleInput.sendKeys(inputMap.get("Title"));
        contactsPage.phoneInput.sendKeys(inputMap.get("Phone"));
        contactsPage.emailInput.sendKeys(inputMap.get("Email"));
        contactsPage.cityInput.sendKeys(inputMap.get("City"));
        contactsPage.countryInput.sendKeys(inputMap.get("Country"));
        BrowserUtils.waitFor(2);
    }

    @Then("User should see warning message")
    public void userShouldSeeWarningMessage() {
        try {
            Driver.getDriver().switchTo().alert().getText();
        } catch (NoAlertPresentException e) {
            Assert.fail("NoAlertPresentException is thrown. There is no alert message to warn");
        }

        // assertThrows() sample using
        //Assert.assertThrows(NoAlertPresentException.class, () -> Driver.getDriver().switchTo().alert().getText());

    }

    @Then("User shouldn't be able to see new created contact")
    public void userShouldnTBeAbleToSeeNewCreatedContact() {
        Assert.assertFalse(BrowserUtils
                .getElementsText(contactsPage.contactsInTheMiddleColumnForText)
                .contains(newContactName));
    }

    /**
     * This method selects the option according to given Map.
     *
     * @param optionMap: Key: name of inputs, value: The option that will be selected
     */
    @And("User selects these options")
    public void userSelectsTheseOptions(Map<String, String> optionMap) {

        // opening the closed input elements
        selectUnselectedInputs();

        optionMap.forEach((key, value) -> {
            // click to menu link according to "key"
            BrowserUtils.clickWithJS(Driver.getDriver().findElement(By.xpath("(//div[contains(text(),'" + key + "')]/../..//input)[1]"))); //menu link

            // get the selectable options for related input and according to "key"
            List<WebElement> options = Driver.getDriver().findElements(By.xpath("//div[contains(text(),'" + key + "')]/../..//div[@class='name-parts']")); //options

            // find the option which equals to "value" and select it by clicking.
            options.stream()
                    .filter(element ->
                            element.getAttribute("title").equalsIgnoreCase(value))
                    .forEach(BrowserUtils::clickWithJS);
        });
        BrowserUtils.waitFor(2);
    }
}