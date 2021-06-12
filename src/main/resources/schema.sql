DROP TABLE IF EXISTS department cascade;
DROP TABLE IF EXISTS employee;

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