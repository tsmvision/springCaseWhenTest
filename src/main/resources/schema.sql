DROP TABLE IF EXISTS department CASCADE;
DROP TABLE IF EXISTS employee CASCADE;

CREATE TABLE department
(
    id      serial PRIMARY KEY,
    name    VARCHAR(50)  NOT NULL
);

CREATE TABLE employee
(
    id            serial PRIMARY KEY,
    first_name    VARCHAR(50)  NOT NULL,
    last_name     VARCHAR(50)         NOT NULL,
    department_id INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department(id)
);

-- -- MySQl version
-- SET foreign_key_checks = 0;
-- DROP TABLE IF EXISTS department;
-- DROP TABLE IF EXISTS employee;
-- SET foreign_key_checks = 1;
--
-- CREATE TABLE department
-- (
--     id      INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     name    VARCHAR(50)  NOT NULL
-- );
--
-- CREATE TABLE employee
-- (
--     id            INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     first_name    VARCHAR(50)  NOT NULL,
--     last_name     VARCHAR(50)         NOT NULL,
--     department_id INT NOT NULL,
--     FOREIGN KEY (department_id) REFERENCES department(id)
-- );