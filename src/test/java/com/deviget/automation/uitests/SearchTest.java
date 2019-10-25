package com.deviget.automation.uitests;

import com.deviget.automation.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void iPhoneSearch() throws InterruptedException {
        if (driver.findElement(By.cssSelector(".ui-window-content")).isDisplayed()){
            driver.findElement(By.cssSelector(".close-layer")).click();
        }
        driver.findElement(By.cssSelector("#search-key")).sendKeys("IPhone");
        driver.findElement(By.cssSelector(".search-button")).click();

        List<WebElement> itemlist= driver.findElements(By.cssSelector(".list-item"));
        System.out.println(itemlist.size());
        String list1Item2 = itemlist.get(2).getText();
        System.out.println(list1Item2);
        Assert.assertTrue(list1Item2.toLowerCase().contains("iphone"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", itemlist.get(itemlist.size()-1));
        driver.findElement(By.xpath("//button[.='2']")).click();
        Thread.sleep(5000);

        List<WebElement> itemlist2= driver.findElements(By.cssSelector(".list-item"));
        System.out.println(itemlist2.size());
        System.out.println(itemlist2.get(2).getText());
        Assert.assertTrue(itemlist2.get(2).getText().toLowerCase().contains("iphone"));
        Assert.assertNotEquals(list1Item2,itemlist2.get(2).getText());
    }
}
