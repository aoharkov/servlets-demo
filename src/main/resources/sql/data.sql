INSERT INTO roles (name)
VALUES ("CLIENT");

INSERT INTO roles (name)
VALUES ("MANAGER");

INSERT INTO roles (name)
VALUES ("MASTER");

INSERT INTO users (name, surname, email, password)
VALUES ("Vasya", "Pupkin", "pupkin@gmail.com", "pupkin");

INSERT INTO users (name, surname, email, password)
VALUES ("Henry", "Ford", "ford@gmail.com", "ford");

INSERT INTO users (name, surname, email, password)
VALUES ("Nikola", "Tesla", "tesla@gmail.com", "tesla");

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO users_roles (user_id, role_id)
VALUES (2, 2);

INSERT INTO users_roles (user_id, role_id)
VALUES (2, 1);

INSERT INTO users_roles (user_id, role_id)
VALUES (2, 3);

INSERT INTO users_roles (user_id, role_id)
VALUES (3, 3);

INSERT INTO requests (client_id, description, viewed, accepted)
VALUES (1, "Change color of the car to red", 1, 0);

INSERT INTO refusals ( explanation, manager_id)
VALUES ("Any customer can have a car painted any color that he wants so long as it is black", 2);

INSERT INTO feedback ( text, score)
VALUES ("Did not accepted my request(", 1);

INSERT INTO requests (client_id, description, viewed, accepted)
VALUES (1, "Change color of the car to black", 1, 1);

INSERT INTO orders (request_id, manager_id, price, master_id, done)
VALUES (2, 2, 4500, 3, 0);


