package com.lucas.fintrack.api.domain.repository;

import com.lucas.fintrack.api.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
