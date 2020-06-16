package com.zerobank.stepdefnitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enter valid credantials")
    public void the_user_enter_valid_credantials() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginValid();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        LoginPage loginPage = new LoginPage();
        String currentTab = loginPage.accountSumTab.getText();
        System.out.println("currentTab = " + currentTab);
        Assert.assertEquals("Account Summary",currentTab);
    }

    @When("the user enter invalid credantials")
    public void the_user_enter_invalid_credantials() {
        String username = ConfigurationReader.get("invalid_username");
        String password = ConfigurationReader.get("invalid_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.alertLogin.isDisplayed());
    }

    @When("the user enter blank credantials")
    public void the_user_enter_blank_credantials() {
        String username = ConfigurationReader.get("blank_username");
        String password = ConfigurationReader.get("blank_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

}
