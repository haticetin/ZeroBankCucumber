package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement dropdownElement;

    @FindBy(xpath = "//tr/th")
    public List<WebElement> listTransactionsColumns;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement transactionsTab;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonFind;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateBox;

    @FindBy(id = "aa_toDate")
    public WebElement toDateBox;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[1]")
    public List<WebElement> listOfDates;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[2]")
    public List<WebElement> listOfDescription;

    @FindBy(id = "aa_type")
    public WebElement typeDropdown;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[3]")
    public List<WebElement> dataListOfDeposits;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[4]")
    public List<WebElement> dataListOfWithdrawals;




}





