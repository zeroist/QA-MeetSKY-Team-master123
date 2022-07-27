package com.meetsky.step_definitions;

import com.meetsky.pages.FilesPage;
import com.meetsky.utilities.Driver;
import com.meetsky.utilities.MapUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.stream.Collectors;

public class FolderView_StepDefinitions {
    List<Integer> SizeListBeforeClick = new ArrayList<>();
    List<Map<String, Object>> AllFilesAndFoldersNameAndModifiedTimeBeforeClicking = new ArrayList<>();

    String toggleTypeFirstTimeOnFilesPage;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
    Actions actions = new Actions(Driver.getDriver());

    FilesPage filesPage = new FilesPage();

    @Given("User clicks Name link")
    public void user_clicks_name_link() {
        filesPage.nameText.click();
    }

    @And("User scrolls to button of page to load all items")
    public void userScrollsToButtonOfPageToLoadAllItems() {
        wait.until(ExpectedConditions.visibilityOf(filesPage.summary));
        actions.moveToElement(filesPage.summary).perform();
    }


    @Then("User sees Files and Folders in an order according to their Names")
    public void userSeesFilesAndFoldersInAnOrderAccordingToTheirNames() {
        List<String> expectedFoldersNameList = new ArrayList<>();
        List<String> expectedFilesNameList = new ArrayList<>();
        List<String> expectedList;
        List<String> ActualNamesList = new ArrayList<>();
        String sortingIndicator = filesPage.sortingTick.getAttribute("class");
        System.out.println("sortingIndicator = " + sortingIndicator);

        if (sortingIndicator.endsWith("-n")) {// -n  indicates it is ascending , else descending
            for (WebElement webElement : filesPage.foldersNameList) {
                expectedFoldersNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            Collections.sort(expectedFoldersNameList);
            for (WebElement webElement : filesPage.filesNameList) {
                expectedFilesNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            Collections.sort(expectedFilesNameList);
            expectedFoldersNameList.addAll(expectedFilesNameList);

            expectedList = expectedFoldersNameList;


        } else {
            for (WebElement webElement : filesPage.filesNameList) {
                expectedFilesNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            Collections.reverse(expectedFilesNameList.stream().sorted().collect(Collectors.toList()));

            for (WebElement webElement : filesPage.foldersNameList) {
                expectedFoldersNameList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
            }
            expectedFoldersNameList = expectedFoldersNameList.stream().sorted().collect(Collectors.toList());
            Collections.reverse(expectedFoldersNameList);
            expectedFilesNameList.addAll(expectedFoldersNameList);
            expectedList = expectedFilesNameList;
        }

        for (WebElement webElement : filesPage.filesAndFoldersNameList) {
            ActualNamesList.add(webElement.getAttribute("data-file").toLowerCase(Locale.ROOT));
        }
        System.out.println("ActualNamesList = " + ActualNamesList);
        System.out.println("expectedFullFilesAndFoldersTogether = " + expectedList);
        Assert.assertEquals(ActualNamesList, expectedList);


    }

    @Given("User clicks Size link")
    public void userClicksSizeLink() {

        wait.until(ExpectedConditions.visibilityOf(filesPage.summary));

        actions.moveToElement(filesPage.summary).perform();
        for (WebElement webElement : filesPage.sizeList) {
            SizeListBeforeClick.add(Integer.valueOf(webElement.getText().replaceAll("[^0-9]", "")));
        }
        System.out.println("SizeListBeforeClick = " + SizeListBeforeClick);
        filesPage.sizeText.click();
    }

    @Then("User sees Files and Folders in an order according to their Size")
    public void userSeesFilesAndFoldersInAnOrderAccordingToTheirSize() {
        wait.until(ExpectedConditions.visibilityOf(filesPage.summary));

        actions.moveToElement(filesPage.summary).perform();

        String sortingIndicator = filesPage.sortingTick.getAttribute("class");
        System.out.println("sortingIndicator = " + sortingIndicator);

        List<Integer> sizeListAfterClick = new ArrayList<>();
        for (WebElement webElement : filesPage.sizeList) {
            sizeListAfterClick.add(Integer.valueOf(webElement.getText().replaceAll("[^0-9]", "")));
        }

        if (sortingIndicator.endsWith("-n")) {
            Collections.sort(SizeListBeforeClick);

            System.out.println("SizeListBeforeClick = " + SizeListBeforeClick);
            System.out.println("sizeListAfterClick = " + sizeListAfterClick);
            Assert.assertEquals(sizeListAfterClick, SizeListBeforeClick);

        } else {
            SizeListBeforeClick = SizeListBeforeClick.stream().sorted().collect(Collectors.toList());
            Collections.reverse(SizeListBeforeClick);

            System.out.println("SizeListBeforeClick = " + SizeListBeforeClick);
            System.out.println("sizeListAfterClick = " + sizeListAfterClick);

            Assert.assertEquals(sizeListAfterClick, SizeListBeforeClick);
        }


    }

    @Given("User toggles list view")
    public void userTogglesListView() {
        if (filesPage.toggleButton.getAttribute("class").equals("button icon-toggle-filelist")) {
            filesPage.toggleButton.click();
        }
    }

    @When("User clicks Modified link")
    public void userClicksModifiedLink() {

        filesPage.modifiedText.click();


    }


    @Then("User sees Files and Folders in an order according to Modified day")
    public void userSeesFilesAndFoldersInAnOrderAccordingToModifiedDay() {
        //before clicking modified, I have to put the files in to a Map so that I can compare before and after

        AllFilesAndFoldersNameAndModifiedTimeBeforeClicking = new ArrayList<>();
        for (WebElement webElement : filesPage.AllFilesFolderList) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("Name", webElement.getAttribute("data-file"));
            row.put("Modified", Long.valueOf(webElement.getAttribute("data-mtime")));
            AllFilesAndFoldersNameAndModifiedTimeBeforeClicking.add(row);
        }

        System.out.println("AllFilesAndFoldersNameAndModifiedTimeBeforeClicking = " + AllFilesAndFoldersNameAndModifiedTimeBeforeClicking);
        //////////////////////////////////////////////////////////////////////


        String sortingTypeAttribute = filesPage.sortingType.getAttribute("class");
        System.out.println("sortingTypeAttribute " + sortingTypeAttribute.charAt(sortingTypeAttribute.length() - 1));

        if (sortingTypeAttribute.endsWith("n")) {
            List<Map<String, Object>> AllFilesAndFoldersNameAndModifiedTimeAfterClicking = new ArrayList<>();
            for (WebElement webElement : filesPage.AllFilesFolderList) {
                Map<String, Object> row = new LinkedHashMap<>();
                row.put("Name", webElement.getAttribute("data-file"));
                row.put("Modified", Long.valueOf(webElement.getAttribute("data-mtime")));
                AllFilesAndFoldersNameAndModifiedTimeAfterClicking.add(row);
            }

            List<Map<String, Object>> exptectedNSorted = MapUtils.sortByValue(AllFilesAndFoldersNameAndModifiedTimeBeforeClicking, "Name", "Modified");
            Assert.assertEquals(exptectedNSorted, AllFilesAndFoldersNameAndModifiedTimeAfterClicking);


        } else {
            List<Map<String, Object>> AllFilesAndFoldersNameAndModifiedTimeAfterClicking = new ArrayList<>();
            for (WebElement webElement : filesPage.AllFilesFolderList) {
                Map<String, Object> row = new LinkedHashMap<>();
                row.put("Name", webElement.getAttribute("data-file"));
                row.put("Modified", Long.valueOf(webElement.getAttribute("data-mtime")));
                AllFilesAndFoldersNameAndModifiedTimeAfterClicking.add(row);
            }
            List<Map<String, Object>> exptectedNSorted = MapUtils.sortByValue(AllFilesAndFoldersNameAndModifiedTimeBeforeClicking, "Name", "Modified");
            System.out.println("exptectedNSortedBeforeReversion = " + exptectedNSorted);
            Collections.reverse(exptectedNSorted);
            System.out.println("exptectedNSortedAfterReversion  = " + exptectedNSorted);
            Assert.assertEquals(exptectedNSorted, AllFilesAndFoldersNameAndModifiedTimeAfterClicking);


        }

    }

    @Given("User click the toggle button")
    public void userClickTheToggleButton() {
        toggleTypeFirstTimeOnFilesPage = filesPage.toggleButton.getAttribute("class");
        filesPage.toggleButton.click();

    }

    @Then("User sees the files and folders' view changed")
    public void userSeesTheFilesAndFoldersViewChanged() {
        if (toggleTypeFirstTimeOnFilesPage.equals("button icon-toggle-filelist")) {
            Assert.assertTrue(filesPage.toggleButton.getAttribute("class").equals("button icon-toggle-pictures"));
        }
        if (toggleTypeFirstTimeOnFilesPage.equals("button icon-toggle-pictures")) {

            Assert.assertTrue(filesPage.toggleButton.getAttribute("class").equals("button icon-toggle-filelist"));

        }
    }

    @Given("User clicks the select All Checkbox at the left top corner of the list")
    public void userClicksTheSelectAllCheckboxAtTheLeftTopCornerOfTheList() {
        filesPage.selectAllCheckbox.click();
    }

    @Then("User sees all files and folders are selected")
    public void userSeesAllFilesAndFoldersAreSelected() {
        List<String> listOfSelectedFolders = new ArrayList<>();
        List<String> listOfSelectedFiles = new ArrayList<>();

        for (WebElement webElement : filesPage.AllFilesFolderList) {
            if (webElement.getAttribute("data-type").equals("dir")
                    && webElement.getAttribute("class").equals("ui-droppable selected")) {
                listOfSelectedFolders.add(webElement.getAttribute("data-file"));
            }

            if (webElement.getAttribute("data-type").equals("file")
                    && webElement.getAttribute("class").equals("selected")) {
                listOfSelectedFiles.add(webElement.getAttribute("data-file"));
            }
        }
        String ActualNumbersOfSelectedFilesAndFolders = filesPage.textShowingNumbersOfSelectedFilesAndFolders.getText();

        int sizeOfSelectedFolders = listOfSelectedFolders.size();
        int sizeOfSelectedFiles = listOfSelectedFiles.size();


        String exptectedNumbersOfSelectedFilesAndFolders = sizeOfSelectedFolders == 1 && sizeOfSelectedFiles == 1 ?
                sizeOfSelectedFolders + " folder and " + sizeOfSelectedFiles + " file" : sizeOfSelectedFolders == 1 ?
                sizeOfSelectedFolders + " folder and " + sizeOfSelectedFiles + " files" : sizeOfSelectedFiles == 1 ?
                sizeOfSelectedFolders + " folders and " + sizeOfSelectedFiles + " file" : sizeOfSelectedFolders + " folders and " + sizeOfSelectedFiles + " files";
        System.out.println("exptectedNumbersOfSelectedFilesAndFolders = " + exptectedNumbersOfSelectedFilesAndFolders);
        System.out.println("ActualNumbersOfSelectedFilesAndFolders = " + ActualNumbersOfSelectedFilesAndFolders);

        Assert.assertEquals(exptectedNumbersOfSelectedFilesAndFolders, ActualNumbersOfSelectedFilesAndFolders);

    }
}
