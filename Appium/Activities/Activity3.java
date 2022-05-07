package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Activity3 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId","32004e065fa9569f");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset",true);

        URL remoteURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(remoteURL,caps);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void addition(){
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_add").click();
        driver.findElementById("calc_keypad_btn_09").click();
        driver.findElementById("calc_keypad_btn_equal").click();
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        assertEquals(result,"14");
    }
    @Test
    public void subtraction(){
        driver.findElementById("calc_keypad_btn_01").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_sub").click();
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_equal").click();
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        assertEquals(result,"5");
    }
    @Test
    public void multiplication(){
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_mul").click();
        driver.findElementById("calc_keypad_btn_01").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_equal").click();
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        assertEquals(result,"500");
    }
    @Test
    public void division(){
        driver.findElementById("calc_keypad_btn_05").click();
        driver.findElementById("calc_keypad_btn_mul").click();
        driver.findElementById("calc_keypad_btn_01").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_00").click();
        driver.findElementById("calc_keypad_btn_equal").click();
        String result = driver.findElementById("calc_edt_formula").getText();
        System.out.println(result);
        assertEquals(result,"500");
    }

}
