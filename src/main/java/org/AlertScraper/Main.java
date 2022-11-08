package org.AlertScraper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\benja\\webtesting\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Olimpus olimpus = new Olimpus();
        MarketAlert marketAlert = new MarketAlert();

        olimpus.setDriver(driver);
        olimpus.setSearchBox();
        olimpus.setSearchButton();
        olimpus.searchProduct("Bass Guitar");

        AlertScraper alertScraper = new AlertScraper(olimpus,marketAlert);
        alertScraper.getAlerts();
        alertScraper.sendAlerts();
    }
}