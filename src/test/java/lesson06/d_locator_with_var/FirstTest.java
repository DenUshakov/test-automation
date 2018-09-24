package lesson06.d_locator_with_var;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.StringContains.containsString;

public class FirstTest {

    static WebDriver wd;
    @BeforeClass
    public static void setup() {
        wd = new ChromeDriver();
//        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        wd.quit();
    }


    @Test
    public void verifyFirstSearch(){
        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).sendKeys("Dress");
//        wd.findElement(By.id("search_query_top")).submit();
//        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"search_query_top\"]")).
//                getText(), containsString("Dress"));

        (new WebDriverWait(wd, 10)).
                until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"), "Dress"));

        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).sendKeys("T-shirt");


//        new WebDriverWait(wd, 10);
//        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).
//                getText(), containsString("Dress"));

//        (new WebDriverWait(wd, 10)).
//                until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"), "Dress"));
    }
}
