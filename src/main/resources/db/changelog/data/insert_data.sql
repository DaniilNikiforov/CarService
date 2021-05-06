--liquibase formatted sql

--changeset author:2021-05-02-insert-data-into-roles_user
INSERT INTO roles (role_id, name) VALUES (1, "USER");

--rollback DELETE FROM roles WHERE id = 1;

--changeset author:2021-05-02-insert-data-into-roles_admin
INSERT INTO roles (role_id, name) VALUES (2, "ADMIN");

--rollback DELETE FROM roles WHERE id = 2;

--changeset author:2021-05-03-insert-data-into-colors-red
INSERT INTO colors (name) VALUES ("RED");

--rollback DELETE FROM colors WHERE name = "RED";

--changeset author:2021-05-03-insert-data-into-colors-green
INSERT INTO colors (name) VALUES ("GREEN");

--rollback DELETE FROM colors WHERE name = "GREEN";

--changeset author:2021-05-03-insert-data-into-colors-blue
INSERT INTO colors (name) VALUES ("BLUE");

--rollback DELETE FROM colors WHERE name = "BLUE";

--changeset author:2021-05-03-insert-data-into-car_types-jeep
INSERT INTO car_types (name) VALUES ("JEEP");

--rollback DELETE FROM car_types WHERE name = "BLUE";

--changeset author:2021-05-03-insert-data-into-car_types-sportcar
INSERT INTO car_types (name) VALUES ("SPORTCAR");

--rollback DELETE FROM car_types WHERE name = "SPORTCAR";

--changeset author:2021-05-03-insert-data-into-car_types-truck
INSERT INTO car_types (name) VALUES ("TRUCK");

--rollback DELETE FROM car_types WHERE name = "TRUCK";