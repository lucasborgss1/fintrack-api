package com.lucas.fintrack.api.rest.dto;

import com.lucas.fintrack.api.domain.model.TransactionMethod;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateTransactionDTO(
        @NotNull
        Long id,
        String title,
        String description,
        BigDecimal amount,
        LocalDate date,
        String category,
        TransactionMethod transactionMethod
) {
}
