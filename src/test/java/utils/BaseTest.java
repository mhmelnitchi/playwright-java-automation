package utils;

import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import java.lang.reflect.Method;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected Page page;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void startReport() {
        extent = ReportManager.getInstance();
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeMethod
    public void setUp(Method method) {
        test = extent.createTest(method.getName());
        page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else {
            test.skip("Test skipped");
        }

        page.close();
    }

    @AfterSuite
    public void endReport() {
        browser.close();
        playwright.close();
        extent.flush();
    }
}
