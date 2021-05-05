--liquibase formatted sql

--changeset author:2021-05-01-create-table-users
CREATE TABLE users(
	user_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(255) NOT NULL,
	password_hash VARCHAR(64) NOT NULL,
	name VARCHAR(50),
	surname VARCHAR(50),
	account_type BIGINT UNSIGNED NOT NULL
)

--rollback drop table users;
