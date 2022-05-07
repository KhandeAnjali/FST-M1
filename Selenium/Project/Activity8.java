package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }
    @Test
    public void login(){
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys(" pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        //String title = driver.getTitle();
        String user = driver.findElement(By.xpath("//span[contains(@class,'display-name')]")).getText();
        //Assert.assertEquals(title, "Dashboard ‹ Alchemy Jobs — WordPress");
        Assert.assertEquals(user,"root");
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }

}
