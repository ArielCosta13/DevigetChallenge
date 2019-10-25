package com.deviget.automation.uitests;

import com.deviget.automation.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void iPhoneSearch(){
        driver.navigate().to("https://www.aliexpress.com/");
        if (driver.findElement(By.cssSelector(".ui-window-content")).isDisplayed()){
            driver.findElement(By.cssSelector(".close-layer")).click();
        }
        driver.findElement(By.cssSelector("#search-key")).sendKeys("IPhone");
        driver.findElement(By.cssSelector(".search-button")).click();

        driver.findElement(By.xpath("//button[.='2']"));
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("AliExpress"));
    }
}
