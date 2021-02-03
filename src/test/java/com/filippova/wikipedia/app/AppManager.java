package com.filippova.wikipedia.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppManager {
    AppiumDriver driver;
    DesiredCapabilities caps;

    ArticleHelper article;
    NavigationHelper navigation;

    public void init() throws MalformedURLException {
        caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "Pixel_4_API_29");
        caps.setCapability("automationName", "Appium");
        caps.setCapability("appPackage", "org.wikipedia");
        caps.setCapability("appActivity", ".main.MainActivity");
        caps.setCapability("app", "C://Dev/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.01:4723/wd/hub"), caps);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        article = new ArticleHelper(driver);
        navigation = new NavigationHelper(driver);
    }
    public NavigationHelper navigation() {
        return navigation;
    }
    public ArticleHelper article() {
        return article;
    }

    public String getAppVersion() {
        return driver.findElement(By.id("app_version_res")).getText();
    }

//    public void stop() {
//        driver.quit();
//    }
}
