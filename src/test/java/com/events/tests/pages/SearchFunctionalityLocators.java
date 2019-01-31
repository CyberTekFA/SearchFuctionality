package com.events.tests.pages;

import com.events.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchFunctionalityLocators {
    public SearchFunctionalityLocators() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "a[href='/web?db=BriteErpDemo']")
    public WebElement BriteErpDemo;

    @FindBy(id = "login")
    public WebElement userName;
    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "button[type='submit']")
    public WebElement logInbutton;

    @FindBy(xpath = "//*[@id='oe_main_menu_navbar']/div[2]/ul[1]/li[10]/a/span")
    public WebElement EventLiks;

    @FindBy(css = "div[class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement removeDefaultFilter;

    @FindBy(css = "input[class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(css = "div[class='o_kanban_view o_event_kanban_view o_kanban_ungrouped']")
    public WebElement allUpcominEvents;

    @FindBy(xpath = "//div[@class='o_kanban_view o_event_kanban_view o_kanban_ungrouped']//div[9]")
    public WebElement Event_1;

    @FindBy(css = "span[title='Advanced Search...']")
    public WebElement advanceSearch;

    @FindBy(xpath = "(//span[@class='caret'])[1]")
    public WebElement filterButton;

    @FindBy(xpath = "(//span[@class='caret'])[2]")
    public WebElement groupedby;

    @FindBy(xpath = "//ul[@class='dropdown-menu o_group_by_menu']//li[5]")
    public WebElement EndDate;

    @FindBy(xpath = "//div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/ul/li[6]/a")
    public WebElement addCostomgroups;

    @FindBy(css = "select[class='o_input o_add_group o_group_selector']")
    public WebElement selections;

    @FindBy(css = "button[class='btn btn-primary btn-sm o_add_group o_select_group']")
    public WebElement apply;

    @FindBy(xpath = "//ul[@class='dropdown-menu o_filters_menu']//li[4]")
    public WebElement confirmedEvents;

    public void setUserNameandPassword(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
    }
}
