package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    public WebDriver driver;
    public WebDriver WebDriverManager(){
        if (driver == null ){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-extensions");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            System.setProperty("webdriver.chrome.driver","/Users/zhongchongyuan/Developer/WebDrivers/chromedriver");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
