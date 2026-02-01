CREATE DATABASE payment_db;
USE payment_db;

CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    balance DECIMAL(10,2)
);

INSERT INTO accounts (name, balance) VALUES
('User', 5000.00),
('Merchant', 2000.00);
    