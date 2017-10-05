package com.globallogic.test;

import com.globallogic.framework.MyWebDriver;
import com.globallogic.framework.SearchDeputiesPage;
import org.junit.*;

public class SearchDeputyTests {

    @BeforeClass
    public static void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        MyWebDriver.Initialize();
    }

    @Test
    public void SearchResultNumberIsTheSameAsDeclaredDeputyNumber()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals("Number of deputies are shown incorrect", deputyNumberTop, deputyNumberAtSearch);
    }

    @Test
    public void SearchResultNumberIsTheSameAsActuallyDisplayed()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberAtSearch  = SearchDeputiesPage.GetDeclaredDeputiesNumber();
        int actualDeputiesAtSearch = SearchDeputiesPage.SearchResultsBlockCount();

        Assert.assertEquals("Search result items number is not the same as declared", deputyNumberAtSearch, actualDeputiesAtSearch);
    }

    @AfterClass
    public static void TearDown()
    {
        MyWebDriver.Instance.quit();
    }
}
