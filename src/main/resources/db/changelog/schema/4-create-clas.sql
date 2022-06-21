-- liquibase formatted sql
-- changeSet kamila.krukowska:4 context: v0.0.1
-- comment: create table clas

CREATE TABLE if NOT EXISTS clas (
    id         VARCHAR(36) NOT NULL CONSTRAINT clas_pkey primary key,
    subject    VARCHAR(25) NOT NULL,
    year       VARCHAR(15) NOT NULL,
    teacher    VARCHAR(15) NOT NULL
);