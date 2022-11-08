package org.AlertScraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AlertScraper {
    public List<Alert> alerts;
    Olimpus olimpus;

    MarketAlert marketAlert;

    public int parsePrice(String text)
    {
        int priceCents;
        try {
            priceCents = Math.round(Float.parseFloat(text.replaceAll("€|,",""))) * 100;
        }catch(Exception e)
        {
            return -9999;
        }

        return priceCents;
    }
    public AlertScraper(Olimpus olimpus, MarketAlert marketAlert)
    {
        alerts = new ArrayList<Alert>();
        this.olimpus = olimpus;
        this.marketAlert = marketAlert;
    }

    public void getAlerts() throws InterruptedException {
        List<WebElement> rawData = olimpus.getProducts();
        for (int i = 0; i < 5; i++){

            WebElement product;
            try{
                product = rawData.get(i);
            }catch (Exception e)
            {
                break;
            }

            //We retrieve the item url
            WebElement imageDiv = product.findElement(By.tagName("a"));
            String itemUrl = imageDiv.getAttribute("href");

            //We retrieve the image Url
            String imageUrl = imageDiv.findElement(By.tagName("img")).getAttribute("src");

            //We retrieve the heading.
            String heading = product.findElement(By.tagName("h4")).getText();

            //We retrieve the description.
            String description = product.findElement(By.className("description")).getText();

            //We retrieve the price.
            int priceCents= parsePrice(product.findElement(By.className("price")).getText());

            //Create new alert and add it to the list.
            alerts.add(new Alert(6, heading, description, itemUrl, imageUrl,priceCents));
            System.out.println(alerts);
        }
    }


    public void sendAlerts() throws Exception {

        CompletableFuture<HttpResponse<String>> clearResponse = marketAlert.clearAlerts();
        while (!clearResponse.isDone()){}
        if(clearResponse.get().statusCode() != 200)
        {
            throw new Exception("Invalid Request to Market Alert!");
        }

        List<CompletableFuture<HttpResponse<String>>> reqResponse = new ArrayList<CompletableFuture<HttpResponse<String>>>();
        for (Alert alert:alerts)
        {
            reqResponse.add(marketAlert.postAlert(alert.alertToJson()));
        }

        for (CompletableFuture<HttpResponse<String>> future:reqResponse)
        {
            while(!future.isDone()) {}
            if(future.get().statusCode() != 201)
            {
                throw new Exception("Invalid Request to Market Alert!");
            }
        }
    }

}
