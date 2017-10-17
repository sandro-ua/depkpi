package com.globallogic.framework;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class SearchDeputiesPage {

    public static void GoToDeputyList () {
        MyWebDriver.Instance.get(TestConstants.LINK_DEPUTAT_LIST);
        MyWebDriver.Instance.findElement(By.id("btnAllMPS")).click();
        MyWebDriver.Instance.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       }

    public static int GetDeclaredDeputiesNumber (){
        String numberMessageAtSearch = MyWebDriver.Instance.findElement(By.xpath(TestConstants.XPATH_DECLARED_DEPUTIES_NUMBER)).getText();
        return Integer.parseInt(numberMessageAtSearch.split(" ")[1]);
        }

    public static int GetSearchResultsNumber (){
        String numberMessageTop = MyWebDriver.Instance.findElement(By.xpath(TestConstants.XPATH_SEARCH_RESULTS_NUMBER)).getText();
        return Integer.parseInt(numberMessageTop.split(" ")[2]);
    }

    public static int SearchResultsBlockCount () {
        return MyWebDriver.Instance.findElements(By.xpath(TestConstants.XPATH_SEARCH_RESULTS_BLOCK)).size();
    }

    public static int GetGoToTopLinkCount () {
        return MyWebDriver.Instance.findElements(By.xpath(TestConstants.XPATH_SEARCH_GO_TO_TOP_)).size();
    }
}
