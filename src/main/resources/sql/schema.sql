CREATE TABLE feedback
(
    id    int NOT NULL AUTO_INCREMENT,
    text  varchar(255),
    score int,
    PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id         int NOT NULL AUTO_INCREMENT,
    request_id int,
    manager_id int,
    price      int,
    master_id  int,
    done       bool,
    FOREIGN KEY (request_id) REFERENCES requests (id),
    FOREIGN KEY (manager_id) REFERENCES users (id),
    FOREIGN KEY (master_id) REFERENCES users (id),
    PRIMARY KEY (id)
);

CREATE TABLE refusals
(
    id          int NOT NULL AUTO_INCREMENT,
    explanation varchar(255),
    manager_id  int,
    FOREIGN KEY (manager_id) REFERENCES users (id),
    PRIMARY KEY (id)
);

CREATE TABLE requests
(
    id          int NOT NULL AUTO_INCREMENT,
    client_id   int,
    description varchar(255),
    viewed      bool,
    accepted    bool,
    FOREIGN KEY (client_id) REFERENCES users (id),
    PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(60),
    PRIMARY KEY (id)
);

CREATE TABLE users_roles
(
    user_id int,
    role_id int,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE users
(
    id       int NOT NULL AUTO_INCREMENT,
    name     varchar(60),
    surname  varchar(60),
    email    varchar(60) UNIQUE,
    password varchar(60),
    PRIMARY KEY (id)
);