package com.globallogic.test;

import com.globallogic.framework.MyWebDriver;
import com.globallogic.framework.SearchDeputiesPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class SearchDeputyTests {

    @BeforeClass()
    public static void Setup() {
        MyWebDriver.Initialize();
    }

    @Test()
    public void SearchResultNumberIsTheSameAsDeclaredDeputyNumber()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals("Number of deputies are shown incorrect.", deputyNumberTop, deputyNumberAtSearch);
    }

    @Test()
    public void SearchResultNumberIsTheSameAsActuallyDisplayed()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberAtSearch  = SearchDeputiesPage.GetDeclaredDeputiesNumber();
        int actualDeputiesAtSearch = SearchDeputiesPage.SearchResultsBlockCount();

        Assert.assertEquals("Search result items number is not the same as declared.", deputyNumberAtSearch, actualDeputiesAtSearch);
    }

    @Test ()
    public void GoToTopCount () {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberAtSearch  = SearchDeputiesPage.GetDeclaredDeputiesNumber();
        int GoToTopNumber = SearchDeputiesPage.GetGoToTopLinkCount();

        Assert.assertEquals(deputyNumberAtSearch, GoToTopNumber);
    }

    @Test()
    public void duplicated_test_1()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals("Number of deputies are shown is incorrect.", deputyNumberTop, deputyNumberAtSearch);
    }

    @Test()
    public void duplicated_test_2()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals("Number of deputies are shown is incorrect.", deputyNumberTop, deputyNumberAtSearch);
    }

    @Test()
    public void duplicated_test_3()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals("Number of deputies are shown is incorrect.", deputyNumberTop, deputyNumberAtSearch);
    }

    @Test()
    public void duplicated_test_4()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals("Number of deputies are shown is incorrect.", deputyNumberTop, deputyNumberAtSearch);
    }

    @Test()
    public void duplicated_test_5()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals("Number of deputies are shown is incorrect.", deputyNumberTop, deputyNumberAtSearch);
    }

    @Test()
    public void duplicated_test_6_Negative()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertNotEquals("Number of deputies are shown is incorrect.", deputyNumberTop, deputyNumberAtSearch );
    }

    @AfterClass()
    public static void TearDown()
    {
        MyWebDriver.Instance.quit();
    }
}
