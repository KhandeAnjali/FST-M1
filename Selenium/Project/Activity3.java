package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        Reporter.log("Test Execution Started");
        driver.get("https://alchemy.hguy.co/jobs/");
        Reporter.log("Opened Site");
    }
    @Test
    public void imageURL(){
        WebElement image = driver.findElement(By.xpath("//img"));
        String imageURL = image.getAttribute("src");
        Reporter.log(imageURL);
        Reporter.log("Image URL is retrieved");
    }

    @AfterClass
    public void cleanUp(){
        Reporter.log("Closing the browser");
        driver.close();
    }
}
