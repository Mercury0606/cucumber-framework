package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinition {
    WebDriver driver ;

    String shortName;
    String  offerPageProductName;
    String landingPageProductName;
    @Given("User is on GreenCart Landing Page")
    public void user_is_on_green_cart_landing_page() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        System.setProperty("webdriver.chrome.driver","/Users/zhongchongyuan/Developer/WebDrivers/chromedriver");
        driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(2000);
        System.out.println(">>>User is on GreenCart Landing Page");
    }
    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        searchBox.sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(">>>"+offerPageProductName+" is exteacted from Home Page ");
    }
    @Then("User searched with same {string} in offers page")
    public void user_searched_with_same_shortname_in_offers_page_to_check_if_product_exists(String shortName) {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.id("search-field")).sendKeys( shortName );
        landingPageProductName = driver.findElement(By.cssSelector(" tr td:nth-child(1)")).getText();

    }
    @Then("Validate product name in offers page matches with Landing page")
    public void validate_prod_name_in_offers_page_matches_with_landing_page(){
        Assert.assertEquals(landingPageProductName,offerPageProductName);
    }
}
