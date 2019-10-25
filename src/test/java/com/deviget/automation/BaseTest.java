package com.deviget.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public  class BaseTest  {

    //Declare a test URL variable

    public WebDriver driver;

    @BeforeTest
    public void setupTestEnvironment(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDownTest(){
        driver.quit();
    }

}
