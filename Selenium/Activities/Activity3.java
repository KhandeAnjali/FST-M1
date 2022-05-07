package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println("Title: "+ driver.getTitle());
        driver.findElement(By.id("firstName")).sendKeys("Khande");
        driver.findElement(By.id("lastName")).sendKeys("Anjali");
        driver.findElement(By.id("email")).sendKeys("kanjalimanasa@gmail.com");
        driver.findElement(By.id("number")).sendKeys("1234567897");
        driver.findElement(By.xpath("//textarea")).sendKeys("Welcome Anju");
        driver.findElement(By.xpath("//input[@value=\"submit\"]")).submit();
        System.out.println("Submitted the form successfully");
        driver.close();
    }
}
