package com.thetestingacademy.driver.selenoid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverManagerSelenoid {
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
            //driver = new EdgeDriver(edgeOptions);
            try {
                ChromeOptions options = new ChromeOptions();
                options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                    put("name", "VWO Login Testcases");
                    put("sessionTimeout", "15m");
                    put("env", new ArrayList<String>() {{
                        add("TZ=UTC");
                    }});
                    put("labels", new HashMap<String, Object>() {{
                        put("manual", "true");
                    }});
                    put("enableVideo", true);
                    put("enableVNC ", true);
                }});
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                driver.manage().window().maximize();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

        }
    }


    public static void down() {
        if (driver != null) {  // ! =
            driver.quit();
            driver = null;
        }
    }


}
