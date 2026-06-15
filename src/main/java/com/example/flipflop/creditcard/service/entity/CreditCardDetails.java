package com.example.flipflop.creditcard.service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "credit_card_details")
public class CreditCardDetails {

    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "credit_card_number", nullable = false, unique = true)
    private String creditCardNumber;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Column(name = "credit_points_available", nullable = false)
    private Integer creditPointsAvailable;

    @Column(name = "credit_points_expiry_date")
    private LocalDate creditPointsExpiryDate;

    @Column(name = "cibil_score", nullable = false)
    private Integer cibilScore;

    @Transient // Runtime only field; not stored in this database table
    private List<Object> eligibleOffers;

    // Default Constructor
    public CreditCardDetails() {}

    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getCreditCardNumber() { return creditCardNumber; }
    public void setCreditCardNumber(String creditCardNumber) { this.creditCardNumber = creditCardNumber; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public Integer getCreditPointsAvailable() { return creditPointsAvailable; }
    public void setCreditPointsAvailable(Integer creditPointsAvailable) { this.creditPointsAvailable = creditPointsAvailable; }

    public LocalDate getCreditPointsExpiryDate() { return creditPointsExpiryDate; }
    public void setCreditPointsExpiryDate(LocalDate creditPointsExpiryDate) { this.creditPointsExpiryDate = creditPointsExpiryDate; }

    public Integer getCibilScore() { return cibilScore; }
    public void setCibilScore(Integer cibilScore) { this.cibilScore = cibilScore; }

    public List<Object> getEligibleOffers() { return eligibleOffers; }
    public void setEligibleOffers(List<Object> eligibleOffers) { this.eligibleOffers = eligibleOffers; }
}
