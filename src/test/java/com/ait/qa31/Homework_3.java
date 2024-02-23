package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework_3 {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCssSelectorTest() {

        driver.findElement(By.cssSelector("#dialog-notifications-success"));
        driver.findElement(By.cssSelector("#bar-notification"));
        driver.findElement(By.cssSelector(".ajax-loading-block-window"));
        driver.findElement(By.cssSelector(".master-wrapper-content"));
        driver.findElement(By.cssSelector("head title"));
        driver.findElement(By.cssSelector("link[href='/Plugins/Widgets.NivoSlider/Content/nivoslider/nivo-slider.css']"));

    }


        @Test
        public void findElementByXpath() {

            driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));
            driver.findElement(By.xpath("//*[@id='bar-notification']"));
            driver.findElement(By.xpath("//*[@class='ajax-loading-block-window']"));
            driver.findElement(By.xpath("//*[@class='master-wrapper-content']"));
            driver.findElement(By.xpath("//head/title"));
            driver.findElement(By.xpath("//link[@href='/Plugins/Widgets.NivoSlider/Content/nivoslider/nivo-slider.css']"));
            driver.findElement(By.xpath("//*[contains(text(),'Register')]"));

        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
    }

