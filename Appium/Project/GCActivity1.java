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
import java.time.Duration;

public class GCActivity1 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId","32004e065fa9569f");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.android.chrome");
        caps.setCapability("appActivity","com.google.android.apps.chrome.Main");
        caps.setCapability("noReset",true);

        URL remoteURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(remoteURL,caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void googleChrome() throws InterruptedException {
        driver.get("https://www.training-support.net/selenium");
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        String UiSelector = "UiSelector().className(\"android.widget.EditText\")";
        String xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollIntoView(text(\"To-Do List\"))")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("taskInput")));
        driver.findElement(MobileBy.AndroidUIAutomator(UiSelector)).sendKeys("Add tasks to list");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Add Task\")").click();
        driver.findElement(MobileBy.AndroidUIAutomator(UiSelector)).sendKeys("Get number of tasks");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Add Task\")").click();
        driver.findElement(MobileBy.AndroidUIAutomator(UiSelector)).sendKeys("Clear the list");
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Add Task\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Add tasks to list\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Get number of tasks\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Clear the list\")").click();
        driver.findElementByXPath(xPath).click();
        //String addTasksText = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")").getText();
        //Assert.assertEquals(addTasksText,"Add more tasks to this list.");
    }
    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}