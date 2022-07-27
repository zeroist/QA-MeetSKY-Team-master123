package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesFavoritesRenameCommentPage {

    @FindBy(xpath = "//span[contains(text(),'Details')]")
    public WebElement detailsButton;
    @FindBy(xpath = "//a[@id='commentsTabView']")
    public WebElement commentTabView;
    @FindBy(xpath = "//body/div[@id='content']/aside[@id='app-sidebar-vue']/div[1]/div[1]/section[3]/div[1]/div[1]/form[1]/div[1]")
    public WebElement writeComment;
    @FindBy(xpath = "//body/div[@id='content']/aside[@id='app-sidebar-vue']/div[1]/div[1]/section[3]/div[1]/div[1]/form[1]/input[1]")
    public WebElement postCommentArrow;
    @FindBy(xpath = "//div[contains(text(),'New comment Added')]")
    public WebElement commentPosted;
    @FindBy(xpath = "//tbody/tr[1]/td[1]/a[1]/span[2]/a[2]")
    public WebElement threeDotNextToName;
    @FindBy(xpath = "//span[contains(text(),'Delete comment')]")
    public WebElement deleteComment;
    @FindBy(xpath = "//span[contains(text(),'Rename')]")
    public WebElement reName;
    @FindBy(xpath = "//tbody/tr[1]/td[1]/a[1]/span[1]/span[1]")
    public WebElement fileName;
    @FindBy(xpath = "//tbody/tr[1]/td[1]/a[1]/span[2]/a[2]")
    public WebElement threeDotToToMoveComment;
    @FindBy(xpath = "//body/div[@id='content']/aside[@id='app-sidebar-vue']/div[1]/div[1]/section[3]/div[1]/ul[1]/li[1]/div[1]/a[1]")
    public WebElement ThreeDotNextToNameOnCommentSection;
    @FindBy(xpath = "//span[contains(text(),'Remove from favorites')]")
    public WebElement removeFromFavorites;

    public FilesFavoritesRenameCommentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
