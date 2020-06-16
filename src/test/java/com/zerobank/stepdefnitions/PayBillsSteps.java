package com.zerobank.stepdefnitions;


import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.Map;

public class PayBillsSteps {

    @Then("the Pay Bills Page should have title as {string}")
    public void the_Pay_Bills_Page_should_have_title_as(String title) {
        Assert.assertEquals(title, Driver.get().getTitle());
    }

    @When("user completes a successful Pay operation")
    public void user_completes_a_successful_Pay_operation() {

        PayBillsPage payBillsPage = new PayBillsPage();
        Select dropdown = new Select(payBillsPage.PayeeDropdown);
        dropdown.selectByVisibleText("Wells Fargo");
        dropdown = new Select(payBillsPage.accountDropdown);
        dropdown.selectByVisibleText("Brokerage");
        payBillsPage.amount.sendKeys("250");  //Amount field should not accept alphabetical or special characters. You can try this also
        payBillsPage.date.sendKeys("2020-06-20");
        payBillsPage.description.sendKeys("It is a debt");
        payBillsPage.payButton.click();

    }
    @Then("after valid payment {string} should be displayed")
    public void after_valid_payment_should_be_displayed(String alertStr) {

        WebElement greenAlert = Driver.get().findElement(By.xpath("//div[@id='alert_content']"));
        Assert.assertEquals(alertStr,greenAlert.getText());

    }

    @When("the user tries to make a payment without entering the amount")
    public void the_user_tries_to_make_a_payment_without_entering_the_amount() {
        PayBillsPage payBillsPage = new PayBillsPage();
        Select dropdown = new Select(payBillsPage.PayeeDropdown);
        dropdown.selectByVisibleText("Wells Fargo");
        dropdown = new Select(payBillsPage.accountDropdown);
        dropdown.selectByVisibleText("Brokerage");
        //payBillsPage.amount.sendKeys("250");
        payBillsPage.date.sendKeys("2020-06-20"); //Date field should not accept alphabetical characters. You can try this also
        payBillsPage.description.sendKeys("It is a debt");
        payBillsPage.payButton.click();
    }


    @Then("after invalid payment {string} should be displayed on amount")
    public void after_invalid_payment_should_be_displayed_on_amount(String fillOutAlert) {
        PayBillsPage payBillsPage = new PayBillsPage();
        String message = payBillsPage.amount.getAttribute("validationMessage"); //it will get the alert message next to input box
        Assert.assertEquals(fillOutAlert,message);

    }

    @When("the user tries to make a payment without entering the date")
    public void the_user_tries_to_make_a_payment_without_entering_the_date() {

        PayBillsPage payBillsPage = new PayBillsPage();
        Select dropdown = new Select(payBillsPage.PayeeDropdown);
        dropdown.selectByVisibleText("Wells Fargo");
        dropdown = new Select(payBillsPage.accountDropdown);
        dropdown.selectByVisibleText("Brokerage");
        payBillsPage.amount.sendKeys("250");  //Amount field should not accept alphabetical or special characters. You can try this also
        //payBillsPage.date.sendKeys("2020-06-20");
        payBillsPage.description.sendKeys("It is a debt");
        payBillsPage.payButton.click();

    }

    @Then("after invalid payment {string} should be displayed on date")
    public void after_invalid_payment_should_be_displayed_on_date(String fillOutAlert) {
        PayBillsPage payBillsPage = new PayBillsPage();
        String message = payBillsPage.date.getAttribute("validationMessage"); //it will get the alert message next to input box
        Assert.assertEquals(fillOutAlert,message);
    }

    @Given("Add New Payee tab")
    public void addNewPayeeTab() {

        new AccountSummarySteps().the_user_should_be_logged_in();
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.navigateToTab("Pay Bills");
        payBillsPage.addNewPayeeTab.click();
        //BrowserUtils.waitFor(1);

    }

    @And("creates new payee using following information")
    public void createsNewPayeeUsingFollowingInformation(Map<String,String> payeeInfo) {

        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payeeName.sendKeys(payeeInfo.get("Payee Name"));
        payBillsPage.payeeAddress.sendKeys(payeeInfo.get("Payee Address"));
        payBillsPage.payeeAccount.sendKeys(payeeInfo.get("Account"));
        payBillsPage.payeeDetails.sendKeys(payeeInfo.get("Payee Details"));
        payBillsPage.addButton.click();
        BrowserUtils.waitFor(1);


    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {

        Assert.assertTrue(new PayBillsPage().alertInPayBills.isDisplayed() && message.equals(new PayBillsPage().alertInPayBills.getText()));

    }
}
