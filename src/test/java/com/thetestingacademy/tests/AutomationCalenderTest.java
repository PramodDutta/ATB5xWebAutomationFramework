package com.thetestingacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AutomationCalenderTest {

    @Test
    public void testAutomationScenario() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='imageSlideContainer']//span[@class='commonModal__close']")));
        driver.findElement(By.xpath("//div[@class='imageSlideContainer']//span[@class='commonModal__close']")).click();
        driver.findElement(By.xpath("//label[@for='departure']")).click();

        selectDateForTrip("August 2024", "15", driver);
        driver.quit();
    }

    public static void selectDateForTrip(String month_year, String day, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            List<WebElement> months = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='DayPicker-Caption']/div")));

            for (WebElement latestMonth : months) {
                if (latestMonth.getText().equals(month_year)) {
                    List<WebElement> days = driver.findElements(By.xpath("(//div[@class='DayPicker-Caption']/div)[" + (months.indexOf(latestMonth) + 1) + "]/..//following-sibling::div[@class='DayPicker-Body']//div[@class='DayPicker-Day']//p"));

                    for (WebElement date : days) {
                        if (date.getText().equals(day)) {
                            date.click();
                            return;
                        }
                    }
                }
            }
        } catch (StaleElementReferenceException e) {
            // Retry finding the element in case of stale reference
            selectDateForTrip(month_year, day, driver);
        }
    }
}
