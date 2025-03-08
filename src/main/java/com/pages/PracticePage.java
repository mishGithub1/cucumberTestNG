package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticePage {

    private final WebDriver driver;

    private static final By PRACTICE_PAGE_TITLE = By.xpath("//*[@class='post-title']");

    public PracticePage(WebDriver driver){
        this.driver = driver;
    }

    public String getPracticePageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(PRACTICE_PAGE_TITLE));
        return element.getText();
    }


}
