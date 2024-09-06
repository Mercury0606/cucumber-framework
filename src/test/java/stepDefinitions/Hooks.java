package stepDefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Text;
import utils.TestContextSetup;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void AfterScenario(){

         testContextSetup.testBase.driver.close();
        System.out.println(">>>Browser is closed");
        testContextSetup.testBase.driver.quit();
        System.out.println(">>>Driver  quits");


    }
}
