-- V4__create_event_participant_table.sql
CREATE TABLE event_participant (
    id UUID PRIMARY KEY,
    event_id UUID NOT NULL,
    participant_id UUID NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE,
    checked_in_at TIMESTAMP WITH TIME ZONE,
    created_by UUID NOT NULL,
    last_modified_by UUID,
    checked_in_by UUID,
    version BIGINT NOT NULL,
    FOREIGN KEY (event_id) REFERENCES event(id),
    FOREIGN KEY (participant_id) REFERENCES participant(id)
);

-- CHECK CONSTRAINTS

ALTER TABLE event_participant
    ADD CONSTRAINT chk_evt_ptp_agg CHECK (status IN ('CONFIRMED', 'REGISTERED', 'ABSENT'));

ALTER TABLE event_participant
    ADD CONSTRAINT uk_event_participant UNIQUE (event_id, participant_id);

ALTER TABLE event_participant
    ADD CONSTRAINT chk_checkin_requires_confirmed
        CHECK (
            checked_in_at IS NULL
                OR status = 'CONFIRMED'
            );

-- INDEXES

CREATE INDEX idx_evt_ptp_event ON event_participant(event_id);
CREATE INDEX idx_evt_ptp_participant ON event_participant(participant_id);
CREATE INDEX idx_evt_ptp_event_status
    ON event_participant(event_id, status);