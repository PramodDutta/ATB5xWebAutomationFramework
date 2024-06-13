package com.thetestingacademy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

public class DriverManagerTL {

    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static WebDriver getDriver(){
        return dr.get();
    }

    // Unload
    public static void unload(){
        dr.remove();
    }


    public static void init() {
        if (Objects.isNull(DriverManagerTL.getDriver())) {
                //WebDriver driver = new EdgeDriver();
                WebDriver driver = new EdgeDriver();
                setDriver(driver);
        }
    }

    public static void down() {
        if(Objects.nonNull(DriverManagerTL.getDriver())){
            getDriver().quit();
            unload();
        }
    }



}
