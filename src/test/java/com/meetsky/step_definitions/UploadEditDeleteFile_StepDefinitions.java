package com.meetsky.step_definitions;

import com.meetsky.pages.LoginPage;
import com.meetsky.pages.UploadEditDeleteFilePage;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadEditDeleteFile_StepDefinitions {

    protected LoginPage loginPageBurak = new LoginPage();
    UploadEditDeleteFilePage uploadEditDeleteFilePage = new UploadEditDeleteFilePage();

    @Given("user is on the Files module of MeetSky application, and dashboard page does not have any file.")
    public void userIsOnTheFilesModuleOfMeetSkyApplication() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Files - Meetsky - QA"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        uploadEditDeleteFilePage.selectAllCheckboxInTheDashboard.click();
        uploadEditDeleteFilePage.actionsDropdownMenu.click();
        uploadEditDeleteFilePage.deleteButtonInTheActionsDropdown.click();
        wait.until(ExpectedConditions.invisibilityOf(uploadEditDeleteFilePage.progressBarInTheDashboardPage));
    }

    @When("user clicks the plus icon top left of the page")
    public void userClicksThePlusIconTopLeftOfThePage() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.plusIcon));
        uploadEditDeleteFilePage.plusIcon.click();
    }

    @And("user clicks the upload file section from the dropdown menu")
    public void userClicksTheUploadFileSectionFromTheDropdownMenu() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.uploadFile));
        uploadEditDeleteFilePage.uploadFile.isDisplayed();
    }

    @And("user enters the source of file to upload and clicks okay button")
    public void userEntersTheSourceOfFileToUploadAndClicksEnter() throws InterruptedException {
        Thread.sleep(1000);
        uploadEditDeleteFilePage.uploadFile.sendKeys(uploadEditDeleteFilePage.uploadedFilePathName);
        Thread.sleep(1000);
    }

    @Then("user should see the source of file under the Files module")
    public void userShouldSeeTheSourceOfFileUnderTheFilesModule() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(uploadEditDeleteFilePage.uploadedFilePathName.contains(uploadEditDeleteFilePage.uploadedFileNameInTheDashboard));
        Thread.sleep(1000);
    }

    @And("user clicks the New Folder section from the dropdown menu")
    public void userClicksTheNewFolderSectionFromTheDropdownMenu() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.createNewFolderIcon));
        uploadEditDeleteFilePage.createNewFolderIcon.click();
    }

    @And("user enters a folder name and clicks enter")
    public void userEntersAFolderNameAndClicksEnter() {
        uploadEditDeleteFilePage.newFolderNameInput.sendKeys(uploadEditDeleteFilePage.randomFolderName, Keys.ENTER);
    }

    @Then("user should see the created folder under the Files module")
    public void userShouldSeeTheCreatedFolderUnderTheFilesModule() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomFolderName + "']")).isDisplayed());
        Thread.sleep(1000);
    }

    @And("user clicks the New Text Document section from the dropdown menu")
    public void userClicksTheNewTextDocumentSectionFromTheDropdownMenu() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.createNewTextDocumentIcon));
        uploadEditDeleteFilePage.createNewTextDocumentIcon.click();
    }

    @And("user enters a text document name and clicks enter")
    public void userEntersATextDocumentNameAndClicksEnter() throws InterruptedException {
        Thread.sleep(1000);
        uploadEditDeleteFilePage.newTextDocumentNameInput.sendKeys(uploadEditDeleteFilePage.randomTextDocumentName, Keys.ENTER);
        Thread.sleep(1000);
    }

    @Then("user should see the created text document in the title")
    public void userShouldSeeTheCreatedTextDocumentInTheTitle() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.titleIs(uploadEditDeleteFilePage.randomTextDocumentName + ".md - Meetsky - QA"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(uploadEditDeleteFilePage.randomTextDocumentName));
    }


    @Then("user should see the alert says it already exists")
    public void userShouldSeeTheAlertSaysItAlreadyExists() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(uploadEditDeleteFilePage.popUpAfterCreatingAFolderWithSameName));
        Assert.assertTrue(uploadEditDeleteFilePage.popUpAfterCreatingAFolderWithSameName.getText().contains("already exists"));
        Thread.sleep(1000);
    }


    @And("user clicks the close button")
    public void userClicksTheCloseButton() {
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(200));
        //wait.until(ExpectedConditions.invisibilityOf(uploadEditDeleteFilePage.visibleHeaderInTheNewTextDocument));
        //uploadEditDeleteFilePage.closeActivityButtonAfterCreatingTextDocument.click();
        uploadEditDeleteFilePage.theCloseButtonAfterCreatingTextDocument.click();
    }

    @Then("user should see the alert says the text document already exists")
    public void userShouldSeeTheAlertSaysTheTextDocumentAlreadyExists() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(uploadEditDeleteFilePage.popUpAfterCreatingATextDocumentWithSameName));
        Assert.assertTrue(uploadEditDeleteFilePage.popUpAfterCreatingATextDocumentWithSameName.getText().contains("already exists"));
    }


    @And("user enters a folder name includes slash punctuation")
    public void userEntersAFolderNameIncludesThisSpecialCharacter() {
        uploadEditDeleteFilePage.newFolderNameInput.sendKeys("/", Keys.ENTER);
    }

    @Then("user should see the alert says that slash punctuation is not allowed inside a file name")
    public void userShouldSeeTheAlertSaysThatThisCharacterIsNotAllowedInsideAFileName() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(uploadEditDeleteFilePage.popUpAfterCreatingATextDocumentWithSameName));
        Assert.assertTrue(uploadEditDeleteFilePage.popUpAfterCreatingATextDocumentWithSameName.getText().contains("is not allowed"));
    }

    @And("user enters a text document name includes slash punctuation")
    public void userEntersATextDocumentNameIncludesThisSpecialCharacter() {
        uploadEditDeleteFilePage.newTextDocumentNameInput.sendKeys("/", Keys.ENTER);
    }

    @And("user enters a folder name includes dot punctuation")
    public void userEntersAFolderNameIncludesDotPunctuation() {
        uploadEditDeleteFilePage.newFolderNameInput.sendKeys(".", Keys.ENTER);
    }

    @Then("user should see the alert says that dot punctuation is an invalid file name")
    public void userShouldSeeTheAlertSaysThatDotPunctuationIsAnInvalidFileName() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(uploadEditDeleteFilePage.popUpAfterCreatingATextDocumentWithSameName));
        Assert.assertTrue(uploadEditDeleteFilePage.popUpAfterCreatingATextDocumentWithSameName.getText().contains("is an invalid file name"));
    }

    @And("user enters a text document name includes dot punctuation")
    public void userEntersATextDocumentNameIncludesDotPunctuation() {
        uploadEditDeleteFilePage.newTextDocumentNameInput.sendKeys(".", Keys.ENTER);
    }

    @Then("user should see the alert says that dot punctuation is not allowed inside a file name")
    public void userShouldSeeTheAlertSaysThatDotPunctuationIsNotAllowedInsideAFileName() {
        Assert.assertTrue(uploadEditDeleteFilePage.popUpAfterCreatingAFolderWithSameName.getText().contains("Could not create file"));
    }

    @And("user deletes given name in the new folder input and clicks enter")
    public void userDeletesGivenNameInTheNewFolderInputAndClicksEnter() {
        uploadEditDeleteFilePage.newFolderNameInput.sendKeys(Keys.DELETE, Keys.ENTER);
    }

    @Then("user should see the alert says that file name cannot be empty")
    public void userShouldSeeTheAlertSaysThatFileNameCannotBeEmpty() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(uploadEditDeleteFilePage.popUpAfterCreatingATextDocumentWithSameName));
        Assert.assertTrue(uploadEditDeleteFilePage.popUpAfterCreatingATextDocumentWithSameName.getText().contains("name cannot be empty"));
    }

    @And("user deletes given name in the new text document input and clicks enter")
    public void userDeletesGivenNameInTheNewTextDocumentInputAndClicksEnter() {
        uploadEditDeleteFilePage.newTextDocumentNameInput.sendKeys(Keys.DELETE, Keys.ENTER);
    }


    @Then("user should see the alert says that text document name cannot be empty")
    public void userShouldSeeTheAlertSaysThatTextDocumentNameCannotBeEmpty() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(uploadEditDeleteFilePage.popUpAfterCreatingAFolderWithSameName));
        Assert.assertTrue(uploadEditDeleteFilePage.popUpAfterCreatingAFolderWithSameName.getText().contains("Could not create file"));

    }

    @And("user turns back to the dashboard")
    public void userTurnsBackToTheDashboard() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(uploadEditDeleteFilePage.selectAllCheckboxInTheDashboard));
    }

    @And("user selects the checkbox near to that text document")
    public void userSelectsTheCheckboxNearToThatTextDocument() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']"))));
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']//td[input[@type='checkbox']]")).click();
    }

    @And("user clicks the Actions dropdown menu")
    public void userClicksTheActionsDropdownMenu() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(uploadEditDeleteFilePage.actionsDropdownMenu));
        uploadEditDeleteFilePage.actionsDropdownMenu.click();
    }

    @And("user selects Move or Copy file option")
    public void userSelectsMoveOrCopyFileOption() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(uploadEditDeleteFilePage.moveOrCopyOptionFromTheActionsDropdownMenu));
        uploadEditDeleteFilePage.moveOrCopyOptionFromTheActionsDropdownMenu.click();
    }

    @And("user sees the new page")
    public void userSeesTheNewPage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.visibilityOf(uploadEditDeleteFilePage.popUpAfterMoveCopyDocument));
        Assert.assertTrue(uploadEditDeleteFilePage.popUpAfterMoveCopyDocument.isDisplayed());
    }

    @And("user refreshes the page")
    public void userRefreshesThePage() {
        Driver.getDriver().navigate().refresh();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.selectAllCheckboxInTheDashboard));

    }

    @And("user clicks the folder")
    public void userClicksTheFolder() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.xpath("//tr[@data-entryname='" + uploadEditDeleteFilePage.randomFolderName + "']"))));
        Driver.getDriver().findElement(By.xpath("//tr[@data-entryname='" + uploadEditDeleteFilePage.randomFolderName + "']")).click();
    }


    @And("user selects move option")
    public void userSelectsMoveOption() {
        Driver.getDriver().findElement(By.xpath("//button[text()='Move to " + uploadEditDeleteFilePage.randomFolderName + "']")).click();
    }


    @And("user opens the folder")
    public void userOpensTheFolder() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomFolderName + "']")).click();
    }


    @Then("user see that the text file is there")
    public void userSeeThatTheTextFileIsThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.invisibilityOf(uploadEditDeleteFilePage.progressBarInTheDashboardPage));
        try {
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']")).isDisplayed());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }


    @And("user selects copy option")
    public void userSelectsCopyOption() {
        Driver.getDriver().findElement(By.xpath("//button[text()='Copy to " + uploadEditDeleteFilePage.randomFolderName + "']")).click();
    }


    @And("user selects the checkbox near to that text documents")
    public void userSelectsTheCheckboxNearToThatTextDocuments() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']//td[input[@type='checkbox']]")).click();
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomTextDocumentName + ".md']//td[input[@type='checkbox']]")).click();
    }

    @Then("user see that text files are there")
    public void userSeeThatTextFilesAreThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.invisibilityOf(uploadEditDeleteFilePage.progressBarInTheDashboardPage));
        try {
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']")).isDisplayed());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.invisibilityOf(uploadEditDeleteFilePage.progressBarInTheDashboardPage));
        try {
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomTextDocumentName + ".md']")).isDisplayed());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    @And("user enters a different text document name and clicks enter")
    public void userEntersADifferentTextDocumentNameAndClicksEnter() {
        uploadEditDeleteFilePage.newTextDocumentNameInput.sendKeys(uploadEditDeleteFilePage.anotherRandomTextDocumentName, Keys.ENTER);

    }


    @And("user enters another folder name and clicks enter")
    public void userEntersAnotherFolderNameAndClicksEnter() {
        uploadEditDeleteFilePage.newFolderNameInput.sendKeys(uploadEditDeleteFilePage.anotherRandomFolderName, Keys.ENTER);
    }

    @And("user selects the checkbox near to the newly created folder")
    public void userSelectsTheCheckboxNearToTheNewlyCreatedFolder() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomFolderName + "']//td[input[@type='checkbox']]")).click();
    }

    @Then("user see that newly created folder is there")
    public void userSeeThatNewlyCreatedFolderIsThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.invisibilityOf(uploadEditDeleteFilePage.progressBarInTheDashboardPage));
        try {
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomFolderName + "']")).isDisplayed());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }

    }

    @And("user enters a different folder name and clicks enter")
    public void userEntersADifferentFolderNameAndClicksEnter() {
        uploadEditDeleteFilePage.newFolderNameInput.sendKeys(uploadEditDeleteFilePage.otherAnotherRandomFolderName, Keys.ENTER);
    }

    @And("user selects the checkbox near to that folders")
    public void userSelectsTheCheckboxNearToThatFolders() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomFolderName + "']//td[input[@type='checkbox']]")).click();
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.otherAnotherRandomFolderName + "']//td[input[@type='checkbox']]")).click();

    }

    @Then("user see that newly created folders are there")
    public void userSeeThatNewlyCreatedFoldersAreThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.invisibilityOf(uploadEditDeleteFilePage.progressBarInTheDashboardPage));
        try {
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomFolderName + "']")).isDisplayed());
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.otherAnotherRandomFolderName + "']")).isDisplayed());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }


    @And("user selects the checkbox near to another folder and text document")
    public void userSelectsTheCheckboxNearToAnotherFolderAndTextDocument() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomFolderName + "']//td[input[@type='checkbox']]")).click();
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']//td[input[@type='checkbox']]")).click();
    }

    @Then("user see that newly created folder and text document are there")
    public void userSeeThatNewlyCreatedFolderAndTextDocumentAreThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.invisibilityOf(uploadEditDeleteFilePage.progressBarInTheDashboardPage));
        try {
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomFolderName + "']")).isDisplayed());
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']")).isDisplayed());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    @And("user selects delete option")
    public void userSelectsDeleteOption() {
        uploadEditDeleteFilePage.deleteButtonInTheActionsDropdown.click();
    }

    @And("user goes to deleted files page")
    public void userGoesToDeletedFilesPage() {
        uploadEditDeleteFilePage.deletedFilesMenu.click();
    }

    @Then("user see the deleted folder there")
    public void userSeeTheDeletedFolderThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.selectAllCheckboxInTheDeletedFilesPage));
        try {
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + uploadEditDeleteFilePage.randomFolderName + "']")).isDisplayed());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    @And("user selects the checkbox near to the folder")
    public void userSelectsTheCheckboxNearToTheFolder() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomFolderName + "']//td[input[@type='checkbox']]")).click();
    }

    @And("user clicks the select all checkbox in the deleted files page")
    public void userClicksTheSelectAllCheckboxInTheDeletedFilesPage() {
        uploadEditDeleteFilePage.selectAllCheckboxInTheDeletedFilesPage.click();
    }

    @And("user clicks the Actions dropdown menu in the deleted files page")
    public void userClicksTheActionsDropdownMenuInTheDeletedFilesPage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.actionsDropdownMenuInTheDeletedFilesPage));
        uploadEditDeleteFilePage.actionsDropdownMenuInTheDeletedFilesPage.click();
    }

    @And("user selects delete option in the deleted files page")
    public void userSelectsDeleteOptionInTheDeletedFilesPage() {
        uploadEditDeleteFilePage.deletePermanentlyButtonInActionsDropdownInDeletedFilesPage.click();
    }

    @Then("user see the deleted text document there")
    public void userSeeTheDeletedTextDocumentThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.selectAllCheckboxInTheDeletedFilesPage));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']")).isDisplayed());

    }

    @Then("user see the deleted folders there")
    public void userSeeTheDeletedFoldersThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.selectAllCheckboxInTheDeletedFilesPage));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + uploadEditDeleteFilePage.randomFolderName + "']")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + uploadEditDeleteFilePage.anotherRandomFolderName + "']")).isDisplayed());
    }

    @And("user selects the checkbox near to that newly created folders")
    public void userSelectsTheCheckboxNearToThatNewlyCreatedFolders() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomFolderName + "']//td[input[@type='checkbox']]")).click();
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomFolderName + "']//td[input[@type='checkbox']]")).click();

    }

    @Then("user see the deleted text documents there")
    public void userSeeTheDeletedTextDocumentsThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.selectAllCheckboxInTheDeletedFilesPage));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + uploadEditDeleteFilePage.anotherRandomTextDocumentName + ".md']")).isDisplayed());
    }

    @And("user selects the checkbox near to that folder and text document")
    public void userSelectsTheCheckboxNearToThatFolderAndTextDocument() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomFolderName + "']//td[input[@type='checkbox']]")).click();
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']//td[input[@type='checkbox']]")).click();

    }

    @Then("user see the deleted folder and text document there")
    public void userSeeTheDeletedFolderAndTextDocumentThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.selectAllCheckboxInTheDeletedFilesPage));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + uploadEditDeleteFilePage.randomFolderName + "']")).isDisplayed());

    }

    @And("user selects delete option from three dots dropdown menu")
    public void userSelectsDeleteOptionFromThreeDotsDropdownMenu() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomFolderName + "']//span[text()='Delete folder']")).click();
    }

    @And("user selects the three dots dropdown menu belongs to the folder")
    public void userSelectsTheThreeDotsDropdownMenuBelongsToTheFolder() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomFolderName + "']//a[@data-action='menu']")).click();
    }

    @And("user selects the three dots dropdown menu belongs to the text document")
    public void userSelectsTheThreeDotsDropdownMenuBelongsToTheTextDocument() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']//a[@data-action='menu']")).click();
    }

    @And("user selects delete option of text document three dots dropdown menu")
    public void userSelectsDeleteOptionOfTextDocumentThreeDotsDropdownMenu() {
        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']//a[@data-action='Delete']")).click();

    }

    @Then("user see total number of folders and text documents there.")
    public void userSeeTotalNumberOfFoldersAndTextDocumentsThere() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 200);
        wait.until(ExpectedConditions.elementToBeClickable(uploadEditDeleteFilePage.textShowsTotalNumberOfFoldersAndTextDocuments));
        Assert.assertTrue(uploadEditDeleteFilePage.textShowsTotalNumberOfFoldersAndTextDocuments.isDisplayed());
    }
}

