package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivitySteps {

    @Then("the Account Activity Page should have title as {string}")
    public void the_Account_Activity_Page_should_have_title_as(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @And("the user navigates to {string}")
    public void the_user_navigates_to(String tab) {
        new AccountActivityPage().navigateToTab(tab);
    }

    @Then("in the Account Activity Page dropdown default option should be {string}")
    public void in_the_Account_Activity_Page_dropdown_default_option_should_be(String expectedDefault) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select dropdownAccount = new Select(accountActivityPage.dropdownElement);
        String actualDefault = dropdownAccount.getFirstSelectedOption().getText();
        System.out.println("actualDefault = " + actualDefault);
        Assert.assertEquals(expectedDefault,actualDefault);
    }

    @When("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> options) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select dropdownAccount = new Select(accountActivityPage.dropdownElement); //Select dropdown
        List<WebElement> listOfDropdown = dropdownAccount.getOptions();           //get options of the dropdown as WebElements
        List<String> actualList = BrowserUtils.getElementsText(listOfDropdown);   //change the WebElement to string
        System.out.println("actualListOfDropdown = " + actualList);
        Assert.assertEquals(options,actualList);
    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> tables) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> actualList = BrowserUtils.getElementsText(accountActivityPage.listTransactionsColumns);
        Assert.assertEquals(tables.toString(),actualList.toString());
        System.out.println("listOfTransactionsColumns = " + actualList.toString());
    }


}
