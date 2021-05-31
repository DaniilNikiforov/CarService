--liquibase formatted sql

--changeset author:2021-05-03-create-table-colors
CREATE TABLE colors (
	color_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255)
)

--rollback drop table colors;
