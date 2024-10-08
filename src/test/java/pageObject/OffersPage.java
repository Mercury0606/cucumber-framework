package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    public WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By search = By.xpath("//input[@type='search']");
    private By productName=By.cssSelector(" tr td:nth-child(1)");

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getSearchText(){
        return driver.findElement(search).getText();
    }
    public String getSearchName(){
        return driver.findElement(productName).getText();
    }
}
