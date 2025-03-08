package com.driverManager;

import org.openqa.selenium.WebDriver;

public class CreateDriver {
    // ThreadLocal to manage WebDriver instances per thread
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    // Volatile keyword ensures visibility of changes to the WebDriverSingleton instance across threads
    private static volatile CreateDriver instance;

    // Private constructor to prevent instantiation
    private CreateDriver() {}

    /**
     * Method to get the singleton instance of WebDriverSingleton.
     * Uses double-checked locking for thread-safe initialization.
     */
    public static CreateDriver getInstance() {
        if (instance == null) { // First check without synchronization for performance
            synchronized (CreateDriver.class) { // Class-level locking for thread safety
                if (instance == null) { // Second check inside synchronized block for proper lazy initialization
                    instance = new CreateDriver(); // Create the singleton instance
                }
            }
        }
        return instance;
    }

    /**
     * Sets the WebDriver instance for the current thread based on the specified browser.
     * If already set, it will return the existing instance.
     */
    public WebDriver getDriver(String browser,boolean isHeadless) {
        if (threadLocalDriver.get() == null) {
            // Call setDriver to create and set a WebDriver instance for the thread
            threadLocalDriver.set(setDriver(browser,isHeadless));
        }
        return threadLocalDriver.get(); // Return the WebDriver instance
    }

    /**
     * Creates and configures a new WebDriver instance based on the specified browser.
     */
    private WebDriver setDriver(String browser,boolean isHeadless) {
        WebDriver driver = DriverManager.getBrowserManager(browser).getDriver(isHeadless);
        driver.manage().window().maximize();
        return driver; // Return the newly created driver
    }

    /**
     * To be passed as an argument to pageObjects inside step definitions
     */
    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    /**
     * Quits the WebDriver for the current thread and removes it from ThreadLocal storage.
     */
    public void quitDriver() {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            driver.quit(); // Quit the WebDriver instance
            threadLocalDriver.remove(); // Remove the WebDriver instance from ThreadLocal
        }
    }
}
