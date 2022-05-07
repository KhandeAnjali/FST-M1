package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity41 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.xpath("//a[@id=\"about-link\"]")).click();
        System.out.println("New Page Title: " + driver.getTitle());
        driver.close();
    }
}
