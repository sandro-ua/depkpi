package com.globallogic.framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
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
            Instance = new ChromeDriver();
            Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }
