INSERT INTO users (name, surname, email, password, role)
VALUES ("Vasya", "Pupkin", "pupkin@gmail.com", "pupkin", "CLIENT");

INSERT INTO users (name, surname, email, password, role)
VALUES ("Henry", "Ford", "ford@gmail.com", "ford", "MANAGER");

INSERT INTO users (name, surname, email, password, role)
VALUES ("Nikola", "Tesla", "tesla@gmail.com", "tesla", "MASTER");

INSERT INTO requests (client_id, description, viewed, accepted)
VALUES (1, "Change color of the car to red", 1, 0);

INSERT INTO refusals (explanation, manager_id)
VALUES ("Any customer can have a car painted any color that he wants so long as it is black", 2);

INSERT INTO feedback (text, score)
VALUES ("Did not accepted my request(", 1);

INSERT INTO requests (client_id, description, viewed, accepted)
VALUES (1, "Change color of the car to black", 1, 1);

INSERT INTO orders (request_id, manager_id, price, master_id, done)
VALUES (2, 2, 4500, 3, 0);


