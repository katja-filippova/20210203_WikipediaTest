package com.filippova.wikipedia.app;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.Optional;

public class ArticleHelper extends HelperBase{
    public ArticleHelper(AppiumDriver driver) {
        super(driver);
    }

    public void doTextSearchWithGivenTerm(String termToSearch){
        tap(By.id("search_container"));
        driver.findElement(By.id("search_src_text")).sendKeys(termToSearch);
        waitForElementAndTap(By.id("page_list_item_container"),15);
    }

    public void addToFavourites() {
        addToFavourites(null);
    }

    public void addToFavourites(String listName) {
        tap(By.xpath("//android.widget.ImageView[@content-desc=\"Add this article to a reading list\"]"));
        tap(By.id("org.wikipedia:id/onboarding_button"));
        if (listName != null) {
            By listNameLocator = By.id("text_input");
            putTextInInput(listNameLocator, listName);
        }
    }

    public void putTextInInput(By inputLocator, String text) {
        Optional.ofNullable(text).ifPresent(value -> {
            driver.findElement(inputLocator).clear();
            driver.findElement(inputLocator).sendKeys(text);
        });
    }

    public void createReadingList() {
        tap(By.id("android:id/button1"));
    }

    public void closeTheCurrentArticle() {
        tap(By.xpath("//*[@content-desc='Navigate up']"));
    }

    public void removeFromFavourites() {
        tap(By.id("org.wikipedia:id/page_list_item_action_primary"));
        tap(By.id("org.wikipedia:id/reading_list_item_remove"));
    }

    public void removeFromFavouritesWithSwipe() {
        swipeToLeft(By.id("page_list_item_container"));
    }
}
