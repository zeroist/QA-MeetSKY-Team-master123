package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {
    @FindBy(xpath = "//span[contains(@class,\"sort-indicator icon-triangle-s\")]")
    public WebElement ascendingSortingTick;
    @FindBy(xpath = "//span[contains(@class,\"sort-indicator icon-triangle-n\")]")
    public WebElement descendingSortingTick;
    @FindBy(xpath = "//span[contains(@class,\"sort-indicator icon-triangle-\")]")
    public WebElement sortingTick;
    @FindBy(xpath = "//span[contains(@class,\"sort-indicator icon-triangle-\")]")
    public WebElement sortingType;
    @FindBy(xpath = "//span[.='Name']")
    public WebElement nameText;
    @FindBy(xpath = "//a[@class=\"size sort columntitle\"]//span[.='Size']")
    public WebElement sizeText;
    @FindBy(xpath = "//th[@id=\"headerDate\"]//a//span[.='Modified']")
    public WebElement modifiedText;
    @FindBy(xpath = "//tr[@data-id and @data-type=\"file\"]")
    public List<WebElement> filesNameList;
    @FindBy(xpath = "//tr[@data-id and @data-type=\"dir\"]")
    public List<WebElement> foldersNameList;
    @FindBy(xpath = "//td[@class=\"filesummary\"]")
    public WebElement summary;
    @FindBy(xpath = "//tr[@data-id][last()]")
    public WebElement filesAndFoldersLastItemName;
    @FindBy(xpath = "//tr[@data-id]")
    public List<WebElement> filesAndFoldersNameList;
    @FindBy(xpath = "//tbody[@id=\"fileList\"]//td[@class=\"filesize\"]")
    public List<WebElement> sizeList;
    @FindBy(xpath = "//td[@class=\"date\"]/span[contains(@data-original-title,\"\")]")
    public List<WebElement> modifiedTimeList;
    @FindBy(xpath = "//table//tbody//tr[contains(@data-id,\"\")]")
    public List<WebElement> AllFilesFolderList;
    @FindBy(xpath = "//label[@id=\"view-toggle\"]")
    public WebElement toggleButton;
    @FindBy(xpath = "//label[@for=\"select_all_files\"]")
    public WebElement selectAllCheckbox;
    @FindBy(xpath = "//th[@id=\"headerName\"]//span")
    public WebElement textShowingNumbersOfSelectedFilesAndFolders;

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
