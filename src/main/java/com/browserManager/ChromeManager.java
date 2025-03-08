package com.browserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeManager implements BrowserManager{

    @Override
    public WebDriver getDriver(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();

        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new ChromeDriver(options);
    }
}
