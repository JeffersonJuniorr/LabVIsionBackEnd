CREATE SCHEMA IF NOT EXISTS audit;

CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS samples (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id INTEGER NOT NULL,
    patient VARCHAR(100) NOT NULL,
    collection_date DATE NOT NULL,
    tissue_type VARCHAR(100) NOT NULL,
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS measurements (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sample_id INTEGER NOT NULL,
    width_mm REAL NOT NULL,
    length_mm REAL NOT NULL,
    height_mm REAL NOT NULL,
    timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    image_blob BLOB(10M),
    FOREIGN KEY (sample_id) REFERENCES samples(id)
);

CREATE TABLE IF NOT EXISTS audit.audit_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id INTEGER,
    action VARCHAR(20) NOT NULL,
    entity VARCHAR(50) NOT NULL,
    entity_id INTEGER,
    event_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    before_data CLOB,
    after_data CLOB
);