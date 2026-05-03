-- V3__create_event_table.sql
CREATE TABLE event (
    id UUID PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NULL,
    created_by UUID NOT NULL,
    last_modified_by UUID,
    version BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    start_date TIMESTAMP WITH TIME ZONE NOT NULL,
    end_date TIMESTAMP WITH TIME ZONE NOT NULL,
    deleted BOOLEAN DEFAULT FALSE NOT NULL,
    deleted_at TIMESTAMP WITH TIME ZONE,
    deleted_by UUID
);

-- CHECK CONSTRAINTS

ALTER TABLE event
    ADD CONSTRAINT chk_dates CHECK ( end_date >= start_date );