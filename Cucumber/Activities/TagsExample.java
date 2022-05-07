package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TagsExample extends BaseClass{
    @Given("^User is on TS home page$")
    public void openTSHomePage(){
        driver.get("https://training-support.net");
    }

    @When("^User clicks About Us button$")
    public void clickAboutUsButton(){
        driver.findElement(By.id("about-link")).click();
    }

    @Then("^About Us page should open$")
    public void verifyAboutUsPage(){
        String element = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(element, "About Us");
    }
}
