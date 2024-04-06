package com.thetestingacademy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverManager {
    public static WebDriver driver;


    public static WebDriver getDriver() {
        return driver;
    }

    public static void init() {
        if (driver == null) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--start-maximized");
            edgeOptions.addArguments("--guest");
//            edgeOptions.addArguments("--headless");
            driver = new EdgeDriver(edgeOptions);
        }
    }


    public static void down() {
        if (driver != null) {  // ! =
            driver.quit();
            driver = null;
        }
    }


}
