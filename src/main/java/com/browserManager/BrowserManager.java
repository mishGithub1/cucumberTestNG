package com.browserManager;

import org.openqa.selenium.WebDriver;

public interface BrowserManager {
    WebDriver getDriver(boolean isHeadless);
}
