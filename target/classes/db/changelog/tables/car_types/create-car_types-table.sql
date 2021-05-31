--liquibase formatted sql

--changeset author:2021-05-03-create-table-car_types
CREATE TABLE car_types (
	type_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255)
)

--rollback drop table car_types;
