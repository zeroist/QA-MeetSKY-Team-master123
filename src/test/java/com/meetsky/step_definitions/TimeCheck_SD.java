package com.meetsky.step_definitions;

import com.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;

public class TimeCheck_SD {

    private static final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    public void userShouldSeeTheCurrentLocalTimeUnderTheLocalDropdown() {

        WebElement webElement = Driver.getDriver().findElement(By.xpath("//span[@id='localeexample-time']"));

        wait.until(ExpectedConditions.visibilityOf(webElement));

        String expectedTime = LocalDateTime.now().toString().substring(11, 19);
        String actualTime = webElement.getAttribute("innerText");
        actualTime = actualTime.endsWith("AM") ? actualTime.substring(0, actualTime.length() - 3) : Integer.parseInt(actualTime.substring(0, actualTime.indexOf(":"))) + 12 + actualTime.substring(actualTime.indexOf(":"), actualTime.length() - 3);

        System.out.println("expectedTime = " + expectedTime);
        System.out.println("actualTime = " + actualTime);

        Assert.assertTrue(expectedTime.contains(actualTime.substring(0, 7))); // check for the equality except last digit
        //Assert.assertEquals(expectedTime, actualTime);

    }
}
