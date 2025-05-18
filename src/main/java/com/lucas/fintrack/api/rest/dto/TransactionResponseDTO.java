package com.lucas.fintrack.api.rest.dto;

import com.lucas.fintrack.api.domain.model.TransactionMethod;
import com.lucas.fintrack.api.domain.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionResponseDTO(
        Long id,
        String title,
        String description,
        BigDecimal amount,
        LocalDate date,
        TransactionType type,
        String category,
        TransactionMethod transactionMethod) {
}
