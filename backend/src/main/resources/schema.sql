CREATE TABLE IF NOT EXISTS traveller_users
(
    id              INT GENERATED ALWAYS AS IDENTITY,
    firstname       VARCHAR(256) NOT NULL,
    lastname        VARCHAR(256) NOT NULL,
    telegram_handle VARCHAR(256) NOT NULL UNIQUE,
    password        VARCHAR(256) NOT NULL,
    role            VARCHAR(32)  NOT NULL DEFAULT USER,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tokens
(
    id         INT GENERATED ALWAYS AS IDENTITY,
    user_id    INT           NOT NULL,
    token      VARCHAR(1024) NOT NULL,
    token_type VARCHAR(32)   NOT NULL,
    revoked    BOOLEAN       NOT NULL,
    expired    BOOLEAN       NOT NULL,
    PRIMARY KEY (id),
    constraint fk_tokens FOREIGN KEY (user_id) REFERENCES traveller_users (id)
);

CREATE TABLE IF NOT EXISTS travels
(
    id            INT GENERATED ALWAYS AS IDENTITY,
    user_id       INT           NOT NULL,
    description   VARCHAR(4096) NOT NULL,
    documents     BOOLEAN       NOT NULL,
    small_package BOOLEAN       NOT NULL,
    big_package   BOOLEAN       NOT NULL,
    cost          NUMERIC(5, 2) NOT NULL,
    currency      VARCHAR(32)   NOT NULL,
    PRIMARY KEY (id),
    constraint fk_travels FOREIGN KEY (user_id) REFERENCES traveller_users (id)
);

CREATE TABLE IF NOT EXISTS travel_stops
(
    travel_id INT  NOT NULL,
    position  INT  NOT NULL,
    date      DATE NOT NULL,
    city      VARCHAR(256),
    PRIMARY KEY (travel_id, position),
    CONSTRAINT fk_travel_stops FOREIGN KEY (travel_id) REFERENCES travels (id)
);

CREATE UNIQUE INDEX IF NOT EXISTS ui_traveller_telegram ON traveller_users USING btree (telegram_handle);

