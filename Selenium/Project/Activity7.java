package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity7 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void jobCreation() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//div[contains(@class,'main-navigation')]/ul/li[3]/a")).click();
        driver.findElement(By.id("create_account_email")).sendKeys("kanjalimanasa1@gmail.com");
        driver.findElement(By.id("job_title")).sendKeys("Full Stack TesterI");
        driver.findElement(By.id("job_location")).sendKeys("Bangalore");
        Select jobtype = new Select(driver.findElement(By.id("job_type")));
        jobtype.selectByVisibleText("Full Time");
        driver.switchTo().frame("job_description_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("To test the application");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("application")).sendKeys("kanjalimanasa1@gmail.com");
        driver.findElement(By.id("company_name")).sendKeys("IBM");
        driver.findElement(By.name("submit_job")).click();
        driver.findElement(By.id("job_preview_submit_button")).click();
    }
    @Test
    public void searchJob(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.findElement(By.xpath("//div[contains(@class,'main-navigation')]/ul/li[1]/a")).click();
        driver.findElement(By.id("search_keywords")).sendKeys("Full Stack TesterI");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        WebElement searchResults = driver.findElement(By.xpath("//ul[contains(@class,'job_listings')]/li/a"));
        wait.until(ExpectedConditions.visibilityOf(searchResults));
        String jobtitle = driver.findElement(By.xpath("//ul[contains(@class,'job_listings')]/li/a/div/h3")).getText();
        System.out.println(jobtitle);
        Assert.assertEquals(jobtitle,"Full Stack TesterI");
        System.out.println("Job Search Successful");
    }
    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}
