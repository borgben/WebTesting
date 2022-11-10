package test.OlimpusTest;

import org.AlertScraper.Olimpus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class OlimpusTest {
    @Test
    public void testSetSearchBox_SearchBoxNotFound()
    {
        //Setup
        WebDriver driverMock = Mockito.mock(WebDriver.class);
        Mockito.when(driverMock.findElement(any()))
                .thenThrow(new NoSuchElementException("Element not found!"));

        Olimpus olimpus = new Olimpus();
        olimpus.setDriver(driverMock);

        //Exercise
        olimpus.setSearchBox();

        //Verify
        Assertions.assertNull(olimpus.getSearchBox());
    }

    @Test
    public void testSetSearchBox_SearchBoxFound()
    {
        //Setup
        WebElement dummyElement = new DummyElement();
        WebDriver driverMock = Mockito.mock(WebDriver.class);
        Mockito.when(driverMock.findElement(any()))
                .thenReturn(dummyElement);

        Olimpus olimpus = new Olimpus();
        olimpus.setDriver(driverMock);
        //Exercise
        olimpus.setSearchBox();

        //Verify
        Assertions.assertEquals(olimpus.getSearchBox(),dummyElement);

    }

    @Test
    public void testSetSearchButton_SearchButtonNotFound()
    {
        //Setup
        WebDriver driverMock = Mockito.mock(WebDriver.class);
        Mockito.when(driverMock.findElement(any()))
                .thenThrow(new NoSuchElementException("Element not found!"));

        Olimpus olimpus = new Olimpus();
        olimpus.setDriver(driverMock);

        //Exercise
        olimpus.setSearchButton();

        //Verify
        Assertions.assertNull(olimpus.getSearchButton());
    }

    @Test
    public void testSetSearchButton_SearchButtonFound()
    {
        //Setup
        WebElement dummyElement = new DummyElement();
        WebDriver driverMock = Mockito.mock(WebDriver.class);
        Mockito.when(driverMock.findElement(any()))
                .thenReturn(dummyElement);


        Olimpus olimpus = new Olimpus();
        olimpus.setDriver(driverMock);

        //Exercise
        olimpus.setSearchButton();

        //Verify
        Assertions.assertEquals(olimpus.getSearchButton(),dummyElement);
    }

    @Test
    public void testGetProducts_ProductsFound() throws InterruptedException {
        //Setup
        WebElement dummyElement = new DummyElement();
        List<WebElement> dummyList = new ArrayList<WebElement>();
        for (int i=0; i<12; i++)
        {
            dummyList.add(dummyElement);
        }
        WebDriver driverMock = Mockito.mock(ChromeDriver.class);
        Mockito.when(driverMock.findElements(any()))
                .thenReturn(dummyList);

        Olimpus olimpus = new Olimpus();
        olimpus.setDriver(driverMock);
        //Exercise
        List<WebElement> result = olimpus.getProducts();

        //Verify

        Assertions.assertEquals(dummyList,result);


    }



    @Test
    public void testGetProducts_ProductsNotFound() throws InterruptedException {
        //Setup
        WebElement dummyElement = new DummyElement();
        List<WebElement> dummyList = new ArrayList<WebElement>();
        for (int i=0; i<12; i++)
        {
            dummyList.add(dummyElement);
        }
        WebDriver driverMock = Mockito.mock(ChromeDriver.class);
        Mockito.when(driverMock.findElements(any()))
                .thenReturn(dummyList);

        Olimpus olimpus = new Olimpus();
        olimpus.setDriver(driverMock);

        //Exercise
        List<WebElement> result = olimpus.getProducts();

        //Verify
        Assertions.assertEquals(dummyList,result);
    }

}
