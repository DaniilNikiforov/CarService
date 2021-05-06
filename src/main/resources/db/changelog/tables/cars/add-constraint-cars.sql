--liquibase formatted sql

--changeset author:2020-05-02-add-fk_cars_colors_color
ALTER TABLE cars
ADD CONSTRAINT fk_cars_colors_color FOREIGN KEY (color)
REFERENCES colors(color_id)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

--rollback ALTER TABLE cars DROP CONSTRAINT fk_cars_colors_color

--changeset author:2020-05-02-add-fk_cars_car_types_car_type
ALTER TABLE cars
ADD CONSTRAINT fk_cars_car_types_car_type FOREIGN KEY (car_type)
REFERENCES car_types(type_id)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

--rollback ALTER TABLE cars DROP CONSTRAINT fk_cars_car_types_car_type

--changeset author:2020-05-02-add-fk_cars_users_owner_id
ALTER TABLE cars
ADD CONSTRAINT fk_cars_users_owner_id FOREIGN KEY (owner_id)
REFERENCES users(user_id)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

--rollback ALTER TABLE cars DROP CONSTRAINT fk_cars_users_owner_id