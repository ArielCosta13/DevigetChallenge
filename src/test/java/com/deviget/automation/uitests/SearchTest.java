package com.deviget.automation.uitests;

import com.deviget.automation.BaseTest;
import com.deviget.automation.pages.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void iPhoneSearch() throws InterruptedException {
        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        mainPage.closeAd();
        mainPage.fillSearchField("IPhone").clickOnSearchButton();
        List<String> itemslist1 = mainPage.getSearchResultItemList();
        Assert.assertTrue(itemslist1.get(2).toLowerCase().contains("iphone"));
        mainPage.clickOnPage(driver,"2");
        Assert.assertTrue(getCurrentUrl().contains("page=2"));
        List<String> itemslist2 = mainPage.getSearchResultItemList();
        Assert.assertNotNull(itemslist2.get(2));
        Assert.assertTrue(itemslist2.get(2).toLowerCase().contains("iphone"));
        Assert.assertNotEquals(itemslist2.get(2),itemslist1.get(2));
    }
}
