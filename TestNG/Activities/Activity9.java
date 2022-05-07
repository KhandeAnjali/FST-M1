package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        Reporter.log("Test execution started");
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened site");
        Reporter.log(driver.getTitle());
    }

    @BeforeMethod
    public void beforeMethod(){
        Reporter.log("TestCase Setup Started");
        driver.switchTo().defaultContent();
    }

    @Test(priority = 1)
    public void simpleAlertTestCase(){
        driver.findElement(By.id("simple")).click();
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched to Simple Alert");
        String sAlertText = simpleAlert.getText();
        Reporter.log(sAlertText);
        Assert.assertEquals(sAlertText,"This is a JavaScript Alert!");
        simpleAlert.accept();
        Reporter.log("Simple Alert closed");
    }

    @Test(priority = 2)
    public void confirmAlertTestCase(){
        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Switched to Confirm Alert");
        String cAlertText = confirmAlert.getText();
        Reporter.log(cAlertText);
        Assert.assertEquals(cAlertText,"This is a JavaScript Confirmation!");
        confirmAlert.accept();
        Reporter.log("Confirm Alert closed");
    }

    @Test(priority = 3)
    public void promptAlertTestCase(){
        driver.findElement(By.id("prompt")).click();
        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched to Prompt Alert");
        String pAlertText = promptAlert.getText();
        Reporter.log(pAlertText);
        promptAlert.sendKeys("Sending Prompt Message");
        Reporter.log("Text entered in the prompt");
        Assert.assertEquals(pAlertText,"This is a JavaScript Prompt!");
        promptAlert.accept();
        Reporter.log("Prompt Alert closed");
    }

    @AfterClass
    public void cleanup(){
        Reporter.log("Ending Test");
        driver.close();
    }
}
