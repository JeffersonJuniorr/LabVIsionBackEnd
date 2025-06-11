-- habilitar uuid
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE usuario (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha_hash VARCHAR(255) NOT NULL,
    perfil VARCHAR(20) NOT NULL
);

CREATE TABLE amostra (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usuario_id UUID NOT NULL REFERENCES usuario(id),
    paciente VARCHAR(100),
    data_coleta DATE NOT NULL,
    tipo_tecido VARCHAR(100),
    observacoes TEXT
);

CREATE TABLE medicao (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    amostra_id UUID NOT NULL REFERENCES amostra(id),
    largura_mm REAL NOT NULL,
    comprimento_mm REAL NOT NULL,
    altura_mm REAL NOT NULL,
    realizado_em TIMESTAMP NOT NULL DEFAULT now(),
    camera_tipo VARCHAR(20) NOT NULL,
    imagem_blob BYTEA
);

CREATE SCHEMA IF NOT EXISTS audit;
CREATE TABLE audit.log_auditoria (
    id BIGSERIAL PRIMARY KEY,
    usuario_id UUID,
    acao VARCHAR(20) NOT NULL,
    entidade VARCHAR(50) NOT NULL,
    entidade_id UUID,
    evento_em TIMESTAMP NOT NULL DEFAULT now(),
    payload_antes JSONB,
    payload_depois JSONB
);
