UPDATE transactions SET payment_method = 'NOT_INFORMED' WHERE payment_method IS NULL;

ALTER TABLE transactions
CHANGE payment_method transaction_method ENUM('PIX', 'BANK_TRANSFER', 'CASH', 'CREDIT', 'DEBIT', 'OTHER','NOT_INFORMED') NOT NULL;