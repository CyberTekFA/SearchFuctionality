package com.events.tests.functional_tests;

import com.events.tests.pages.SearchFunctionalityLocators;
import com.events.utilities.Driver;
import com.events.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SearchFunctionalityTest extends TestBase {

    SearchFunctionalityLocators search = new SearchFunctionalityLocators();

    @Test
    public void TestCase1() {
        testLogger = reports.createTest("Search fuctionlity testcase 1 executed");
        search.BriteErpDemo.click();
        testLogger.pass("Clicked on the BriteErpDemo link");

        search.setUserNameandPassword("EventsCRM_Manager6@info.com", "Ugh45wQ17");
        testLogger.pass("UserName and Password Entered");

        search.logInbutton.click();
        testLogger.pass("Clicked On logIn Button");

        search.EventLiks.click();
        testLogger.pass("Clicked on Events lInk");

        search.advanceSearch.click();
        testLogger.pass("clicked on advance search button");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(search.removeDefaultFilter));

        search.removeDefaultFilter.click();
        testLogger.pass("Clicked on Default Filter button");
        testLogger.info("Verify that all Events are Displeyed ");

        search.allUpcominEvents.getText();
        testLogger.pass("all Events ");

        search.allUpcominEvents.isDisplayed();
        testLogger.pass("Events are Displyed True");

        testLogger.info("user shoul be able to search by events name");
        search.searchBox.sendKeys("Event 1" + Keys.ENTER);
        testLogger.pass("User Entered Events name and clicked On keyboard Enter button");
        testLogger.info("Verify Expected Event is Displeyed");

        search.Event_1.isDisplayed();
        testLogger.pass("Event is Displeyd as Expected");

    }


    @Test
    public void TestCase2() {
        testLogger = reports.createTest("Search fuctionlity testcase 2 executed");
        search.BriteErpDemo.click();
        testLogger.pass("Clicked on the BriteErpDemo link");

//        search.setUserNameandPassword("EventsCRM_Manager6@info.com", "Ugh45wQ17");
//        testLogger.pass("UserName and Password Entered");
//
//        search.logInbutton.click();
//        testLogger.pass("Clicked On logIn Button");

        search.EventLiks.click();
        testLogger.pass("Clicked on Events lInk");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(search.removeDefaultFilter));
        testLogger.info("Waite till the Element is visible");

        search.removeDefaultFilter.click();
        testLogger.pass(" removed the Default Filter ");

//        search.advanceSearch.click();
//        testLogger.pass("clicked on advance search");


        search.filterButton.click();
        testLogger.pass("clicked on Filter button");

        search.confirmedEvents.click();
        testLogger.pass("clicked on the confirmed events link");

        search.allUpcominEvents.isDisplayed();
        testLogger.pass("all confirmed Events are Displyed to User");

    }

    @Test
    public void TestCase3() {
        testLogger = reports.createTest("Search fuctionlity testcase 3 executed");
        search.BriteErpDemo.click();
        testLogger.pass("Clicked on the BriteErpDemo link");

//        search.setUserNameandPassword("EventsCRM_Manager6@info.com", "Ugh45wQ17");
//        testLogger.pass("UserName and Password Entered");
//
//        search.logInbutton.click();
//        testLogger.pass("Clicked On logIn Button");

        search.EventLiks.click();
        testLogger.pass("Clicked on Events lInk");

        search.removeDefaultFilter.click();
        testLogger.pass("clicked on remove Default button");

//        search.advanceSearch.click();
//        testLogger.pass("clicked on advance search button");


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(search.groupedby));

        search.groupedby.click();
        testLogger.pass("clicked on groupedby filter");


        search.addCostomgroups.click();
        testLogger.pass("clicked on add costom group button");



        Select select = new Select(search.selections);
        select.selectByVisibleText("Dedicated Menu");
        testLogger.pass("select by Text from seletions menu");

        search.apply.click();
        testLogger.pass("clicked on apply button");




    }
}
