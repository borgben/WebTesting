package org.alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\benja\\webtesting\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Olimpus olimpus = new Olimpus();
        olimpus.setDriver(driver);
        olimpus.setSearchBox();
        olimpus.setSearchButton();
        olimpus.searchProduct("Bass Guitar");
    }
}