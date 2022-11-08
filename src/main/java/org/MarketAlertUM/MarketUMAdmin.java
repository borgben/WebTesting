package org.MarketAlertUM;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarketUMAdmin {

    public HttpResponse<String> clearAlerts() throws IOException, InterruptedException {
        HttpClient httpclient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.marketalertum.com/Alert?userId=5b403bf6-4f10-4bb3-ba93-54a4513864e2")).DELETE().build();

        return httpclient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> postAlert(String alertJson) throws IOException, InterruptedException {
        HttpClient httpclient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.marketalertum.com/Alert"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(alertJson))
                .build();

        return httpclient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
