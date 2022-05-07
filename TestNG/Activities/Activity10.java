package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity10 {
    WebDriver driver;
    Actions builder;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        builder = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/sliders");
    }

    @Test(priority = 1)
    public void midValue(){
        WebElement slider = driver.findElement(By.id("slider"));
        slider.click();
        String value = driver.findElement(By.id("value")).getText();
        System.out.println(value);
        Reporter.log("Middle Value:" + value);
        Assert.assertEquals(value,"50");
    }
    @Test(priority = 2)
    public void maxValue(){
        WebElement slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(40,0).release().build().perform();
        String value = driver.findElement(By.id("value")).getText();
        System.out.println(value);
        //Reporter.log("Max Value:" + value);
        //Assert.assertEquals(value,"50");

    }
    @Test
    public void minValue(){

    }
    @Test
    public void thirtyPerValue(){

    }
    @Test
    public void eightyPerValue(){

    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}
