package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class YourAppClass {

    public void addToCart(String productName) {
        By driver = null;
        if (isElementPresent(By.cssSelector(".cart .product-name"))) {
            driver.findElement((SearchContext) By.cssSelector(".header-logo")).click();
        }

        driver.findElement((SearchContext) By.linkText(productName)).click();
        driver.findElement((SearchContext) By.cssSelector(".add-to-cart-button")).click();
        driver.findElement((SearchContext) By.cssSelector(".ico-cart")).click();
    }

    private boolean isElementPresent(By by) {
        return false;
    }


    public User getContact() {
        return null;
    }
}

