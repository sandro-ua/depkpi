package com.globallogic.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
    private static String OS = System.getProperty("os.name").toLowerCase();

        public static void Initialize() {

            WebDriverManager.chromedriver().setup();
            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions fOptions = new FirefoxOptions();
            fOptions.setHeadless(true);

            ChromeOptions cOptions = new ChromeOptions();
            cOptions.setHeadless(true);


            if (isUnix()) {
                Instance = new ChromeDriver();
                Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
            if (isWindows()) {
                Instance = new ChromeDriver(cOptions);
                Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }
}
