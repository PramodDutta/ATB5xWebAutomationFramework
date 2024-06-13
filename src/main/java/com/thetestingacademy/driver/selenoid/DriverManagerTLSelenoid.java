package com.thetestingacademy.driver.selenoid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class DriverManagerTLSelenoid {

    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    // Unload
    public static void unload() {
        dr.remove();
    }


    public static void init() {
        if (Objects.isNull(DriverManagerTLSelenoid.getDriver())) {
            //WebDriver driver = new EdgeDriver();
            WebDriver driver;
            try {
                ChromeOptions options = new ChromeOptions();
                options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                    put("name", "Test badge...");
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
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            setDriver(driver);
        }
    }

    public static void down() {
        if (Objects.nonNull(DriverManagerTLSelenoid.getDriver())) {
            getDriver().quit();
            unload();
        }
    }


}
