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

            System.setProperty("webdriver.chrome.driver", "/resources/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            Instance = new ChromeDriver(chromeOptions);
            Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }
