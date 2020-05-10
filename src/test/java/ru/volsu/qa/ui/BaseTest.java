package ru.volsu.qa.ui;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ChromeDriver webdriver;

    @BeforeMethod
    public void initBrowser() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webdriver = new ChromeDriver(options);

        webdriver.get("http://automationpractice.com/");
    }

    @AfterMethod
    public void closeBrowser(){
        webdriver.quit();
    }
}
