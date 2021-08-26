package com.dovercorporation.pages;


import com.dovercorporation.utilities.PageUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends PageUtility {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"userName\"]")
    WebElement userName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"loginBtn\"]")
    WebElement btn_Login;

    @FindBy(xpath = "//*[@id=\"loginErrorMsg\"]")
    WebElement invalidLoginErrorMsg;

    @FindBy(xpath = "//*[@src='assets/img/Secure-Splash.jpg']")
    WebElement productIcon_Unisecure;

    @FindBy(xpath = "//*[@id=\"roleList\"]")
    WebElement loginType;


    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Homepage login(String uName, String pWd) {
        waitForJSandJQueryToLoad(driver);
        waitForElementTobeVisible(driver,userName,30);
        userName.sendKeys(uName);
        password.sendKeys(pWd);
        selectTypeAsOperator();
        btn_Login.click();
        return new Homepage(driver);
    }

    public String getTextOfInvalidLoginError() {
        waitForJSandJQueryToLoad(driver);
        waitForElementTobeVisible(driver, invalidLoginErrorMsg,30);
        sleep(5000);
        return invalidLoginErrorMsg.getText();
    }

    public Login clickOnProductIcon() {
        sleep(5000);
        waitForElementTobeVisible(driver, productIcon_Unisecure, 30).click();
        return this;
    }

    public Login selectTypeAsOperator() {
        selectByVisibleText(driver, loginType,"Operator");
        return this;
    }

}
