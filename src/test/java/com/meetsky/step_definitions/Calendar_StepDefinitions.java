package com.meetsky.step_definitions;

import com.meetsky.pages.CalendarPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Calendar_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    CalendarPage calendarPage = new CalendarPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);


    @When("User clicks on calendar page link")
    public void userClicksOnCalendarPageLink() {

        calendarPage.calendarPageLink.click();
    }

    @And("User clicks on action item and then daily action button")
    public void userClicksOnActionItemAndThenDailyActionButton() {

        calendarPage.ActionItemButton.click();
        calendarPage.DailyActionButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("User should be display daily calendar view")
    public void user_should_be_display_daily_calendar_view() {
        Assert.assertTrue((calendarPage.DailyCalendarView).isDisplayed());
    }

    @When("User clicks on action item  and weekly action button")
    public void userClicksOnActionItemAndWeeklyActionButton() {
        BrowserUtils.waitFor(2);
        calendarPage.ActionItemButton.click();
        calendarPage.WeeklyActionButton.click();

    }

    @Then("User should be display weekly calendar view")
    public void userShouldBeDisplayWeeklyCalendarView() {
        Assert.assertTrue((calendarPage.WeeklyCalendarView).isDisplayed());
    }

    @When("User clicks on action item and monthly action button")
    public void userClicksOnActionItemAndMonthlyActionButton() {
        calendarPage.ActionItemButton.click();
        calendarPage.MonthlyActionButton.click();
        BrowserUtils.waitFor(3);

    }

    @Then("User should be display monthly calendar view")
    public void userShouldBeDisplayMonthlyCalendarView() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue((calendarPage.MonthlyCalendarView).isDisplayed());
    }

    @When("User clicks on new event button on the left side")
    public void userClicksOnNewEventButtonOnTheLeftSide() {
        calendarPage.NewEventButton.click();
    }

    @And("User types {string}, {string}, {string}  as event")
    public void userTypesAsEvent(String title, String date1, String date2) {

        Actions actions = new Actions(Driver.getDriver());

        calendarPage.title.clear();
        calendarPage.title.click();
        actions.sendKeys(title).perform();

        wait.until(ExpectedConditions.elementToBeClickable(calendarPage.startDate)).click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value = '';", calendarPage.startDate);
        calendarPage.startDate.sendKeys(date1);

        BrowserUtils.waitFor(4);

        wait.until(ExpectedConditions.elementToBeClickable(calendarPage.endDate)).click();
        js.executeScript("arguments[0].value = '';", calendarPage.endDate);
        calendarPage.endDate.sendKeys(date2);

        actions.click(calendarPage.SaveButton).perform();
    }

    @Then("User should see the events")
    public void userShouldSeeTheEvents() {

        String expectEventTitle1 = "vacation";
        calendarPage.ActionItemButton.click();
        calendarPage.MonthlyActionButton.click();
        calendarPage.ThirtiethDayLink.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(calendarPage.DailyEventTitle.isDisplayed());
        Assert.assertEquals(expectEventTitle1, calendarPage.DailyEventTitle.getText());

        String expectEventTitle2 = "sprint planning";
        calendarPage.ActionItemButton.click();
        calendarPage.MonthlyActionButton.click();
        calendarPage.NextMonthButton.click();
        calendarPage.FifteenthDayLink.click();
        Assert.assertTrue(calendarPage.DailyEventTitle.isDisplayed());
        Assert.assertEquals(expectEventTitle2, calendarPage.DailyEventTitle.getText());

        String expectEventTitle3 = "report date";
        calendarPage.ActionItemButton.click();
        calendarPage.MonthlyActionButton.click();
        calendarPage.DatePickerButton.click();
        calendarPage.DatePickerYear.click();
        calendarPage.YearSelectBtn.click();
        calendarPage.MonthSelectBtn.click();
        calendarPage.FirstDaySelectBtn.click();
        //calendarPage.FirstDayLink.click();
        Assert.assertTrue(calendarPage.DailyEventTitle.isDisplayed());
        Assert.assertEquals(expectEventTitle3, calendarPage.DailyEventTitle.getText());

    }

    @And("User click on the created event link and event action button")
    public void userClickOnTheCreatedEventLinkAndEventActionButton() {
        wait.until(ExpectedConditions.elementToBeClickable(calendarPage.createdEventLink));
        calendarPage.createdEventLink.click();
        BrowserUtils.waitFor(2);
        calendarPage.MoreButton.click();
        BrowserUtils.waitFor(2);
        calendarPage.eventActionItemButton.click();
        BrowserUtils.waitFor(2);
    }

    @And("User click on delete button")
    public void userClickOnDeleteButton() {

        calendarPage.DeleteButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("User should be able to delete the event")
    public void userShouldBeAbleToDeleteTheEvent() {
        BrowserUtils.waitFor(2);

        Assert.assertTrue((calendarPage.DailyEventTitle.getText()).isEmpty());
    }


}