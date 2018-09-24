package lesson07.e_add_basetest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static lesson07.e_add_basetest.FirstTest.wd;

public class BaseTest {
    @Rule
    public  TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println(String.format("Test '%s' was succeeded", description.getMethodName()));
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(String.format("Test '%s' was failed", description.getMethodName()));
            super.failed(e, description);
        }

        @Override
        protected void starting(Description description) {
            System.out.println(String.format("Test '%s' has been started", description.getMethodName()));
            super.starting(description);
        }
    };
    static WebDriver wd;
    @BeforeClass
    public static void setup() {
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
    }


    @AfterClass
    public static void tearDown() {
        wd.quit();
    }



}
