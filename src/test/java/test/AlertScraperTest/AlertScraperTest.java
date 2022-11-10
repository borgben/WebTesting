package test.AlertScraperTest;

import org.AlertScraper.AlertScraper;
import org.AlertScraper.MarketAlert;
import org.AlertScraper.Olimpus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.*;
import test.OlimpusTest.DummyElement;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;


public class AlertScraperTest {

    @Test
    public void testGetAlerts_MoreThan5() throws InterruptedException {
        //Setup
        WebElement dummyElement = new DummyElement();
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
    public void testGetAlerts_lessThan5() throws InterruptedException {
        //Setup
        WebElement dummyElement = new DummyElement();
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
    public void testGetAlerts_Expected() throws InterruptedException {
        //Setup
        WebElement dummyElement = new DummyElement();
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

    @Test
    public void testPostAlerts_InvalidPostRequest() throws Exception
    {
        WebElement dummyElement = new DummyElement();
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

        HttpResponse<String> mockedPostResponse = Mockito.mock(HttpResponse.class);
        HttpResponse<String> mockedDeleteResponse = Mockito.mock(HttpResponse.class);

        Mockito.when(mockedPostResponse.statusCode()).thenReturn(400);
        Mockito.when(mockedPostResponse.body()).thenReturn("some string");

        Mockito.when(mockedDeleteResponse.statusCode()).thenReturn(200);
        Mockito.when(mockedDeleteResponse.body()).thenReturn("some string");

        Mockito.when(marketAlert.postAlert(anyString())).thenReturn(CompletableFuture.completedFuture(mockedPostResponse));
        Mockito.when(marketAlert.clearAlerts()).thenReturn(CompletableFuture.completedFuture(mockedDeleteResponse));

        AlertScraper alertScraper = new AlertScraper(olimpusMock, marketAlert);
        alertScraper.getAlerts();
        final String expectedExceptionThrown = "Invalid Request to Market Alert!";

        Exception exceptionThrown = Assertions.assertThrows(
                Exception.class,
                alertScraper::sendAlerts
        );

        Assertions.assertEquals(expectedExceptionThrown,exceptionThrown.getMessage());
    }

    @Test
    public void testPostAlerts_InvalidDeleteRequest() throws Exception
    {
        HttpResponse<String> mockedPostResponse = Mockito.mock(HttpResponse.class);
        HttpResponse<String> mockedDeleteResponse = Mockito.mock(HttpResponse.class);

        Mockito.when(mockedDeleteResponse.statusCode()).thenReturn(400);
        Mockito.when(mockedDeleteResponse.body()).thenReturn("some string");

        Mockito.when(mockedPostResponse.statusCode()).thenReturn(201);
        Mockito.when(mockedPostResponse.body()).thenReturn("some string");

        Olimpus olimpusMock = Mockito.mock(Olimpus.class);
        MarketAlert marketAlert = Mockito.mock(MarketAlert.class);
        Mockito.when(marketAlert.postAlert(anyString())).thenReturn(CompletableFuture.completedFuture(mockedPostResponse));
        Mockito.when(marketAlert.clearAlerts()).thenReturn(CompletableFuture.completedFuture(mockedDeleteResponse));

        AlertScraper alertScraper = new AlertScraper(olimpusMock, marketAlert);

        final String expectedExceptionThrown = "Invalid Request to Market Alert!";

        Exception exceptionThrown = Assertions.assertThrows(
                Exception.class,
                alertScraper::sendAlerts
        );

        Assertions.assertEquals(expectedExceptionThrown,exceptionThrown.getMessage());
    }
}
