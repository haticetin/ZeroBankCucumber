package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(css = "h2.board-header")
    public List<WebElement> listAccountTypes;

    @FindBy(xpath = "(//thead/tr)[3]/th")
    public List<WebElement> listCreditColumns;

    public void navigateToAccountLink(String accountLink) {
        String linkLocator = "//a[text()='" + accountLink + "']";
        try {
            WebElement linkElement = Driver.get().findElement(By.xpath(linkLocator));
            new Actions(Driver.get()).moveToElement(linkElement).pause(200).click(linkElement).perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(linkLocator), 5);
        }
    }
}
