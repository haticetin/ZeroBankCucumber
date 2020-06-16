package com.zerobank.stepdefnitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencySteps {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new AccountSummarySteps().the_user_should_be_logged_in();
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.navigateToTab("Pay Bills");
        payBillsPage.purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies) {
        Select dropdown = new Select(new PayBillsPage().currencyDropdown);
        List<String> dropList = BrowserUtils.getElementsText(dropdown.getOptions());
        Assert.assertTrue(dropList.containsAll(currencies));
        System.out.println("dropList = " + dropList);
        System.out.println("currencies = " + currencies);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.calCostButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertEquals("Please, ensure that you have filled all the required fields with valid values.",alert.getText());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        PayBillsPage payBillsPage = new PayBillsPage();
        Select dropdown = new Select(payBillsPage.currencyDropdown);
        dropdown.selectByIndex(3);
        //payBillsPage.purchaseAmount.sendKeys("450");   //without entering a value
        payBillsPage.radioButtonDollar.click();
        payBillsPage.calCostButton.click();
    }
}
