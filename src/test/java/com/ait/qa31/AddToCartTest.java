package com.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        Assert.assertTrue(isElementPresent(By.xpath("//*[contains(text(), '" + productName + "')]")), "Product '" + productName + "' is not found in the cart");
    }

    @DataProvider
    public Iterator<Object[]> addContactFromCSV() {
        List<Object[]> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contact.csv"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{
                        new User()
                                .setGender(split[0])
                                .setFirstName(split[1])
                                .setLastName(split[2])
                                .setEmail(split[3])
                                .setPassword(split[4])
                                .setConfirmPassword(split[5])
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list.iterator();
    }



    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.close();
    }
}

