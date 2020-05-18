package ru.volsu.qa.listeners;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.volsu.qa.utils.ApplicationContextHolder;


public class FailuresListener implements ITestListener {

    private static final Logger log = LogManager.getLogger(FailuresListener.class);


    @Override
    public void onTestFailure(ITestResult result) {
        this.captureScreenshot();
//        try {
//            FileUtils.copyFile(tempScreenshot, new File("c:\\tmp\\screenshot.png"));
//        } catch (IOException e) {
//            log.warn("Failed to save captured screenshot due to error: " + e.getMessage());
//        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] captureScreenshot() {
        WebDriver webDriver = ApplicationContextHolder.getBean(WebDriver.class);
        byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}
