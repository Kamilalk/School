-- liquibase formatted sql
-- changeSet kamila.krukowska:1 context: v0.0.1
-- comment: create table students

CREATE TABLE if NOT EXISTS students (
    id         VARCHAR(36) NOT NULL CONSTRAINT students_pkey primary key,
    first_name VARCHAR(64) NOT NULL,
    last_name   VARCHAR(64) NOT NULL,
    age         INT         NOT NULL,
    subject     VARCHAR(25) NOT NULL,
    gender      VARCHAR(25) NOT NULL,
    class_group  VARCHAR(25) NOT NULL,
    pesel       VARCHAR(11) NOT NULL,
    dob         DATE        NOT NULL
);