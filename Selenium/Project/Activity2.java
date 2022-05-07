package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        Reporter.log("Test Execution Started");
        driver.get("https://alchemy.hguy.co/jobs/");
        Reporter.log("Opened Site");
    }
    @Test
    public void headerValidation(){
        String header = driver.findElement(By.xpath("//h1[contains(@class,'entry-title')]")).getText();
        Reporter.log(header);
        Assert.assertEquals(header,"Welcome to Alchemy Jobs");
        Reporter.log("Header validation is completed");
    }

    @AfterClass
    public void cleanUp(){
        Reporter.log("Closing the browser");
        driver.close();
    }
}
