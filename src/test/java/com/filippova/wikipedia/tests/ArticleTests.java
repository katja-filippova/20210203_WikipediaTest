package com.filippova.wikipedia.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArticleTests extends TestBase {
    @Test
    public void testAddArticleToFavorites() {
        app.article().doTextSearchWithGivenTerm("Abba");
        app.article().addToFavourites();
        app.article().createReadingList();
        app.article().close();
        app.navigation().favourites();
        Assert.assertTrue(app.article().isElementPresent(By.id("page_list_item_container")));
    }

    @Test
    public void testAddArticleToFavoritesWithChangingListNameAndRemove() {
        app.article().doTextSearchWithGivenTerm("Scooter");
        app.article().addToFavourites("My list");
        app.article().createReadingList();
        app.article().close();
        app.navigation().favourites();
        app.article().removeFromFavourites();
        Assert.assertTrue(app.article().isElementPresent(By.id("reading_list_empty_text")));
    }

    @Test
    public void testAddArticleToFavoritesAndRemoveWithSwipe() {
        app.article().doTextSearchWithGivenTerm("Metallica");
        app.article().addToFavourites();
        app.article().createReadingList();
        app.article().close();
        app.navigation().favourites();
        app.article().removeFromFavouritesWithSwipe();
        Assert.assertTrue(app.article().isElementPresent(By.id("reading_list_empty_text")));
    }


}
