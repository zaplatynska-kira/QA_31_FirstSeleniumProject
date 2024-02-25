  package com.ait.qa31;

  import org.openqa.selenium.Alert;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.support.ui.ExpectedConditions;
  import org.openqa.selenium.support.ui.WebDriverWait;
  import org.testng.Assert;
  import org.testng.annotations.Test;

  import java.time.Duration;

  public class CreateAccountTests extends TestBase {

      @Test
      public void createNewAccountPositiveTest() {
          WebElement registrationSection = driver.findElement(By.xpath("//*[contains(text(),'Your Personal Details')]"));

          driver.findElement(By.cssSelector(".gender")).click();
          driver.findElement(By.name("FirstName")).sendKeys("Karina");
          driver.findElement(By.name("LastName")).sendKeys("Bell");
          driver.findElement(By.name("Email")).sendKeys("bell@gm.com");
          driver.findElement(By.name("Password")).sendKeys("Bell007$");
          driver.findElement(By.name("ConfirmPassword")).sendKeys("Bell007$");

          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
          WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("button-1")));
          registerButton.click();

          Assert.assertTrue(isAlertAppears());
      }

      public boolean isAlertAppears() {
          Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15))
                  .until(ExpectedConditions.alertIsPresent());
          if (alert == null) {
              return false;
          } else {
              return true;
          }
      }
  }


