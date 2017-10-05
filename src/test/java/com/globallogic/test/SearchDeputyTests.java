package com.globallogic.test;

import com.globallogic.Deputy;
import com.globallogic.framework.MyWebDriver;
import com.globallogic.framework.SearchDeputiesPage;
import com.globallogic.framework.TestConstants;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SearchDeputyTests {



    @BeforeClass
    public static void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        MyWebDriver.Initialize();
    }


    @Test
    @Ignore
    public void FirstTest() throws InterruptedException {

        SearchDeputiesPage.GoToDeputyList();

        String SearchResultMessage = String.valueOf(MyWebDriver.Instance.findElement(By.xpath("//div[@id=\"search_results\"]/p")).getText()).replaceAll("\\D+", "");
        int depTotalNumber = Integer.parseInt(SearchResultMessage);

        String[] deputiesNames = new String[depTotalNumber];
        String[] deputiesProfileLinks = new String[depTotalNumber];

        for (int j = 0; j < depTotalNumber; j++) {
            deputiesNames[j] = String.valueOf(MyWebDriver.Instance.findElement(By.xpath(String.format("//div[@id=\"search_results\"]/ul/li[%s]/p/a", Integer.toString(j+1)))).getText());
            deputiesProfileLinks[j] = String.valueOf(MyWebDriver.Instance.findElement(By.xpath(String.format("//div[@id=\"search_results\"]/ul/li[%s]/p[@class=\"title\"]/a", Integer.toString(j+1)))).getAttribute("href"));
        }

        Deputy[] allDeputies = new Deputy[depTotalNumber];
        for (int n = 0; n < depTotalNumber; n++) {
            MyWebDriver.Instance.get(deputiesProfileLinks[n]);
            MyWebDriver.Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            allDeputies[n] = new Deputy();
            allDeputies[n].setFullName(MyWebDriver.Instance.findElement(By.xpath(TestConstants.XPATH_FULL_NAME)).getText());
            MyWebDriver.Instance.findElement(By.xpath(TestConstants.XPATH_PRESENCE)).click();
            MyWebDriver.Instance.findElement(By.className(TestConstants.XPATH_SEARCH_BUTTON)).click();
            MyWebDriver.Instance.findElement(By.id("s0")).click();
            MyWebDriver.Instance.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


            List<WebElement> list = MyWebDriver.Instance.findElements(By.xpath(TestConstants.XPATH_PRESENCE_NUM));
                if (list != null && !list.isEmpty()) {
                    allDeputies[n].setPresent(Integer.valueOf(list.get(0).getText()));
                }

            List<WebElement> list2 = MyWebDriver.Instance.findElements(By.xpath(TestConstants.XPATH_ABSENCE_NUM));
            if (list2 != null && !list2.isEmpty()) {
                allDeputies[n].setPresent(Integer.valueOf(list2.get(0).getText()));

            }
            else System.out.println("1");

            MyWebDriver.Instance.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }


        System.out.println(deputiesNames);

    }

    @Test
    public void SearchResultNumberIsTheSameAsDeclaredDuputyNumber()
    {
        SearchDeputiesPage.GoToDeputyList();

        String numberMessageTop = MyWebDriver.Instance.findElement(By.xpath("//div[@class=\"information_block_ins\"]/h3/a[@class=\"show_section\"]")).getText();
        int deputyNumberTop = Integer.parseInt(numberMessageTop.split(" ")[2]);

        String numberMessageAtSearch = MyWebDriver.Instance.findElement(By.xpath(TestConstants.XPATH_SEARCH_RESULTS_BLOCK)).getText();
        int deputyNumberAtSearch = Integer.parseInt(numberMessageAtSearch.split(" ")[1]);

        Assert.assertEquals("Number of deputies are shown incorrect", deputyNumberTop, deputyNumberAtSearch);
    }

    @Test
    public void SearchResultNumberIsTheSameAsActuallyDisplayed()
    {
        SearchDeputiesPage.GoToDeputyList();

        int deputyNumberAtSearch  = SearchDeputiesPage.GetDeclaredDeputiesNumber();
        int actualDeputiesAtSearch = MyWebDriver.Instance.findElements(By.xpath(TestConstants.XPATH_SEARCH_RESULTS_BLOCK)).size();

        Assert.assertEquals("Search result items number is not the same as declared", deputyNumberAtSearch, actualDeputiesAtSearch);
    }

/*    @AfterClass
    public static void Teardown()
    {
        MyWebDriver.Instance.quit();
    }*/

}
