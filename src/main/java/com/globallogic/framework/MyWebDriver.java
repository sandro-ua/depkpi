package com.globallogic.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyWebDriver {

    public static WebDriver Instance;
    public static WebDriver getInstance() {
            return Instance;
        }
    public static void setInstance(WebDriver instance) {
            Instance = instance;
        }

        public static void Initialize() {

            WebDriverManager.chromedriver().setup();

            //System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
            //ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.setBinary("C:\\Users\\mylet\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
            Instance = new ChromeDriver();
            Instance.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

/*         System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");
            Instance = new FirefoxDriver();
            Instance.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);*/
       }


    }
