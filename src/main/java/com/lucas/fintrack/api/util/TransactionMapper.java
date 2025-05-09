package com.lucas.fintrack.api.util;

import com.lucas.fintrack.api.domain.model.Transaction;
import com.lucas.fintrack.api.dto.TransactionDTO;

public class TransactionMapper {
    public static Transaction toEntity(TransactionDTO dto) {
        return new Transaction(
                null,
                dto.title(),
                dto.description(),
                dto.amount(),
                dto.date(),
                dto.type(),
                dto.category(),
                dto.paymentMethod()
        );
    }
}

