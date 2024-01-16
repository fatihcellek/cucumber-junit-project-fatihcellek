package com.fatihcellek.step_definitions;

import com.fatihcellek.pages.GoogleSearchPage;
import com.fatihcellek.utilities.BrowserUtils;
import com.fatihcellek.utilities.ConfigurationReader;
import com.fatihcellek.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Google_StepDefinitions {


    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user is on the Google search page")
    public void user_is_on_the_google_search_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));

    }
    @Then("user should see {word} in the title")
    public void user_should_see_apple_in_the_title(String word) {
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(word+" - Google Search");

    }

    @When("user searches for {word}")
    public void user_searches_for_apple(String word) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(googleSearchPage.cookiesAccept));
       // Driver.getDriver().manage().window().minimize();


        googleSearchPage.cookiesAccept.click();
        BrowserUtils.sleep(2);
        googleSearchPage.searchBox.sendKeys(word + Keys.ENTER);


    }




    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle, expectedTitle);

        Driver.closeDriver();

    }


//    @And("user sees {int} apples")
//    public void userSeesApples(int arg0) {
//
}

