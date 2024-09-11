package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By promoCode = By.xpath("//input[@placeholder='Enter promo code']");

    By applyBtn = By.cssSelector(".promoBtn");
    By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");

    public void proceedPromo(String code){
        driver.findElement(promoCode).sendKeys(code);
        driver.findElement(applyBtn).click();
        driver.findElement(placeOrderBtn).click();


    }












}
