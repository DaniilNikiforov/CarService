--liquibase formatted sql

--changeset author:2020-05-02-add-fk_rusers_roles
ALTER TABLE users
ADD CONSTRAINT fk_users_role_account_type FOREIGN KEY (account_type)
REFERENCES roles(id)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

--rollback ALTER TABLE users DROP CONSTRAINT fk_users_role_account_type 