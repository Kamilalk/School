-- liquibase formatted sql
-- changeSet kamila.krukowska:5 context: v0.0.1
-- comment: create table teacher class map

CREATE TABLE if NOT EXISTS teacher_clas_map(
    teacher_id     VARCHAR(36) NOT NULL,
    clas_id      VARCHAR(36) NOT NULL
);