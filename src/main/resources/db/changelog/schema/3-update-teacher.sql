-- liquibase formatted sql
-- changeSet kamila.krukowska:3 context: v0.0.1
-- comment: alters table to add columns, pesel and dob

ALTER TABLE teachers
ADD COLUMN pesel VARCHAR(11) NOT NULL,
ADD COLUMN dob   DATE        NOT NULL
;