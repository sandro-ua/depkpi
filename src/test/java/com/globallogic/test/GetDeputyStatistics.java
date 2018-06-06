package com.globallogic.test;

import com.globallogic.Deputy;
import com.globallogic.framework.MyWebDriver;
import com.globallogic.framework.SearchDeputiesPage;
import com.globallogic.framework.TestConstants;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetDeputyStatistics {

/*    @BeforeClass(alwaysRun = true)
    public static void Setup() {
        MyWebDriver.Initialize();
    }*/

    @Test
    @Ignore
    public void FirstTest() throws InterruptedException {
      MyWebDriver.Initialize();
        SearchDeputiesPage.GoToDeputyList();

        String SearchResultMessage = String.valueOf(MyWebDriver.Instance
                .findElement(By.xpath(TestConstants.XPATH_SEARCH_RESULTS_MESSAGE)).getText()).replaceAll("\\D+", "");
        int depTotalNumber = Integer.parseInt(SearchResultMessage);

        String[] deputiesNames = new String[depTotalNumber];
        String[] deputiesProfileLinks = new String[depTotalNumber];

        for (int j = 0; j < depTotalNumber; j++) {
            deputiesNames[j] = String.valueOf(MyWebDriver.Instance
                    .findElement(By.xpath(String.format(TestConstants.XPATH_DEPUTIES_NAMES, Integer.toString(j+1)))).getText());
            deputiesProfileLinks[j] = String.valueOf(MyWebDriver
                    .Instance.findElement(By.xpath(String.format(TestConstants.XPATH_DEPUTIES_PROFILE_LINKS, Integer.toString(j+1)))).getAttribute("href"));
        }

        Deputy[] allDeputies = new Deputy[depTotalNumber];
        for (int n = 0; n < depTotalNumber; n++) {

            MyWebDriver.Instance.get(deputiesProfileLinks[n]);
            MyWebDriver.Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            allDeputies[n] = new Deputy();
            allDeputies[n].setFullName(MyWebDriver.Instance.findElement(By.xpath(TestConstants.XPATH_FULL_NAME)).getText());
            allDeputies[n].setLinkToProfile(deputiesProfileLinks[n]);
            MyWebDriver.Instance.findElement(By.xpath(TestConstants.XPATH_PRESENCE)).click();
            MyWebDriver.Instance.findElement(By.className(TestConstants.XPATH_SEARCH_BUTTON)).click();
            MyWebDriver.Instance.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //resolving StaleElementReferenceException
            Wait newWait = new WebDriverWait(MyWebDriver.Instance, 10);
            newWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s0")));
            MyWebDriver.Instance.findElement(By.id("s0")).click();
            MyWebDriver.Instance.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            List<WebElement> listPresence = MyWebDriver.Instance.findElements(By.xpath(TestConstants.XPATH_PRESENCE_NUM));
            if (listPresence != null && !listPresence.isEmpty()) {
                allDeputies[n].setPresent(Integer.valueOf(listPresence.get(0).getText()));
            }

            List<WebElement> listAbsence = MyWebDriver.Instance.findElements(By.xpath(TestConstants.XPATH_ABSENCE_NUM));
            if (listAbsence != null && !listAbsence.isEmpty()) {
                allDeputies[n].setAbsent(Integer.valueOf(listAbsence.get(0).getText()));
            }

            MyWebDriver.Instance.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        System.out.println(Arrays.toString(deputiesNames));

    }

/*    @AfterClass(alwaysRun = true)
    public static void TearDown()
    {
        MyWebDriver.Instance.quit();
    }*/
}
