package org.MarketAlertUM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarketUMLogin {
    WebDriver driver;
    WebElement userId;

    String resultURL;

    WebElement submitButton;

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
        this.resultURL = driver.getCurrentUrl();
    }

    public String getResultURL()
    {
        return this.resultURL;
    }

}
