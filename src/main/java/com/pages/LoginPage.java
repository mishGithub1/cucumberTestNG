package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;

    private final By username_locator = By.id("username");
    private final By password_locator = By.id("password");
    private final By submit_button_locator = By.xpath("//button[@id='submit']");
    private final By error_message_locator = By.xpath("//div[@id='error']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public SuccessfulLoginPage SuccessfulLoginToPracticeAutomation(String username,String password){
        driver.findElement(username_locator).sendKeys(username);
        driver.findElement(password_locator).sendKeys(password);
        driver.findElement(submit_button_locator).click();

        return new SuccessfulLoginPage(driver);
    }

    public LoginPage UnsuccessfulLoginToPracticeAutomation(String username,String password){
        driver.findElement(username_locator).sendKeys(username);
        driver.findElement(password_locator).sendKeys(password);
        driver.findElement(submit_button_locator).click();
        return new LoginPage(driver);
    }

    public String getErrorMessage(){
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(error_message_locator));
        return element.getText();
    }

}
