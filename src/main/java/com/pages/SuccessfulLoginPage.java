package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfulLoginPage {

    private final WebDriver driver;

    private static final By SUCCESSFUL_LOGIN_MESSAGE_LOCATOR = By.xpath("//h1[@class='post-title']");
    private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("//a[.='Log out']");
    private static final By PRACTICE_BUTTON_LOCATOR = By.xpath("//a[.='Practice']");

    public SuccessfulLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessfulLoginMessage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESSFUL_LOGIN_MESSAGE_LOCATOR));
        return element.getText();
    }

    public LoginPage logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON_LOCATOR));
        element.click();
        return new LoginPage(driver);
    }

    public PracticePage goToPracticePage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(PRACTICE_BUTTON_LOCATOR));
        element.click();
        return new PracticePage(driver);
    }
}
