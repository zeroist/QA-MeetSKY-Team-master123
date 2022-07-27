package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class,'menutoggle icon-view-')]")
    public WebElement ActionItemButton;

    @FindBy(xpath = "(//ul[starts-with(@id,'menu')]//button)[1]")
    public WebElement DailyActionButton;

    @FindBy(xpath = "(//ul[starts-with(@id,'menu')]//button)[2]")
    public WebElement WeeklyActionButton;

    @FindBy(xpath = "(//ul[starts-with(@id,'menu')]//button)[3]")
    public WebElement MonthlyActionButton;

    @FindBy(xpath = "//div[@class='fc-timegrid fc-timeGridDay-view fc-view']")
    public WebElement DailyCalendarView;

    @FindBy(xpath = "//div[@class='fc-timegrid fc-timeGridWeek-view fc-view']")
    public WebElement WeeklyCalendarView;

    @FindBy(xpath = "//div[@class='fc-daygrid fc-dayGridMonth-view fc-view']")
    public WebElement MonthlyCalendarView;

    @FindBy(xpath = "//button[@class='button primary new-event']")
    public WebElement NewEventButton;

    //@FindBy(xpath="//input[@placeholder='Event title']")
    //public WebElement EventTitleInputBox;

    @FindBy(css = ".property-title__input>input")
    public WebElement title;

    @FindBy(xpath = "(//input[@name='date'])[2]")
    public WebElement startDate;

    @FindBy(xpath = "(//input[@name='date'])[3]")
    public WebElement endDate;

    @FindBy(xpath = "//input[@id='allDay']")
    public WebElement AllDayButton;

    @FindBy(xpath = "//td[@title='2022-07-30']")
    public WebElement DatePickerThirty;

    @FindBy(xpath = "//td[@title='2022-07-31']")
    public WebElement DatePickerThirtyOne;

    @FindBy(xpath = "//td[@title='2022-08-15']")
    public WebElement DayAugustFifteenthButton;

    @FindBy(xpath = "//div[contains(@class,'fc-sticky')]")
    public WebElement DailyEventTitle;

    @FindBy(xpath = "(((//table[@class='fc-scrollgrid-sync-table']/tbody/tr)[5]/td)[6]//a)")
    public WebElement ThirtiethDayLink;

    @FindBy(xpath = "((((//table[@class='fc-scrollgrid-sync-table']/tbody/tr)[5]/td)[6]//a)[2])//div[3]")
    public WebElement createdEventTitle;

    @FindBy(xpath = "(((//table[@class='fc-scrollgrid-sync-table']/tbody/tr)[5]/td)[6]//a)[2]")
    public WebElement createdEventLink;

    @FindBy(xpath = "((//table[@class='fc-scrollgrid-sync-table']/tbody/tr)[3]/td)//a")
    public WebElement FifteenthDayLink;

    @FindBy(xpath = "//a[@data-recurrence-id='1660561200']")
    public WebElement createdEventLink2;

    @FindBy(xpath = "((//table[@class='fc-scrollgrid-sync-table']/tbody/tr)[1]/td)[7]//a")
    public WebElement FirstDayLink;

    @FindBy(xpath = "//a[@data-recurrence-id='1672549200']")
    public WebElement createdEventLink3;

    @FindBy(xpath = "(//button[contains(@class,'menutoggle--default-icon')])[5]")
    public WebElement eventActionItemButton;

    @FindBy(css = ".event-popover__buttons>button[class='primary']")
    public WebElement SaveButton;

    @FindBy(xpath = "//div[@class='event-popover__buttons']//button")
    public WebElement MoreButton;

    @FindBy(css = ".action.active>button")
    public WebElement DeleteButton;

    @FindBy(xpath = "//button[@title='Next month']")
    public WebElement NextMonthButton;

    @FindBy(xpath = "(//div[@class='datepicker-button-section']/button)[2]")
    public WebElement DatePickerButton;

    // @FindBy(xpath="(//table[@class='mx-table mx-table-date']/tbody/tr[5]/td)[6]")
    // public WebElement DatePickerThirty;

    //@FindBy(xpath="(//table[@class='mx-table mx-table-date']/tbody/tr[5]/td)[7]")
    //public WebElement DatePickerThirtyOne;

    @FindBy(xpath = "//span[@class='mx-calendar-header-label']/button[2]")
    public WebElement DatePickerYear;

    @FindBy(xpath = "//span[@class='mx-calendar-header-label']/button[1]")
    public WebElement DatePickerMonth;

    @FindBy(xpath = "//table[contains(@class,'mx-table-year')]/tr[2]/td[2]")
    public WebElement YearSelectBtn;

    @FindBy(xpath = "//table[contains(@class,'mx-table-month')]/tr[3]/td[3]")
    public WebElement MonthSelectBtn;

    @FindBy(xpath = "//table[contains(@class,'mx-table-date')]/tbody/tr[1]/td[7]")
    public WebElement FirstDaySelectBtn;

    @FindBy(xpath = "//div[@class='mx-datepicker-footer']//button")
    public WebElement PickTimeBtn;

    @FindBy(xpath = "(((//table[@class='fc-scrollgrid-sync-table']/tbody/tr)[5]/td)[6]//div)[3]")
    public WebElement eventBox;


    //hour list=((//ul[@class='mx-time-list'])[1])//li[9]
    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
