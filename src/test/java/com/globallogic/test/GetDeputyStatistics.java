package com.globallogic.test;

import com.globallogic.Deputy;
import com.globallogic.framework.MyWebDriver;
import com.globallogic.framework.SearchDeputiesPage;
import com.globallogic.framework.TestConstants;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetDeputyStatistics {

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
            else System.out.println("---==");

            MyWebDriver.Instance.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        System.out.println(Arrays.toString(deputiesNames));

    }
}
