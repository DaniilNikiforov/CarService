--liquibase formatted sql

--changeset author:2021-05-03-create-table-cars
CREATE TABLE cars (
	car_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	weight INT UNSIGNED NOT NULL,
	color BIGINT UNSIGNED NOT NULL,
	car_type BIGINT UNSIGNED NOT NULL,
	owner_id BIGINT UNSIGNED NOT NULL
)

--rollback drop table cars;
