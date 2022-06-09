-- liquibase formatted sql
-- changeSet kamila.krukowska:2 context: v0.0.1
-- comment: create table teachers

CREATE TABLE if NOT EXISTS teachers (
    id             VARCHAR(36)  NOT NULL CONSTRAINT teachers_pkey PRIMARY KEY,
    first_name     VARCHAR(255) NOT NULL,
    last_name      VARCHAR(255) NOT NULL,
    age            INT          NOT NULL,
    gender         VARCHAR(25)  NOT NULL,
    subject        VARCHAR(25)  NOT NULL
);