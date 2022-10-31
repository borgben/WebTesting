package org.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Olimpus {
    protected WebDriver driver;
    protected WebElement searchBox;
    protected WebElement searchButton;

    public void setDriver(WebDriver driver)
    {
        this.driver = driver;
        this.driver.get("https://olimpusmusic.com/");
    }

    public void setSearchBox()
    {
        try
        {
            this.searchBox = driver.findElement(By.id("woocommerce-product-search-field"));
        }
        catch (Exception e)
        {
            this.searchBox = null;
        }
    }

    public WebElement getSearchBox()
    {
        return searchBox;
    }

    public void setSearchButton()
    {
        try
        {
            this.searchButton = driver.findElement(By.xpath("//input[@value='Search']"));
        }
        catch (Exception e)
        {
            this.searchButton = null;
        }
    }

    public WebElement getSearchButton()
    {
        return searchButton;
    }

    public void searchProduct(String productName)
    {
        driver.manage().window().maximize();
        this.searchBox.sendKeys(productName);
        this.searchButton.click();
    }

    public List<WebElement> getProducts()
    {
        return driver.findElements(By.xpath("//li[@class='col-md-3 col-xs-6 product']"));
    }
}