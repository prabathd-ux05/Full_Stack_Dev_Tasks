CREATE DATABASE dashboard_db;
USE dashboard_db;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    department VARCHAR(50),
    joining_date DATE
);

INSERT INTO employees (name, email, department, joining_date) VALUES
('Alice', 'alice@mail.com', 'HR', '2022-01-10'),
('Bob', 'bob@mail.com', 'IT', '2021-06-15'),
('Charlie', 'charlie@mail.com', 'Finance', '2023-02-20'),
('David', 'david@mail.com', 'IT', '2020-09-05');
