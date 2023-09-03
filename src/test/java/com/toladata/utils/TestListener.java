package com.toladata.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        LogHelper.logInfo("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogHelper.logInfo("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogHelper.logError("Test failed: " + result.getName(), result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogHelper.logInfo("Test skipped: " + result.getName());
    }


}
