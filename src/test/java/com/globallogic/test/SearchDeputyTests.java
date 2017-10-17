package com.globallogic.test;

import com.globallogic.framework.MyWebDriver;
import com.globallogic.framework.SearchDeputiesPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SearchDeputyTests {

    @BeforeClass
    public static void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        MyWebDriver.Initialize();
    }

    @Test(groups = {"sanity"})
    public void SearchResultNumberIsTheSameAsDeclaredDeputyNumber()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals(deputyNumberTop, deputyNumberAtSearch, "Number of deputies are shown incorrect");
    }

    @Test(groups = {"sanity"})
    public void SearchResultNumberIsTheSameAsActuallyDisplayed()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberAtSearch  = SearchDeputiesPage.GetDeclaredDeputiesNumber();
        int actualDeputiesAtSearch = SearchDeputiesPage.SearchResultsBlockCount();

        Assert.assertEquals(deputyNumberAtSearch, actualDeputiesAtSearch, "Search result items number is not the same as declared");
    }



    @AfterClass
    public static void TearDown()
    {
        MyWebDriver.Instance.quit();
    }
}
