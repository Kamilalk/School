
CREATE TABLE if NOT EXISTS countries (
    id             VARCHAR(36)  NOT NULL CONSTRAINT countries_pkey PRIMARY KEY,
    firts_name     VARCHAR(255) NOT NULL,
    last_name      VARCHAR(255) NOT NULL,
    age            INT          NOT NULL,
    gender         VARCHAR(25)  NOT NULL,
    subject        VARCHAR(25)  NOT NULL,
);

