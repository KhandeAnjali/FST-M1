package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void secondHeaderValidation(){
        String header = driver.findElement(By.xpath("//h2")).getText();
        Reporter.log(header);
        Assert.assertEquals(header,"Quia quis non");
        Reporter.log("Header validation is completed");
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}
