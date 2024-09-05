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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        System.setProperty("webdriver.chrome.driver","/Users/zhongchongyuan/Developer/WebDrivers/chromedriver");
        testContextSetup.driver = new ChromeDriver(options);
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(2000);
        System.out.println(">>>User is on GreenCart Landing Page");
    }


    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        WebElement searchBox = testContextSetup.driver.findElement(By.xpath("//input[@type='search']"));
        searchBox.sendKeys(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(">>>"+landingPageProductName+" is exteacted from Home Page ");
    }

}
