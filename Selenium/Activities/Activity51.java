package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity51 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Title: " + driver.getTitle());
        System.out.println(driver.findElement(By.name("toggled")).isDisplayed());
        driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println(driver.findElement(By.name("toggled")).isDisplayed());
        driver.close();
    }
}
