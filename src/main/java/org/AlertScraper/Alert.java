package org.AlertScraper;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Alert {
    int alertType;
    String heading;
    String description;
    String url;
    String imageUrl;
    String postedBy;
    int priceInCents;

    public Alert(int alertType, String heading, String description, String url, String imageUrl, int priceInCents) {
        this.alertType = alertType;
        this.heading = heading;
        this.description = description;
        this.url = url;
        this.imageUrl = imageUrl;
        this.postedBy = "5b403bf6-4f10-4bb3-ba93-54a4513864e2";
        this.priceInCents = priceInCents;
    }

    public String alertToJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertType=" + alertType +
                ", heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", postedBy='" + postedBy + '\'' +
                ", priceInCents=" + priceInCents +
                '}';
    }
}
