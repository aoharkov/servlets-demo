INSERT INTO repair_stages (name)
VALUES ('Waiting for its turn');

INSERT INTO repair_stages (name)
VALUES ('Teardown');

INSERT INTO repair_stages (name)
VALUES ('Parts Ordering');

INSERT INTO repair_stages (name)
VALUES ('Structural Repair');

INSERT INTO repair_stages (name)
VALUES ('Body Repair');

INSERT INTO repair_stages (name)
VALUES ('Refinishing and Painting');

INSERT INTO repair_stages (name)
VALUES ('Reassembly');

INSERT INTO repair_stages (name)
VALUES ('Finished');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Vasya', 'Pupkin', 'pupkin@gmail.com', 'pupkin', 'CLIENT');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Henry', 'Ford', 'ford@gmail.com', 'ford', 'MANAGER');

INSERT INTO users (name, surname, email, password, role)
VALUES ('Nikola', 'Tesla', 'tesla@gmail.com', 'tesla', 'MASTER');

INSERT INTO requests (client_id, description, viewed, accepted)
VALUES (1, 'Change color of the car to red', 1, 0);

INSERT INTO refusals (request_id, explanation, manager_id)
VALUES (1, 'Any customer can have a car painted any color that he wants so long as it is black', 2);

INSERT INTO feedback (request_id, text, score)
VALUES (1, 'Did not accepted my request(', 1);

INSERT INTO requests (client_id, description, viewed, accepted)
VALUES (1, 'Change color of the car to black', 1, 1);

INSERT INTO orders (request_id, manager_id, price, master_id, repair_stage_id)
VALUES (2, 2, 4500, 3, 8);


