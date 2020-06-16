package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "#account_summary_tab")
    public WebElement accountSumTab;

    @FindBy(css = "ul.nav.nav-tabs > li")
    public List<WebElement> baseTabList; //6 element

    public void navigateToTab(String tab) {
        String tabLocator = "//a[.=\""+tab+"\"]";
        try {
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).click(tabElement).perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
//        BrowserUtils.waitFor(1);

    }
}
