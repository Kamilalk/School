-- liquibase formatted sql
-- changeSet kamila.krukowska:7 context: v0.0.1
-- comment: alters table clas to drop column teacher

ALTER TABLE clas DROP COLUMN teacher;
