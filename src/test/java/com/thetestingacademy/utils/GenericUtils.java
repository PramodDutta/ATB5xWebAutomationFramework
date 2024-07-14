package com.thetestingacademy.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericUtils {

    public static void segregateAmounts(WebDriver driver, List<WebElement> amountColumnElements,
                                        List<String> amountCredited, List<String> amountDebited) {
        for (WebElement ele : amountColumnElements) {
            String text = ele.getText().trim();
            if (text.startsWith("+")) {
                amountCredited.add(text);
            } else if (text.startsWith("-")) {
                amountDebited.add(text);
            }
        }
    }

    public static String cleanAmountString(String amount) {
        return amount.replace(",", "").replace("USD", "").trim();
    }
}
