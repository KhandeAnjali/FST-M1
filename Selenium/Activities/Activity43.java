package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity43 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//h3[contains(@class, 'yellow')]")).getText());
        System.out.println(driver.findElement(By.xpath("//h5[contains(@class, 'green')]")).getCssValue("color"));
        System.out.println(driver.findElement(By.xpath("//button[contains(@class, 'violet')]")).getAttribute("class"));
        System.out.println(driver.findElement(By.xpath("//button[contains(@class, 'grey')]")).getText());
        driver.close();
    }
}
