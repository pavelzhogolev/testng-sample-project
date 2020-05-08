package ru.volsu.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.volsu.qa.ec.PageLoaded;

import java.util.concurrent.TimeUnit;

public class UITests {

    private static final String ERROR_MESSAGE = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

    private ChromeDriver webdriver;

    @BeforeClass
    public void initBrowser() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webdriver = new ChromeDriver(options);

        //webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void openUrlTest() {
        webdriver.get("http://automationpractice.com/");
    }

    @Test
    public void verifyPageTitleTest() {
        webdriver.get("http://automationpractice.com/");
        String pageTitle = webdriver.getTitle();

        Assert.assertEquals(pageTitle, "My Store");
    }

    @Test
    public void createExistingUserNegativeTest() {
        webdriver.get("http://automationpractice.com/");

        WebDriverWait wait = new WebDriverWait( webdriver, 60 );

        webdriver.findElement(By.cssSelector(".login")).click();

        wait.until(new PageLoaded());

        webdriver.findElement(By.id("email_create")).sendKeys("john.doe@yahoo.com");
        webdriver.findElement(By.id("SubmitCreate")).click();

        WebElement errorAlert = webdriver.findElement(By.id("create_account_error"));

        wait.until(ExpectedConditions.visibilityOfAllElements(errorAlert));
        String errorMessage = errorAlert.getText();

        Assert.assertEquals(errorMessage, ERROR_MESSAGE);
    }

    @AfterClass
    public void closeBrowser(){
        webdriver.quit();
    }
}
