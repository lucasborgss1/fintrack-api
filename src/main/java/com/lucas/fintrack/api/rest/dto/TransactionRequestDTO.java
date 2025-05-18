package com.lucas.fintrack.api.rest.dto;

import com.lucas.fintrack.api.domain.model.TransactionMethod;
import com.lucas.fintrack.api.domain.model.TransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRequestDTO(
        @NotBlank
        String title,

        String description,

        @NotNull(message = "O valor é obrigatório")
        @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
        BigDecimal amount,

        @NotNull(message = "A data é obrigatória.")
        LocalDate date,

        @NotNull(message = "Tipo da transação é obrigatório.")
        TransactionType transactionType,

        @NotNull(message = "Categoria é obrigatória.")
        String category,

        TransactionMethod transactionMethod) {
}
