SET NAMES utf8mb4;
create table passenger_profile (
    id                  INT         primary key AUTO_INCREMENT,
    passengerlastname   varchar(255),
    passengername       varchar(255),
    passport_number     varchar(255),
    user_profile_id     integer
);
CREATE TABLE user_profile (
    id                  INT         PRIMARY KEY AUTO_INCREMENT,
    email               varchar(255),
    is_blocket_profile  boolean,
    lastname            varchar(255),
    profilename         varchar(255),
    phone               integer,
    user_id             integer
);

INSERT INTO user_profile (id, email, is_blocket_profile, lastname, profilename, phone, user_id)
VALUES
(1, 'admin@gmail.com', false, 'Admin', 'Admin', 999999, 1),
(2, 'vip@gmail.com', false, 'Lukashenko', 'Aleksandr', 998855, 2);
INSERT INTO passenger_profile (id, passengerlastname, passengername, passport_number, user_profile_id)
VALUES
(1, 'Admin', 'Admin', 'KK1100110', 1),
(2, 'Путин', 'Владимир', 'KK1100113', 1),
(3, 'Лукашенко', 'Александр', 'KK1100111', 2),
(4, 'Товарисч', 'Максим', 'KK1100112', 2);









