package com.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @BeforeMethod
    public void login() {
        if (!isElementPresent(By.cssSelector(".ico-logout"))) {

            driver.findElement(By.cssSelector(".ico-login")).click();
            driver.findElement(By.id("Email")).sendKeys("bell@gm.com");
            driver.findElement(By.id("Password")).sendKeys("Bell007$");
            driver.findElement(By.cssSelector("input[value='Log in']")).click();
        }
    }

    @Test
    public void addToCartTest() {

        String productName = "14.1-inch Laptop";

        if (isElementPresent(By.cssSelector(".cart .product-name"))) {
            driver.findElement(By.cssSelector(".header-logo")).click();
        }

        driver.findElement(By.linkText(productName)).click();

        driver.findElement(By.cssSelector(".add-to-cart-button")).click();


        driver.findElement(By.cssSelector(".ico-cart")).click();


        //Assert.assertTrue(isElementPresent(By.cssSelector(".cart .product-name")));
        Assert.assertTrue(isElementPresent(By.xpath("//*[contains(text(), '" + productName + "')]")), "Product '" + productName + "' is not found in the cart");

    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.close();
    }
}