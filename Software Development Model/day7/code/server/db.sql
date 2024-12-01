CREATE DATABASE my_test_db;

USE my_test_db;

CREATE TABLE Product(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    price FLOAT,
    description VARCHAR(1000),
    createdTimestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO Product(
    title, price, description
) VALUES
('product 7', 700, 'this is a nice product 7'),
('product 8', 800, 'this is a nice product 8'),
('product 9', 900, 'this is a nice product 9'),
('product 10', 1000, 'this is a nice product 10');