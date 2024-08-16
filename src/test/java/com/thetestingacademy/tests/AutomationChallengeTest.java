package com.thetestingacademy.tests;

import com.thetestingacademy.utils.GenericUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.thetestingacademy.utils.GenericUtils.cleanAmountString;

public class AutomationChallengeTest {

    @Test
    public void testAutomationScenario() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.applitools.com/");
        driver.findElement(By.id("username")).sendKeys("Admin");
        driver.findElement(By.id("password")).sendKeys("Password@123");
        driver.findElement(By.id("log-in")).click();
        Thread.sleep(5000);
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle,"ACME demo app");
        List<WebElement> amountColumnElements = driver.findElements(By.xpath("//table//tbody//tr//td//span[@class='text-success' or @class='text-danger']"));
        List<String> amountCredited = new ArrayList<>();
        List<String> amountDebited = new ArrayList<>();
        for (WebElement ele : amountColumnElements) {
            String text = ele.getText().trim();
            if (text.startsWith("+")) {
                amountCredited.add(cleanAmountString(text.substring(1)));
            } else if (text.startsWith("-")) {
                amountDebited.add(cleanAmountString(text.substring(1)));
            }
        }
        double totalSum = 0.0;

        for (String amount : amountCredited) {
            totalSum += Double.parseDouble(amount);
        }

        for (String amount : amountDebited) {
            totalSum -= Double.parseDouble(amount);
        }
        totalSum = Math.round(totalSum * 100.0) / 100.0;
        Assert.assertEquals(totalSum,1996.22);
        driver.quit();

    }
}
