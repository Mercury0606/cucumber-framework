package utils;

import org.openqa.selenium.WebDriver;
import pageObject.PageObjectManager;

public class  TestContextSetup {
    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;


    public TestContextSetup() {
        testBase=new TestBase();
        driver = testBase.WebDriverManager();
        pageObjectManager = new PageObjectManager(driver);
        genericUtils = new GenericUtils(driver);
    }
}
