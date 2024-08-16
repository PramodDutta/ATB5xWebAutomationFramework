package com.thetestingacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationChallengeTest3 {

    @Test
    public void testAutomationScenario3() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get("https://demoqa.com/modal-dialogs");
        WebElement largeModalButtonElement = driver.findElement(By.id("showLargeModal"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", largeModalButtonElement);
        largeModalButtonElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        String actContent = driver.findElement(By.xpath("//div[@class='modal-content']//p")).getText();
        Assert.assertEquals(actContent,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        driver.quit();
    }
}
