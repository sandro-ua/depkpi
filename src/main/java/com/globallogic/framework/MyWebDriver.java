package com.globallogic.framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Jenkins\\workspace\\deputykpi_1\\src\\resources");
            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.addArguments("--headless");
            //chromeOptions.setBinary("src/resources/chromedriver.exe");
            Instance = new ChromeDriver(chromeOptions);
            Instance.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
    }
