package com.deviget.automation.uitests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {

    @Test
    public void BasicNavigationt(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.aliexpress.com/");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("AliExpress"));
        driver.quit();
    }




}
