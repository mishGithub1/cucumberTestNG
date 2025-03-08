package com.driverManager;

import com.browserManager.BrowserManager;
import com.browserManager.ChromeManager;
import com.browserManager.EdgeManager;
import com.browserManager.FirefoxManager;

public class DriverManager {

    public static BrowserManager getBrowserManager(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                return new ChromeManager();
            case "firefox":
                return new FirefoxManager();
            case "edge":
                return new EdgeManager();
            default:
                throw new IllegalArgumentException(browser+" is invalid browser");
        }
    }
}
