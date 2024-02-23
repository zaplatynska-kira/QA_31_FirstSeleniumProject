package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        // максимизировать браузер до размеров окна
        driver.manage().window().maximize();
        // все элементы на этой странице загрузились перед тем как мы начнем с ними взаимодействовать
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

@Test
    public void findElementByTagName(){
        //ищем элемент по тегу
    WebElement element = driver.findElement(By.tagName("h1"));
    System.out.println(element.getText());

    WebElement element1 = driver.findElement(By.tagName("a"));
    System.out.println(element1.getText());
    // ищем список элементов  by tag
    List<WebElement> elements = driver.findElements(By.tagName("a"));
    System.out.println(elements.size());
}

@Test
public void findElementBySampleLocator(){
        //id
        driver.findElement(By.id("city"));
        //className
    WebElement element = driver.findElement(By.className("navigation-link"));
    System.out.println(element.getText());
    //linkText
    driver.findElement(By.linkText("Let the car work"));
    driver.findElement(By.partialLinkText("work"));
}
@Test
public void findElementByCssSelector(){
        //id=#id
    driver.findElement(By.cssSelector("#city"));
    //className -> .className
    driver.findElement(By.cssSelector(".navigation-link"));
    // any -> [attr='paar']
    driver.findElement(By.cssSelector("[href='/search']"));
}
    @Test
    public void findElementByXpath() {
        //tagName == //tagName
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));
        //id -> //tag[@id='city']
        //driver.findElement(By.id("city"));
        driver.findElement(By.xpath("//*[@id='city']"));
        //className -> //tag[@class='class name']
        // driver.findElement(By.className("navigation-link"));
        driver.findElement(By.xpath("//*[@class='navigation-link']"));
        //any -> //*[@attr='par']
        driver.findElement(By.xpath("//*[@href='/search']"));
        //by text
        driver.findElement(By.xpath("//*[text()='Find your car now!']"));
        driver.findElement(By.xpath("//*[.='Find your car now!']"));
        driver.findElement(By.xpath("//*[contains(.,'your car now!')]"));
    }
@AfterMethod
    public void tearDown(){
        driver.quit();
}
}
