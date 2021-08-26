package com.dovercorporation.pages;

import com.dovercorporation.utilities.PageUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends PageUtility {

    WebDriver driver;

    @FindBy(xpath = "//*[text()='The UniSecure UI supports a number of user roles. The UniSecure Designer role is primarily responsible for creating and publishing definitions that define Products, packaging labels, and the life cycle of product signatures.']")
    WebElement text_Welcome;

    @FindBy(xpath = "//*[@id=\"navBtn_about\"]")
    WebElement aboutUS;

    @FindBy(xpath = "//span[contains(text(),'Version:')]")
    WebElement versionNo;

    @FindBy(xpath = "//span[contains(text(),'Build number:')]")
    WebElement buildNo ;


    public Homepage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean isHomePageLoaded() {
        waitForJSandJQueryToLoad(driver);
        waitForElementTobeVisible(driver,text_Welcome,30);
        return text_Welcome.isDisplayed();
    }

    public Homepage clickOnAboutUs() {
        waitForJSandJQueryToLoad(driver);
        waitForElementTobeVisible(driver,aboutUS,30);
        sleep(3000);
        aboutUS.click();
        return this;
    }

    public String getVersionNumber() {
        waitForElementTobeVisible(driver,versionNo,30);
        waitForJSandJQueryToLoad(driver);
        return versionNo.getText();
    }

    public String getBuildNumberNumber() {
        sleep(3000);
        waitForElementTobeVisible(driver,buildNo,30);
        waitForJSandJQueryToLoad(driver);
        return buildNo.getText();
    }

}
