CREATE TABLE if NOT EXISTS students (
    id         VARCHAR(36) NOT NULL CONSTRAINT students_pkey primary key,
    first_name VARCHAR(64) NOT NULL,
    last_name   VARCHAR(64) NOT NULL,
    age         INT         NOT NULL,
    subject     VARCHAR(25) NOT NULL,
    gender      VARCHAR(25) NOT NULL,
    class_group  VARCHAR(25) NOT NULL
    pesel       VARCHAR(11)
    dob         VARCHAR(11)
)

ALTER TABLE students
ADD COLUMN pesel VARCHAR(11)

ALTER TABLE students
ADD COLUMN dob VARCHAR(11)

