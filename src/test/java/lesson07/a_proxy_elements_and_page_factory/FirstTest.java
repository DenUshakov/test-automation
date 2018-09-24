package lesson07.a_proxy_elements_and_page_factory;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.StringContains.containsString;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

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

        String query1 = "Dress";
        String query2 = "T-shirt";

        LandingPage landingPage = new LandingPage();

        landingPage.searchFor(query1);


        (new WebDriverWait(wd, 10)).
                until(textToBePresentInElement(landingPage.firstAdvice, query1));

        landingPage.searchFor(query2);
        (new WebDriverWait(wd, 10)).
                until(textToBePresentInElement(landingPage.firstAdvice, query2));
    }

    class LandingPage {

        @FindBy(id = "search_query_top")
        @CacheLookup
        WebElement searchField;

        @FindBy (xpath = "//*[@id=\"index\"]/div[2]/ul/li[1]")
        WebElement firstAdvice;

        public LandingPage() {
            PageFactory.initElements(wd, this);
        }

        void  searchFor (String query){
            searchField.click();
            searchField.clear();
            searchField.sendKeys(query);


        }


    }
}
