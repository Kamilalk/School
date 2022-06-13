-- liquibase formatted sql
-- changeSet kamila.krukowska:3 context: v0.0.1
-- comment: create table class

CREATE TABLE if NOT EXISTS class (
    id         VARCHAR(36) NOT NULL CONSTRAINT class_pkey primary key,
    subject    VARCHAR(13) NOT NULL,
    year       VARCHAR(15) NOT NULL,
    teacher    VARCHAR(15) NOT NULL
);