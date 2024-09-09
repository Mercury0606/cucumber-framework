package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public WebDriver WebDriverManager() throws IOException {
        //Dynamic path => System.getProperty("user.dir")
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resource/global.properties");
        Properties prop = new Properties();
        prop.load(fileInputStream);
        String url = prop.getProperty("url");
        if (driver == null ){
            if (prop.getProperty("browser").equalsIgnoreCase( "chrome")){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resource/chromedriver");
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-extensions");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver.get(url);
        }
        return driver;
    }
}
