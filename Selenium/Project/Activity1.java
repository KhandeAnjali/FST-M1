package liveproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        Reporter.log("Test Execution Started");
        driver.get("https://alchemy.hguy.co/jobs/");
        Reporter.log("Opened Site");
    }
    @Test
    public void titleValidation(){
        String title = driver.getTitle();
        Reporter.log(title);
        Assert.assertEquals(title,"Alchemy Jobs – Job Board Application");
        Reporter.log("Title validation is completed");
    }

    @AfterClass
    public void cleanUp(){
        Reporter.log("Closing the browser");
        driver.close();
    }
}
