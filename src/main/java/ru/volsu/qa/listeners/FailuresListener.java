package ru.volsu.qa.listeners;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.volsu.qa.utils.ApplicationContextHolder;

import java.io.File;
import java.io.IOException;

@Slf4j
public class FailuresListener implements ITestListener {


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
