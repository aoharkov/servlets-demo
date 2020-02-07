SET GLOBAL time_zone = '+2:00';

DROP TABLE IF EXISTS refusals;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS repair_stages;
DROP TABLE IF EXISTS feedback;
DROP TABLE IF EXISTS requests;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       int                                        NOT NULL AUTO_INCREMENT,
    name     varchar(60)                                NOT NULL,
    surname  varchar(60),
    email    varchar(60)                                NOT NULL UNIQUE,
    password varchar(60)                                NOT NULL,
    role     ENUM ('CLIENT','MANAGER','MASTER','ADMIN') NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE requests
(
    id          int          NOT NULL AUTO_INCREMENT,
    client_id   int          NOT NULL,
    description varchar(255) NOT NULL,
    viewed      bool         NOT NULL,
    accepted    bool         NOT NULL,
    FOREIGN KEY (client_id) REFERENCES users (id),
    PRIMARY KEY (id)
);

CREATE TABLE refusals
(
    id          int          NOT NULL AUTO_INCREMENT,
    request_id  int          NOT NULL,
    explanation varchar(255) NOT NULL,
    manager_id  int          NOT NULL,
    FOREIGN KEY (request_id) REFERENCES requests (id),
    FOREIGN KEY (manager_id) REFERENCES users (id),
    PRIMARY KEY (id)
);

CREATE TABLE repair_stages
(
    id   int         NOT NULL AUTO_INCREMENT,
    name varchar(80) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id              int NOT NULL AUTO_INCREMENT,
    request_id      int NOT NULL,
    manager_id      int NOT NULL,
    price           int NOT NULL,
    master_id       int NOT NULL,
    repair_stage_id int NOT NULL,
    FOREIGN KEY (request_id) REFERENCES requests (id),
    FOREIGN KEY (manager_id) REFERENCES users (id),
    FOREIGN KEY (master_id) REFERENCES users (id),
    FOREIGN KEY (repair_stage_id) REFERENCES repair_stages (id),
    PRIMARY KEY (id)
);

CREATE TABLE feedback
(
    id         int NOT NULL AUTO_INCREMENT,
    request_id int NOT NULL,
    text       varchar(255),
    score      int,
    FOREIGN KEY (request_id) REFERENCES requests (id),
    PRIMARY KEY (id)
);