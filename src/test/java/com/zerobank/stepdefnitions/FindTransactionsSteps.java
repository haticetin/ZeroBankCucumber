package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FindTransactionsSteps {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {

        AccountActivityPage accountActivityPage =  new AccountActivityPage();
        new AccountSummarySteps().the_user_should_be_logged_in();
        accountActivityPage.navigateToTab("Account Activity");
        accountActivityPage.transactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.fromDateBox.clear();
        accountActivityPage.toDateBox.clear();
        accountActivityPage.fromDateBox.sendKeys(fromDate);
        accountActivityPage.toDateBox.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage().buttonFind.click();
        BrowserUtils.waitFor(1);
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> datesStr = BrowserUtils.getElementsText(accountActivityPage.listOfDates);

        int fromDateInt = Integer.parseInt(fromDate.replace("-",""));
        int toDateInt = Integer.parseInt(toDate.replace("-",""));

        for (String s : datesStr) {
            Assert.assertTrue( Integer.parseInt(s.replace("-",""))<=toDateInt);
            //System.out.println("s = " + Integer.parseInt(s.replace("-",""))+"<="+toDateInt);
            Assert.assertTrue(Integer.parseInt(s.replace("-",""))>=fromDateInt);
            //System.out.println("s = " + Integer.parseInt(s.replace("-",""))+">="+fromDateInt);
        }

    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> datesStr = BrowserUtils.getElementsText(accountActivityPage.listOfDates);
        for (int i=0;i<datesStr.size()-1;i++) {
            Assert.assertTrue( Integer.parseInt(datesStr.get(i).replace("-",""))>=Integer.parseInt(datesStr.get(i+1).replace("-","")));
        }

    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> datesStr = BrowserUtils.getElementsText(accountActivityPage.listOfDates);
        for (String s : datesStr) {
            Assert.assertNotEquals(string,s);
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String strDescription) {
        new AccountActivityPage().descriptionBox.clear();
        new AccountActivityPage().descriptionBox.sendKeys(strDescription);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String strDescription) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> listStrDescription = BrowserUtils.getElementsText(accountActivityPage.listOfDescription);
        if(listStrDescription.size()!=0) {            //I added this to check html gives us rows of info about that description or not
            for (String s : listStrDescription) {     // otherwise it doesn't enter the for each loop and doesn't check
                Assert.assertTrue(s.contains(strDescription));
            }
        }else{
            Assert.fail("Table didn't show any related data row");
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String strDescription) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> listStrDescription = BrowserUtils.getElementsText(accountActivityPage.listOfDescription);
        for (String s : listStrDescription) {
            Assert.assertFalse(s.contains(strDescription));
        }
    }


    @Then("results table should show at least one result under {string}")
    public void resultsTableShouldShowAtLeastOneResultUnder(String typeOfTransaction){
        List<String> listOfRow = null;
        if (typeOfTransaction.equals("Deposit")){
            listOfRow = BrowserUtils.getElementsText(new AccountActivityPage().dataListOfDeposits);
        }else if (typeOfTransaction.equals("Withdrawal")){
            listOfRow = BrowserUtils.getElementsText(new AccountActivityPage().dataListOfWithdrawals);
        }

            if (listOfRow.size()>0) {
                int count=0;
                for (String s:listOfRow) {
                    if(!s.isEmpty()){
                        count++;
                    }
                }
                System.out.println("count = " + count);
                Assert.assertTrue(count>0);
            }

    }

    @When("user selects type {string}")
    public void userSelectsType(String typeOfTransaction) {
        Select dropdown = new Select(new AccountActivityPage().typeDropdown);
        dropdown.selectByVisibleText(typeOfTransaction);
        clicks_search();
    }

    @But("results table should show no result under {string}")
    public void resultsTableShouldShowNoResultUnder(String typeOfTransaction) {

        List<String> listOfRow = null;
        if (typeOfTransaction.equals("Deposit")){
            listOfRow = BrowserUtils.getElementsText(new AccountActivityPage().dataListOfDeposits);
        }else if (typeOfTransaction.equals("Withdrawal")){
            listOfRow = BrowserUtils.getElementsText(new AccountActivityPage().dataListOfWithdrawals);
        }

        if (listOfRow.size()>0) {
            int count=0;
            for (String s:listOfRow) {
                if(!s.isEmpty()){
                    count++;
                }
            }
            System.out.println("count = " + count);
            Assert.assertEquals(0, count);
        }else{
            Assert.assertTrue(true);
        }

    }
}
