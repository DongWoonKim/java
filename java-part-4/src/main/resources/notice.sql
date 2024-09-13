CREATE DATABASE notice
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE user (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      user_id VARCHAR(20) NOT NULL UNIQUE,
                      password VARCHAR(30) NOT NULL,
                      name VARCHAR(20),
                      created DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE content (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         user_id VARCHAR(20) NOT NULL,
                         content TEXT NOT NULL,
                         created DATETIME DEFAULT CURRENT_TIMESTAMP
);

