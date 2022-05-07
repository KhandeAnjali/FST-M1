package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void secondHeaderValidation(){
        driver.findElement(By.xpath("//div[contains(@class,'main-navigation')]/ul/li[1]/a")).click();
        String title = driver.getTitle();
        Reporter.log(title);
        Assert.assertEquals(title,"Jobs – Alchemy Jobs");
        Reporter.log("Jobs page navigation is done");
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}
