package com.example.flipflop.creditcard.service.repository;

import com.example.flipflop.creditcard.service.entity.CreditCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardDetailsRepository extends JpaRepository<CreditCardDetails, String> {
}
