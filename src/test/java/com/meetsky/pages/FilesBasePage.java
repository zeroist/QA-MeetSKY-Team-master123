package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesBasePage {

    public FilesBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"fileList\"]/tr[3]/td[2]/a/span[2]/a[2]") ////tbody/tr[3]/td[2]/a[1]/span[2]/a[2]
    public WebElement threeDotNextToFile;
    @FindBy(xpath = "//span[contains(text(),'Add to favorites')]")
    public WebElement addToFavoritesDropDown;
    @FindBy(xpath = "//tbody/tr[1]/td[1]/a[1]")
    public WebElement favorited;
    @FindBy(xpath = "//a[contains(text(),'Favorites')]")
    public WebElement favoritesButton;
    @FindBy(xpath = "//tbody/tr[1]/td[2]/a[1]/span[2]/a[2]")
    public WebElement threeDotInFavFile;

  }
