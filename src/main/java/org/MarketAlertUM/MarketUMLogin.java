package org.MarketAlertUM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MarketUMLogin {
    WebDriver driver;
    WebElement userId;

    String currentURL;

    WebElement submitButton;

    List<WebElement> alerts;



    public MarketUMLogin(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.marketalertum.com/Alerts/Login");
        this.userId = driver.findElement(By.id("UserId"));
        this.submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
    }

    public void login(String credential)
    {
        this.userId.sendKeys(credential);
        this.submitButton.click();
        this.currentURL = driver.getCurrentUrl();
    }

    public String getCurrentURL()
    {
        return this.currentURL;
    }

    public void viewAlerts(){
        this.driver.get(currentURL);
        alerts = driver.findElements(By.xpath("//table[@border='1']"));
    }

    public List<WebElement> getAlerts()
    {
        return this.alerts;
    }

}
