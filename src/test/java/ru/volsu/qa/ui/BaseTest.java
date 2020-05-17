package ru.volsu.qa.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import ru.volsu.qa.config.AppConfig;
import ru.volsu.qa.config.deprecated.Config;
import ru.volsu.qa.config.deprecated.ConfigLoader;
import ru.volsu.qa.listeners.FailuresListener;

@Listeners({FailuresListener.class})
@ContextConfiguration( classes = AppConfig.class )
public class BaseTest extends AbstractTestNGSpringContextTests{

    @Autowired
    protected WebDriver webdriver;

    @Autowired
    private AppConfig config;

    @BeforeMethod
    public void openBaseUrl() {
        webdriver.get(config.getBaseUrl());
    }

    @AfterSuite
    public void closeBrowser(){}
}
