package com.deviget.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.*;

public class MainPage extends BasePage{

    @FindBy(how = How.CSS, using = ".ui-window-content")
    private WebElement ad;

    @FindBy(how = How.CSS, using = ".close-layer")
    private WebElement adClose;

    @FindBy(how = How.CSS, using = "#search-key")
    private WebElement searchField;

    @FindBy(how = How.CSS, using =  ".search-button")
    private WebElement searchButton;

    @FindBy(how = How.CSS, using =  ".list-item")
    private List<WebElement> itemList;

    public MainPage fillSearchField(String itemToSearch){
        updateAndReportStatusPageAction("Filling Search field with: " + itemToSearch);
        searchField.sendKeys(itemToSearch);
        return this;
    }

    public MainPage clickOnSearchButton(){
        updateAndReportStatusPageAction("Clicking on search Button");
        searchButton.click();
        return this;
    }

    public List<String> getSearchResultItemList(){
        List<String> items = new ArrayList<String>();
        for(WebElement item : itemList){
            items.add(item.getText());
        }
        return items;
    }

    public MainPage clickOnPage(WebDriver driver, String number) throws InterruptedException {
        updateAndReportStatusPageAction("Clicking on search result page " + number );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", itemList.get(itemList.size()-1));
        driver.findElement(By.xpath("//button[.='" + number + "']")).click();
        sleep(5000);
        return this;
    }

    public MainPage closeAd(){
        try{
            if (ad.isDisplayed()){
                adClose.click();
            }
            updateAndReportStatusPageAction("Ad closed");
        }catch (Exception e){
            updateAndReportStatusPageInformation("No Ad was displayed");
        }
       return this;
    }

}
