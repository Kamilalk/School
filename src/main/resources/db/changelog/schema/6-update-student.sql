-- liquibase formatted sql
-- changeSet kamila.krukowska:6 context: v0.0.1
-- comment: alters table students to contain class id

ALTER TABLE students
ADD COLUMN clas_id VARCHAR(36)
;