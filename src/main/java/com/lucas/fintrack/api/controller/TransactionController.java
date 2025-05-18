package com.lucas.fintrack.api.controller;

import com.lucas.fintrack.api.domain.model.Transaction;
import com.lucas.fintrack.api.dto.TransactionDTO;
import com.lucas.fintrack.api.domain.repository.TransactionRepository;
import com.lucas.fintrack.api.util.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository repository;

    @PostMapping()
    @Transactional
    public void createTransaction(@RequestBody TransactionDTO dados) {
        Transaction transaction = TransactionMapper.toEntity(dados);
        repository.save(transaction);
    }
    
}
