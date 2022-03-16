package com.cydeo.tests.practice_03_16_2022;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US9_Practice {


    @Test
    public void invalid_repeat_day() {
        VytrackUtils.loginAsDriver();
        VytrackUtils.waitTillLoaderMaskDisappear();
        WebElement activitiesTab = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        activitiesTab.click();
        WebElement calendarEventsLink = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(calendarEventsLink).perform();
        calendarEventsLink.click();
        WebElement createCalendarEvent = Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']"));
        VytrackUtils.waitTillLoaderMaskDisappear();
        createCalendarEvent.click();
        WebElement repeatCheckbox = Driver.getDriver().findElement(By.xpath("//input[contains(@id,'recurrence-repeat-view')]"));
        repeatCheckbox.click();
        Assert.assertTrue(repeatCheckbox.isSelected(), "repeat checkbox is NOT checked");
        WebElement inputDays = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        inputDays.isEnabled();
        inputDays.clear();
        inputDays.sendKeys("-2");
        //BrowserUtils.sleep(2);
        WebElement warningText = Driver.getDriver().findElement(By.xpath("//span[.='The value have not to be less than 1.']"));
        String expectedText = "The value have not to be less than 1.";
        Assert.assertEquals(warningText.getText(), expectedText);
        inputDays.clear();
        inputDays.sendKeys("128");
        String expectedText2 = "The value have not to be more than 99.";
        Assert.assertEquals(warningText.getText(),expectedText2);

        Driver.closeDriver();
    }







}
