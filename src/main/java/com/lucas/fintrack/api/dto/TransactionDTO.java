package com.lucas.fintrack.api.dto;

import com.lucas.fintrack.api.domain.model.PaymentMethod;
import com.lucas.fintrack.api.domain.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionDTO(
        String title,
        String description,
        BigDecimal amount,
        LocalDate date,
        TransactionType type,
        String category,
        PaymentMethod paymentMethod) {
}
