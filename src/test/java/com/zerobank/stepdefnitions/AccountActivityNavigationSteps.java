package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationSteps {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateToAccountLink(link);

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Assert.assertEquals("active", accountActivityPage.baseTabList.get(1).getAttribute("class"));
        //it will check the Account Activity page tab is active or not!
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedOption) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select dropdown = new Select(accountActivityPage.dropdownElement);
        Assert.assertEquals(expectedOption,dropdown.getFirstSelectedOption().getText());

    }

}
