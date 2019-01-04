package com.globallogic.test;

import com.globallogic.framework.MyWebDriver;
import com.globallogic.framework.SearchDeputiesPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SearchDeputyTests {

    @BeforeClass (alwaysRun = true)
    public static void Setup() {
        MyWebDriver.Initialize();
    }

    @Test(groups = {"sanity"})
    public void SearchResultNumberIsTheSameAsDeclaredDeputyNumber()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals(deputyNumberTop, deputyNumberAtSearch, "Number of deputies are shown incorrect.");
    }

    @Test(groups = {"sanity"})
    public void SearchResultNumberIsTheSameAsActuallyDisplayed()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberAtSearch  = SearchDeputiesPage.GetDeclaredDeputiesNumber();
        int actualDeputiesAtSearch = SearchDeputiesPage.SearchResultsBlockCount();

        Assert.assertEquals(deputyNumberAtSearch, actualDeputiesAtSearch, "Search result items number is not the same as declared.");
    }

    @Test (groups = {"search suite"})
    public void GoToTopCount () {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberAtSearch  = SearchDeputiesPage.GetDeclaredDeputiesNumber();
        int GoToTopNumber = SearchDeputiesPage.GetGoToTopLinkCount();

        Assert.assertEquals(deputyNumberAtSearch, GoToTopNumber);
    }

    @Test(groups = {"sanity"})
    public void duplicated_test_1()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals(deputyNumberTop, deputyNumberAtSearch, "Number of deputies are shown is incorrect.");
    }

    @Test(groups = {"sanity"})
    public void duplicated_test_2()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals(deputyNumberTop, deputyNumberAtSearch, "Number of deputies are shown is incorrect.");
    }

    @Test(groups = {"sanity"})
    public void duplicated_test_3()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals(deputyNumberTop, deputyNumberAtSearch, "Number of deputies are shown is incorrect.");
    }

    @Test(groups = {"sanity"})
    public void duplicated_test_4()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals(deputyNumberTop, deputyNumberAtSearch, "Number of deputies are shown is incorrect.");
    }

    @Test(groups = {"sanity"})
    public void duplicated_test_5()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertEquals(deputyNumberTop, deputyNumberAtSearch, "Number of deputies are shown is incorrect.");
    }

    @Test(groups = {"sanity"})
    public void duplicated_test_6_Negative()
    {
        SearchDeputiesPage.GoToDeputyList();
        int deputyNumberTop = SearchDeputiesPage.GetSearchResultsNumber();
        int deputyNumberAtSearch = SearchDeputiesPage.GetSearchResultsNumber();

        Assert.assertNotEquals(deputyNumberTop, deputyNumberAtSearch, "Number of deputies are shown is incorrect.");
    }

    @AfterClass (alwaysRun = true)
    public static void TearDown()
    {
        MyWebDriver.Instance.quit();
    }
}
