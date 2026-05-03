-- V2__create_participant_table.sql
CREATE TABLE participant (
    id UUID PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NULL,
    created_by UUID NOT NULL,
    last_modified_by UUID,
    version BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    document VARCHAR(11) NOT NULL UNIQUE,
    phone VARCHAR(11) NULL,
    deleted BOOLEAN DEFAULT FALSE NOT NULL,
    deleted_at TIMESTAMP WITH TIME ZONE,
    deleted_by UUID
);