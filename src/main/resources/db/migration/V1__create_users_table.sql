-- V1__create_users_table.sql
CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       created_at TIMESTAMP NOT NULL,
                       updated_at TIMESTAMP NULL,
                       created_by UUID NOT NULL,
                       last_modified_by UUID,
                       version BIGINT NOT NULL,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       status VARCHAR(50) NOT NULL,
                       deleted BOOLEAN DEFAULT FALSE NOT NULL,
                       deleted_at TIMESTAMP,
                       deleted_by UUID
);

-- CHECK CONSTRAINTS para enums
ALTER TABLE users
    ADD CONSTRAINT chk_user_role CHECK (role IN ('ADMIN', 'USER'));

ALTER TABLE users
    ADD CONSTRAINT chk_user_status CHECK (status IN ('ACTIVE', 'INACTIVE'));
