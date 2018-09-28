package lesson09.b_add_event_listener;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.logging.Logger;

public class EventHandler extends AbstractWebDriverEventListener{
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BaseTest.class);

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        LOG.info("Browsing going navigate to: " + url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOG.debug("Findinf element by locator: " + by);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOG.info("Going click on element: " + element);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        LOG.info("Going click on: " + keysToSend + "to elemnt" + element);
    }
}
