package utilities;

import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.driver.DriverSingleton;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(String.format(
                "======================================== STARTING TEST %s ========================================",
                iTestResult.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(String.format(
                "======================================== FINISHED TEST %s Duration: %ss ========================================",
                iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(String.format(
                "======================================== FAILED TEST %s Duration: %ss ========================================",
                iTestResult.getName(),
                getExecutionTime(iTestResult)));
        takeScreenshot(iTestResult); //УБРАТЬ RESULT
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(String.format(
                "======================================== SKIPPING TEST %s ========================================",
                iTestResult.getName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }

    @Attachment(value = "Last screen state", type = "image/png")
    private byte[] takeScreenshot(ITestResult result) {
        byte[] screenshot = ((TakesScreenshot) DriverSingleton.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
        String testName = result.getMethod().getMethodName();
        String dateTime = DateTimeFormatter.ofPattern("dd MMM yyyy, hh.mm a")
                .format(LocalDateTime.now());
        try {
            Files.write(Paths.get("src/test/resources/screenshots/screenshot_" + testName + "_"
                                                                                    + dateTime
                                                                                    + ".png"), screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot;
    }
}