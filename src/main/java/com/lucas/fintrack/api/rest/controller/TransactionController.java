package com.lucas.fintrack.api.rest.controller;

import com.lucas.fintrack.api.domain.entity.Transaction;
import com.lucas.fintrack.api.rest.dto.TransactionRequestDTO;
import com.lucas.fintrack.api.rest.dto.TransactionResponseDTO;
import com.lucas.fintrack.api.rest.dto.UpdateTransactionDTO;
import com.lucas.fintrack.api.domain.repository.TransactionRepository;
import com.lucas.fintrack.api.rest.mapper.TransactionMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository repository;

    @GetMapping("/getAll")
    public Page<TransactionResponseDTO> getAll(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return repository.findAll(pageable).map(TransactionMapper::toDTO);
    }

    @PostMapping("")
    @Transactional
    public ResponseEntity<Void> createTransaction(@RequestBody @Valid TransactionRequestDTO data) {
        Transaction transaction = TransactionMapper.toEntity(data);
        repository.save(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    @Transactional
    public void updateTransaction(@RequestBody @Valid UpdateTransactionDTO data) {
        var transaction = repository.getReferenceById(data.id());
        transaction.updateInfo(data);
        System.out.println(data);
    }
}
