package ru.volsu.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.volsu.qa.config.AppConfig;
import ru.volsu.qa.ui.expectedconditions.PageLoaded;
import ru.volsu.qa.config.deprecated.Config;
import ru.volsu.qa.config.deprecated.ConfigLoader;

@Component
public class BasePage {

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected AppConfig config;

    public void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait( webDriver, config.getBaseTimeout() );
        wait.until( new PageLoaded() );
    }

    public void waitForElementDisplayed( By by ) {
        WebDriverWait wait = new WebDriverWait( webDriver, config.getBaseTimeout() );
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
