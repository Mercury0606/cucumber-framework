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
import utils.TestContextSetup;




public class LandingPageStepDefinition {

    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;

    }

    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() throws InterruptedException {
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(2000);
        System.out.println(">>>User is on GreenCart Landing Page");
    }


    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);

        Thread.sleep(2000);
        testContextSetup.landingPageProductName = landingPage.getSearchText().split("-")[0].trim();
        System.out.println(">>>"+testContextSetup.landingPageProductName+" is exteacted from Home Page ");
    }

}
