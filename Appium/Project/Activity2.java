package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId","32004e065fa9569f");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.google.android.keep");
        caps.setCapability("appActivity",".activities.BrowseActivity");
        caps.setCapability("noReset",true);

        URL remoteURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(remoteURL,caps);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void googleKeep(){
        driver.findElementById("new_note_button").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("browse_note_interior_content")));
        driver.findElementById("browse_note_interior_content").click();
        driver.findElementById("editable_title").sendKeys("First Google Keep Note");
        driver.findElementById("edit_note_text").sendKeys("Track your time");
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
        String text = driver.findElementById("index_note_title").getText();
        System.out.println(text);
        Assert.assertEquals(text,"First Google Keep Note");
    }
    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
