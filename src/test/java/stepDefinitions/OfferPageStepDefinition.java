package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageObject.LandingPage;
import pageObject.OffersPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    public WebDriver driver;
    public String offerPageProductName;
    public String landingPageProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup  = testContextSetup;
    }

    @Then("User searched with same {string} in offers page")
    public void user_searched_with_same_shortname_in_offers_page_to_check_if_product_exists(String shortName) {
        switchToOfferPage();
        OffersPage offersPage = new OffersPage(testContextSetup.driver);
        offersPage.searchItem(shortName);
        offerPageProductName = offersPage.getSearchText();

    }
    public void switchToOfferPage(){
        LandingPage landingPage = new LandingPage(testContextSetup.driver);
        landingPage.selectTopDeals();
        //if is already switched to offer page -> skip below part
        if (!testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")){
            Set<String> windowHandles = testContextSetup.driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();
            String parentWindow = iterator.next();
            String childWindow = iterator.next();
            testContextSetup.driver.switchTo().window(childWindow);
        }

    }
    @Then("Validate product name in offers page matches with Landing page")
    public void validate_prod_name_in_offers_page_matches_with_landing_page(){
        Assert.assertEquals(testContextSetup.landingPageProductName,offerPageProductName);
    }
}
