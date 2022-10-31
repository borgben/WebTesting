package test.olimpus;

import org.alert.Olimpus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
                return null;
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
                return null;
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
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
                return null;
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
                return null;
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
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
    public void testSearchProducts_ProductsFound()
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
                return null;
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
                return null;
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
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
    public void testGetProducts_ProductsNotFound()
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
                return null;
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
                return null;
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
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
