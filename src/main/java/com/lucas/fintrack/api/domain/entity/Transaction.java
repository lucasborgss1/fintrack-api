package com.lucas.fintrack.api.domain.entity;

import com.lucas.fintrack.api.domain.model.TransactionMethod;
import com.lucas.fintrack.api.domain.model.TransactionType;
import com.lucas.fintrack.api.rest.dto.UpdateTransactionDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Transaction")
@Table(name = "transactions")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Column(length = 100)
    private String category;

    @Enumerated(EnumType.STRING)
    private TransactionMethod transactionMethod;


    public void updateInfo(UpdateTransactionDTO data) {
        if (data.title() != null) {
            this.title = data.title();
        }
        if (data.description() != null) {
            this.description = data.description();
        }
        if (data.amount() != null) {
            this.amount = data.amount();
        }
        if (data.date() != null) {
            this.date = data.date();
        }
        if (data.category() != null) {
            this.category = data.category();
        }
        if (data.transactionMethod() != null) {
            this.transactionMethod = data.transactionMethod();
        }
    }
}
