package com.thetestingacademy.tests;

import com.thetestingacademy.utils.GenericUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.thetestingacademy.utils.GenericUtils.cleanAmountString;

public class AutomationChallengeTest2 {

    @Test
    public void testAutomationScenario2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/webtables");
        WebElement element = driver.findElement(By.xpath("(//div[contains(@class,'ReactTable')]//div[@role='row']//div[@class='action-buttons']//span[@title='Edit'])[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("(//div[contains(@class,'ReactTable')]//div[@role='row']//div[@class='action-buttons']//span[@title='Edit'])[3]")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='registration-form-modal']")));
        String actTitle = driver.findElement(By.xpath("//div[@id='registration-form-modal']")).getText();
        Assert.assertEquals(actTitle,"Registration Form");
        String actAge = driver.findElement(By.xpath("//input[@id='age']")).getAttribute("value");
        Assert.assertEquals(actAge,"29");
        String actSalary = driver.findElement(By.xpath("//input[@id='salary']")).getAttribute("value");
        Assert.assertEquals(actSalary,"2000");
        String actDepartment = driver.findElement(By.xpath("//input[@id='department']")).getAttribute("value");
        Assert.assertEquals(actDepartment,"Legal");
        driver.findElement(By.id("submit")).click();
        driver.quit();
    }
}
