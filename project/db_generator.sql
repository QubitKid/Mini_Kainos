 

CREATE TABLE IF NOT EXISTS Employee(
    emp_no smallint NOT NULL AUTO_INCREMENT,
    emp_name VARCHAR(200) NOT NULL,
    address VARCHAR(400) NOT NULL,
    ni_number CHAR(13) NOT NULL,
    starting_salary decimal(11, 2),
    department_id int NOT NULL,
    is_manager bit DEFAULT 0,
    acc_no CHAR(8) NOT NULL,
    sortCode CHAR(8) NOT NULL,
    PRIMARY KEY(emp_no),
    FOREIGN KEY (department_id) REFERENCES Department(department_id)
);


CREATE TABLE IF NOT EXISTS Department(
    department_id smallint NOT NULL AUTO_INCREMENT,
    department_name ENUM('HR', 'Finance', 'Sales', 'Talent'),
    PRIMARY KEY  (department_id)
);

CREATE TABLE IF NOT EXISTS SalesEmployee(
    emp_no smallint NOT NULL AUTO_INCREMENT,
    commission_rate int NOT NULL,
    total_sales int NOT NULL DEFAULT 0,
    PRIMARY KEY (emp_no),
    FOREIGN KEY (emp_no) REFERENCES Employee(emp_no)
);


insert into Department (department_id, department_name) values (1, 'HR');
insert into Department (department_id, department_name) values (2, 'Finance');
insert into Department (department_id, department_name) values (3, 'Sales');
insert into Department (department_id, department_name) values (4, 'Talent');




