-- habilitar uuid
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE samples (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id),
    patient VARCHAR(100) NOT NULL,
    collection_date DATE NOT NULL,
    tissue_type VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE measurements (
    id SERIAL PRIMARY KEY,
    sample_id INTEGER NOT NULL REFERENCES samples(id),
    width_mm REAL NOT NULL,
    length_mm REAL NOT NULL,
    height_mm REAL NOT NULL,
    timestamp TIMESTAMP NOT NULL DEFAULT now(),
    image_blob BYTEA
);

CREATE SCHEMA IF NOT EXISTS audit;
CREATE TABLE audit.audit_logs (
    id BIGSERIAL PRIMARY KEY,
    user_id INTEGER,
    action VARCHAR(20) NOT NULL,
    entity VARCHAR(50) NOT NULL,
    entity_id INTEGER,
    event_time TIMESTAMP NOT NULL DEFAULT now(),
    before_data JSONB,
    after_data JSONB
);
