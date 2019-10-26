package com.deviget.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public  class BaseTest  {

    //Declare a test URL variable

    public WebDriver driver;

    @Parameters( {"baseurl","browser"})
    @BeforeTest
    public void setupTestEnvironment(String baseUrl, String browser){
        selectBrowser(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(baseUrl);
    }

    private void selectBrowser(String browser){
        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")){
            System.setProperty("webdriver.chrome.driver","./src/test/resources/geckodriver/geckodriver");
            driver = new ChromeDriver();
        }else{
            System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver");
            driver = new ChromeDriver();
        }

    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected void updateAndReportStatus(String newStatus) {
        System.out.println( newStatus );
    }

    @AfterTest
    public void tearDownTest(){
        driver.quit();
    }

}
