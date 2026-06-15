package com.example.flipflop.creditcard.service.controller;


import com.example.flipflop.creditcard.service.client.OffersServiceClient;
import com.example.flipflop.creditcard.service.entity.CreditCardDetails;
import com.example.flipflop.creditcard.service.repository.CreditCardDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CreditCardGraphQLController {

    @Autowired
    private CreditCardDetailsRepository repository;

    @Autowired
    private OffersServiceClient offersClient;

    @QueryMapping
    public CreditCardDetails getCreditCardDetails(@Argument String accountNumber) {
        // 1. Fetch core entity details from local database
        CreditCardDetails details = repository.findById(accountNumber).orElse(null);

        if (details != null) {
            // 2. Query downstream REST microservice dynamically using Feign client
            List<Object> offers = offersClient.fetchOffers(details.getCibilScore(), details.getCreditPointsAvailable());

            // 3. Enrich the transient data layer
            details.setEligibleOffers(offers);
        }

        return details;
    }
}
