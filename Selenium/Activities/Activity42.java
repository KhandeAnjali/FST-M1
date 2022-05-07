package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity42 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println("Title: "+ driver.getTitle());
        driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("Khande");
        driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("Anjali");
        driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("kanjalimanasa@gmail.com");
        driver.findElement(By.xpath("//input[@type=\"tel\"]")).sendKeys("1234567897");
        driver.findElement(By.xpath("//textarea")).sendKeys("Welcome Anju");
        driver.findElement(By.xpath("//input[@value=\"submit\"]")).submit();
        System.out.println("Submitted the form successfully");
        driver.close();
    }
}
