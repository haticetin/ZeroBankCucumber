package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="user_login")
    public WebElement userName;

    @FindBy(id="user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(xpath = "//form/div[1]")
    public WebElement alertLogin;

    public void loginValid() {

        FirstPage firstPage = new FirstPage();
        firstPage.signinButton.click();
        userName.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password"));
        submit.click();
//        BrowserUtils.waitFor(1);
    }


    public void login(String userNameStr, String passwordStr) {

        FirstPage firstPage = new FirstPage();
        firstPage.signinButton.click();
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
//        BrowserUtils.waitFor(1);
    }

}
