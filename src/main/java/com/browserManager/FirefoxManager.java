package com.browserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxManager implements BrowserManager{
    @Override
    public WebDriver getDriver(boolean isHeadless) {
        FirefoxOptions options = new FirefoxOptions();

        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new FirefoxDriver(options);
    }
}
