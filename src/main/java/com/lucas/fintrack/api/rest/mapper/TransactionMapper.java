package com.lucas.fintrack.api.rest.mapper;

import com.lucas.fintrack.api.domain.entity.Transaction;
import com.lucas.fintrack.api.domain.model.TransactionMethod;
import com.lucas.fintrack.api.rest.dto.TransactionRequestDTO;
import com.lucas.fintrack.api.rest.dto.TransactionResponseDTO;

public class TransactionMapper {
    public static Transaction toEntity(TransactionRequestDTO dto) {
        TransactionMethod transactionMethod = dto.transactionMethod() != null ? dto.transactionMethod() : TransactionMethod.NOT_INFORMED;
        return new Transaction(
                null,
                dto.title(),
                dto.description(),
                dto.amount(),
                dto.date(),
                dto.transactionType(),
                dto.category(),
                transactionMethod
        );
    }

    public static TransactionResponseDTO toDTO(Transaction entity) {
        return new TransactionResponseDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getAmount(),
                entity.getDate(),
                entity.getType(),
                entity.getCategory(),
                entity.getTransactionMethod()
        );
    }
}

