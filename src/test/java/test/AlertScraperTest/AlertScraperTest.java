package test.AlertScraperTest;

import org.alert.AlertScraper;
import org.alert.MarketAlert;
import org.alert.Olimpus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;


public class AlertScraperTest {

    @Test
    public void testGetAlerts_MoreThan5()
    {
        //Setup
        WebElement dummyElement = new WebElement() {
            @Override
            public void click() {

            }

            @Override
            public void submit() {

            }

            @Override
            public void sendKeys(CharSequence... charSequences) {

            }

            @Override
            public void clear() {

            }

            @Override
            public String getTagName() {
                return null;
            }

            @Override
            public String getAttribute(String s) {
                return "€1,499.00";
            }

            @Override
            public boolean isSelected() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public String getText() {
                return "€1,499.00";
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return this;
            }

            @Override
            public boolean isDisplayed() {
                return false;
            }

            @Override
            public Point getLocation() {
                return null;
            }

            @Override
            public Dimension getSize() {
                return null;
            }

            @Override
            public Rectangle getRect() {
                return null;
            }

            @Override
            public String getCssValue(String s) {
                return null;
            }

            @Override
            public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
                return null;
            }
        };
        Olimpus olimpusMock = Mockito.mock(Olimpus.class);
        MarketAlert marketAlert = Mockito.mock(MarketAlert.class);
        List<WebElement> List = new ArrayList<>() {
            {
                add(dummyElement);
                add(dummyElement);
                add(dummyElement);
                add(dummyElement);
                add(dummyElement);
                add(dummyElement);
            }
        };
        Mockito.when(olimpusMock.getProducts())
                .thenReturn(List);

        AlertScraper alertScraper = new AlertScraper(olimpusMock,marketAlert);

        //Exercise
        alertScraper.getAlerts();

        //Verify
        Assertions.assertEquals(alertScraper.alerts.size(),5);
    }

    @Test
    public void testGetAlerts_lessThan5()
    {
        //Setup
        WebElement dummyElement = new WebElement() {
            @Override
            public void click() {

            }

            @Override
            public void submit() {

            }

            @Override
            public void sendKeys(CharSequence... charSequences) {

            }

            @Override
            public void clear() {

            }

            @Override
            public String getTagName() {
                return null;
            }

            @Override
            public String getAttribute(String s) {
                return "€1,499.00";
            }

            @Override
            public boolean isSelected() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public String getText() {
                return "€1,499.00";
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return this;
            }

            @Override
            public boolean isDisplayed() {
                return false;
            }

            @Override
            public Point getLocation() {
                return null;
            }

            @Override
            public Dimension getSize() {
                return null;
            }

            @Override
            public Rectangle getRect() {
                return null;
            }

            @Override
            public String getCssValue(String s) {
                return null;
            }

            @Override
            public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
                return null;
            }
        };
        Olimpus olimpusMock = Mockito.mock(Olimpus.class);
        MarketAlert marketAlert = Mockito.mock(MarketAlert.class);
        List<WebElement> List = new ArrayList<>() {
            {
                add(dummyElement);
                add(dummyElement);
                add(dummyElement);
                add(dummyElement);
            }
        };
        Mockito.when(olimpusMock.getProducts())
                .thenReturn(List);

        AlertScraper alertScraper = new AlertScraper(olimpusMock,marketAlert);

        //Exercise
        alertScraper.getAlerts();

        //Verify
        Assertions.assertEquals(alertScraper.alerts.size(),4);
    }

    @Test
    public void testGetAlerts_Expected()
    {
        //Setup
        WebElement dummyElement = new WebElement() {
            @Override
            public void click() {

            }

            @Override
            public void submit() {

            }

            @Override
            public void sendKeys(CharSequence... charSequences) {

            }

            @Override
            public void clear() {

            }

            @Override
            public String getTagName() {
                return null;
            }

            @Override
            public String getAttribute(String s) {
                return "€1,499.00";
            }

            @Override
            public boolean isSelected() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public String getText() {
                return "€1,499.00";
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return this;
            }

            @Override
            public boolean isDisplayed() {
                return false;
            }

            @Override
            public Point getLocation() {
                return null;
            }

            @Override
            public Dimension getSize() {
                return null;
            }

            @Override
            public Rectangle getRect() {
                return null;
            }

            @Override
            public String getCssValue(String s) {
                return null;
            }

            @Override
            public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
                return null;
            }
        };
        Olimpus olimpusMock = Mockito.mock(Olimpus.class);
        MarketAlert marketAlert = Mockito.mock(MarketAlert.class);
        List<WebElement> List = new ArrayList<>() {
            {
                add(dummyElement);
                add(dummyElement);
                add(dummyElement);
                add(dummyElement);
                add(dummyElement);
            }
        };
        Mockito.when(olimpusMock.getProducts())
                .thenReturn(List);

        AlertScraper alertScraper = new AlertScraper(olimpusMock,marketAlert);

        //Exercise
        alertScraper.getAlerts();

        //Verify
        Assertions.assertEquals(alertScraper.alerts.size(),5);
    }

    @Test
    public void testParsePrice_Expected()
    {
        //Setup
        Olimpus olimpusMock = Mockito.mock(Olimpus.class);
        MarketAlert marketAlert = Mockito.mock(MarketAlert.class);
        AlertScraper alertScraper = new AlertScraper(olimpusMock, marketAlert);

        //Exercise
        int actual = alertScraper.parsePrice("€1,499.00");

        //Verify
        Assertions.assertEquals(149900,actual);
    }

    @Test
    public void testParsePrice_InvalidString()
    {
        //Setup
        Olimpus olimpusMock = Mockito.mock(Olimpus.class);
        MarketAlert marketAlert = Mockito.mock(MarketAlert.class);
        AlertScraper alertScraper = new AlertScraper(olimpusMock, marketAlert);

        //Exercise
        int actual = alertScraper.parsePrice("€1,4a9.00");

        //Verify
        Assertions.assertEquals(-9999,actual);
    }
}
