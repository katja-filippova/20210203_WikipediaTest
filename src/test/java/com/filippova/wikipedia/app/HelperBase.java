package com.filippova.wikipedia.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {

    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            if (!text.equals(driver.findElement(locator).getText())) {
                tap(locator);
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void swipeToLeft(By locator) {

        TouchAction action = new TouchAction(driver);

        WebElement element = waitForElement(locator, 10);

        int leftX = (int) (element.getLocation().getX() * 0.3);
        int rightX = (int) (leftX + element.getSize().getWidth() * 0.8);
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        action.longPress(PointOption.point(rightX, middleY))
                //.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(leftX, middleY))
                .release()
                .perform();


    }

    public WebElement waitForElement(By locator, int timeOut) {
        return new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementAndTap(By locator, int timeOut) {
        new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }
}
