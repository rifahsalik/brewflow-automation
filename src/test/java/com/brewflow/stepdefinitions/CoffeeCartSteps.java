
package com.brewflow.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.brewflow.base.Driver;
import com.brewflow.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CoffeeCartSteps {

    private static final Logger logger =
            LogManager.getLogger(CoffeeCartSteps.class);

    private WebDriver driver;
    private HomePage homePage;

    @Given("the browser is open")
    public void theBrowserIsOpen() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);

        logger.info("Browser is open");
    }

    @When("the user navigates to the Coffee Cart homepage")
    public void theUserNavigatesToTheCoffeeCartHomepage() {
        logger.info("Navigating to Coffee Cart homepage");

        driver.get("https://coffee-cart.app/");
    }

    @Then("the homepage title should be {string}")
    public void theHomepageTitleShouldBe(String expectedTitle) {
        logger.info("Verifying homepage title");

        try {
            // Wait for the homepage title to appear
            boolean pageLoaded = homePage.isPageLoaded();

            Assert.assertTrue(
                    pageLoaded,
                    "Coffee Cart homepage did not load"
            );

            // Verify the actual page title
            String actualTitle = homePage.getPageTitle();

            Assert.assertEquals(
                    actualTitle,
                    expectedTitle,
                    "The homepage title did not match!"
            );

            logger.info(
                    "Homepage title verified successfully: {}",
                    actualTitle
            );

        } catch (AssertionError e) {
            logger.error("Homepage title verification failed", e);
            throw e;
        }
    }
}
