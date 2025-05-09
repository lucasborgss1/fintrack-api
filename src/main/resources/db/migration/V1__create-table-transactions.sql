CREATE TABLE transactions (

    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    amount DECIMAL(19, 2) NOT NULL,
    date DATE NOT NULL,
    type ENUM('INCOME','EXPENSE') NOT NULL,
    category VARCHAR(100),
    payment_method ENUM('PIX','BANK_TRANSFER','CASH','CREDIT')
)