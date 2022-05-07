package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }
    @Test
    public void jobCreation(){
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys(" pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.xpath("//li[@id = 'menu-posts-job_listing']/a")).click();
        driver.findElement(By.xpath("//a[contains(@class,'page-title-action')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("post-title-0")).sendKeys("Automation Test Specialist");
        //driver.findElement(By.xpath("//a[contains(text(),'Change')]")).click();
        //driver.findElement(By.id("select2-job_manager_user_search-container")).click();
        driver.findElement(By.name("_company_website")).sendKeys("ibm.com");
        driver.findElement(By.name("_company_twitter")).sendKeys("@ibm");
        driver.findElement(By.id("_job_expires")).sendKeys("April 23, 2022");
        driver.findElement(By.name("_job_location")).sendKeys("India");
        driver.findElement(By.name("_company_name")).sendKeys("IBM");
        driver.findElement(By.name("_company_tagline")).sendKeys("Try Competing Yourself With Us");
        driver.findElement(By.id("_featured")).click();
        //driver.findElement(By.xpath("//div[@id='job_listing_type']/h2")).click();
        //driver.findElement(By.id("in-job_listing_type-2")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[contains(text(),'Publish')]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'components-button editor-post-publish-button')]")).click();
        driver.findElement(By.xpath("//a[contains(@class,'components-button is-secondary')]")).click();
        String title = driver.findElement(By.xpath("//h1[contains(@class,'entry-title')]")).getText();
        Assert.assertEquals(title,"Automation Test Specialist");
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }

}
