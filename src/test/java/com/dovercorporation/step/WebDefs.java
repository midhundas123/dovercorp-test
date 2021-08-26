package com.dovercorporation.step;

import com.dovercorporation.pages.Homepage;
import com.dovercorporation.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WebDefs extends DriverBase{
    Login login = null;
    Homepage homepage = null;

    public void navigateToURL(){
        driver.get("https://eng-qa.systechcloud.net/");
    }


    @Given("QA environment of systechcloud")
    public void qa_environment_of_systechcloud() {
        navigateToURL();
    }

    @When("I login to UniSecure with my username {string} and password {string} with login option as Operator")
    public void i_login_to_uni_secure_with_my_username_and_password_with_login_option_as_operator(String string, String string2) {
        login = new Login(driver);
        login.clickOnProductIcon();
        homepage = login.login(string , string2);
    }

    @Then("I should be able to navigate to Welcome Page of Operator")
    public void i_should_be_able_to_navigate_to_welcome_page_of_operator()  {
        Assert.assertTrue(homepage.isHomePageLoaded());
    }

    @When("I login to QA bible application with wrong username {string} and wrong password {string} with login option as Operator")
    public void i_login_to_qa_bible_application_with_wrong_username_and_wrong_password_with_login_option_as_operator(String string, String string2) {
        login = new Login(driver);
        login.clickOnProductIcon();
        homepage = login.login(string , string2);
    }

    @Then("I should be able to see the validation message for invalid login")
    public void i_should_be_able_to_see_the_validation_message_for_invalid_login() {
        Assert.assertEquals("There is a problem with the specified username/password. Confirm you have entered the username and password correctly.", login.getTextOfInvalidLoginError());
    }

    @When("I access About Us")
    public void i_access_about_us() {
        homepage.clickOnAboutUs();
    }

    @Then("I should be able to view version and build number details")
    public void i_should_be_able_to_view_version_and_build_number_details() {
        Assert.assertTrue(homepage.getBuildNumberNumber().contains("2021"));
        Assert.assertTrue(homepage.getVersionNumber().contains("8."));
    }

}
