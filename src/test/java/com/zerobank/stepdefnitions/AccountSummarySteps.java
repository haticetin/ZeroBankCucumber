package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummarySteps {

    @Given("the user should be logged in")
    public void the_user_should_be_logged_in() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage = new LoginPage();
        loginPage.loginValid();
        String expectedUrl = "http://zero.webappsecurity.com/bank/account-summary.html";
        Assert.assertEquals(expectedUrl,Driver.get().getCurrentUrl());
    }

    @Then("the Account Summary Page should have title as {string}")
    public void the_Account_Summary_Page_should_have_title_as(String expectedTitle) {
        Assert.assertEquals(expectedTitle,Driver.get().getTitle());
    }

    @Then("the Account Summary Page should have account types as")
    public void the_Account_Summary_Page_should_have_account_types_as(List<String> accountTypes) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualList = BrowserUtils.getElementsText(accountSummaryPage.listAccountTypes);
        Assert.assertEquals(accountTypes.toString(),actualList.toString());
        System.out.println("listAccountTypes = " + actualList.toString());
    }

    @Then("the Account Summary Page Credit Account table should have columns as")
    public void the_Account_Summary_Page_Credit_Account_table_should_have_columns_as(List<String> creditColumns) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualList = BrowserUtils.getElementsText(accountSummaryPage.listCreditColumns);
        Assert.assertEquals(creditColumns.toString(),actualList.toString());
        System.out.println("listCreditColumns = " + actualList.toString());
    }

}
