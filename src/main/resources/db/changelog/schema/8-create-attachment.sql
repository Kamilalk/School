-- liquibase formatted sql
-- changeSet kamila.krukowska:8 context: v0.0.1
-- comment: create table attachments

CREATE TABLE if NOT EXISTS attachment(
    id     VARCHAR(36) NOT NULL,
    data     OID,
    file_name     VARCHAR(36) NOT NULL,
    file_type     VARCHAR(36) NOT NULL
);