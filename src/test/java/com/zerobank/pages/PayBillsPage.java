package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage {

    @FindBy(id = "sp_payee")
    public WebElement PayeeDropdown;

    @FindBy(id = "sp_account")
    public WebElement accountDropdown;

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public WebElement description;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//*[@id='tabs']//li[2]/a")
    public WebElement addNewPayeeTab;

    @FindBy(xpath = "//*[@id='tabs']//li[3]/a")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(id = "alert_content")
    public WebElement alertInPayBills;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;

    @FindBy(id = "pc_amount")
    public WebElement purchaseAmount;

    @FindBy(id = "purchase_cash")
    public WebElement purchaseButton;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calCostButton;

    @FindBy(id = "pc_inDollars_true")
    public WebElement radioButtonDollar;
}
