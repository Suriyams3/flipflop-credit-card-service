package com.example.flipflop.creditcard.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@FeignClient(
        name = "flipflop-credit-card-offers-service",
        url = "http://${OFFERS_SERVICE_HOST:localhost}:8083",
        fallback = OffersServiceClient.OffersFallback.class
)
public interface OffersServiceClient {

    @GetMapping("/offers")
    List<Object> fetchOffers(@RequestParam("cibilScore") int cibilScore, @RequestParam("creditPoints") int creditPoints);

    @Component
    class OffersFallback implements OffersServiceClient {
        @Override
        public List<Object> fetchOffers(int cibilScore, int creditPoints) {
            // Outage handling: log warning and degrade gracefully by returning an empty list
            System.out.println("WARNING: Downstream Offers Service is unreachable! Activating Circuit Breaker Fallback mechanism.");
            return new ArrayList<>();
        }
    }
}
