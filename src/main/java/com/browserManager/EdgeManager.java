package com.browserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeManager implements BrowserManager{
    @Override
    public WebDriver getDriver(boolean isHeadless) {
        EdgeOptions options = new EdgeOptions();

        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new EdgeDriver(options);
    }
}
