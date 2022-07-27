package com.meetsky.pages;

import com.github.javafaker.Faker;
import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadEditDeleteFilePage {


    public String uploadedFileNameInTheDashboard = "selenium.png";
    public String uploadedFilePathName = "/Users/kaya/Desktop/" + uploadedFileNameInTheDashboard;
    @FindBy(xpath = " //span[@class='icon icon-add']")
    public WebElement plusIcon;
    @FindBy(xpath = " //label[@for='file_upload_start']")
    public WebElement uploadFile;
    @FindBy(xpath = "//a[@data-templatename='New folder']")
    public WebElement createNewFolderIcon;
    @FindBy(id = "view13-input-folder")
    public WebElement newFolderNameInput;
    @FindBy(xpath = "//a[@data-templatename='New text document.md']")
    public WebElement createNewTextDocumentIcon;
    @FindBy(id = "view13-input-file")
    public WebElement newTextDocumentNameInput;
    @FindBy(id = "fileList")
    public WebElement listOfAllFiles;
    @FindBy(xpath = "//button[@class = 'action-item action-item--single header-close icon-close undefined undefined has-tooltip']")
    public WebElement theCloseButtonAfterCreatingTextDocument;
    @FindBy(xpath = "//a[@class='app-sidebar__close icon-close']")
    public WebElement closeActivityButtonAfterCreatingTextDocument;
    @FindBy(xpath = "//div[@class='toastify on dialogs error toastify-right toastify-top']")
    public WebElement popUpAfterCreatingAFolderWithSameName;
    @FindBy(xpath = "//div[@class='tooltip-inner']")
    public WebElement popUpAfterCreatingATextDocumentWithSameName;
    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAllCheckboxInTheDashboard;
    @FindBy(xpath = "//label[@for='select_all_trash']")
    public WebElement selectAllCheckboxInTheDeletedFilesPage;
    @FindBy(id = "selectedActionsList")
    public WebElement actionsDropdownMenu;
    @FindBy(className = "item-delete")
    public WebElement deleteButtonInTheActionsDropdown;
    @FindBy(className = "item-copyMove")
    public WebElement moveOrCopyOptionFromTheActionsDropdownMenu;
    @FindBy(id = "uploadprogressbar")
    public WebElement progressBarInTheDashboardPage;
    @FindBy(xpath = "//h2[text()='Choose target folder']")
    public WebElement popUpAfterMoveCopyDocument;
    @FindBy(xpath = "//div[@class='modal-header']")
    public WebElement visibleHeaderInTheNewTextDocument;
    @FindBy(xpath = "//a[text()='Deleted files']")
    public WebElement deletedFilesMenu;
    @FindBy(xpath = "(//span[@id='selectedActionsList'])[2]")
    public WebElement actionsDropdownMenuInTheDeletedFilesPage;
    @FindBy(xpath = "(//li[@class='item-delete'])[2]")
    public WebElement deletePermanentlyButtonInActionsDropdownInDeletedFilesPage;
    @FindBy(xpath = "//span[@class='dirinfo']")
    public WebElement textShowsTotalNumberOfFoldersAndTextDocuments;
    Faker faker = new Faker();
    public String randomFolderName = faker.funnyName().name();
    public String randomTextDocumentName = faker.funnyName().name();
    public String anotherRandomFolderName = faker.bothify("##??");
    public String anotherRandomTextDocumentName = faker.bothify("##??");
    public String otherAnotherRandomFolderName = faker.numerify("###");
    public UploadEditDeleteFilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    // public WebElement randomFolderNameInDeletedFilesPage = Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + randomFolderName + "']"));
    // public WebElement anotherRandomFolderNameInDeletedFilesPage = Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + anotherRandomFolderName + "']"));
    //public WebElement randomTextDocumentNameInDeletedFilesPage = Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + randomTextDocumentName + ".md']"));
    //public WebElement anotherRandomTextDocumentNameInDeletedFilesPage = Driver.getDriver().findElement(By.xpath("//tr[@data-path='" + anotherRandomTextDocumentName + ".md']"));

    // public WebElement anotherRandomFolderNameInTheFolder = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + anotherRandomFolderName + "']"));
    //public WebElement otherAnotherRandomFolderNameInTheFolder = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + otherAnotherRandomFolderName + "']"));
    //public WebElement randomTextDocumentNameInTheFolder = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + randomTextDocumentName + ".md']"));
    //public WebElement anotherRandomTextDocumentNameInTheFolder = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomTextDocumentName + ".md']"));

    // public WebElement checkboxBelongsToAnotherRandomFolderNameInTheDashboard = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomFolderName + "']//td[input[@type='checkbox']]"));
    //public WebElement checkboxBelongsToRandomTextDocumentNameInTheDashboard = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomTextDocumentName + ".md']//td[input[@type='checkbox']]"));
    // public WebElement checkboxBelongsToAnotherRandomTextDocumentNameInTheDashboard = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.anotherRandomTextDocumentName + ".md']//td[input[@type='checkbox']]"));
    // public WebElement checkboxBelongsToRandomFolderNameInTheDashboard = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomFolderName + "']//td[input[@type='checkbox']]"));

    //public WebElement moveToOptionInTheMoveOrCopyPopup = Driver.getDriver().findElement(By.xpath("//button[text()='Move to " + randomFolderName + "']"));
    //public WebElement copyToOptionInTheMoveOrCopyPopup = Driver.getDriver().findElement(By.xpath("//button[text()='Copy to " + uploadEditDeleteFilePage.randomFolderName + "']"));
    //public WebElement randomFolderNameInTheMoveOrCopyPopup = Driver.getDriver().findElement(By.xpath("//tr[@data-entryname='" + uploadEditDeleteFilePage.randomFolderName + "']"));

    //public WebElement randomFolderNameInTheDashboard = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + uploadEditDeleteFilePage.randomFolderName + "']"));
    //public WebElement threeDotsDropdownBelongsToRandomFolderName = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + randomTextDocumentName + ".md']//a[@data-action='menu']"));


}

