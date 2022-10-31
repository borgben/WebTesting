package org.alert;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class MarketAlert {

    public CompletableFuture<HttpResponse<String>> clearAlerts() {
         HttpClient httpclient = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.marketalertum.com/Alert?userId=5b403bf6-4f10-4bb3-ba93-54a4513864e2")).DELETE().build();

         return httpclient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }

    public CompletableFuture<HttpResponse<String>> postAlert(String alertJson)  {
        HttpClient httpclient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.marketalertum.com/Alert"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(alertJson))
                .build();

        return httpclient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }

}
