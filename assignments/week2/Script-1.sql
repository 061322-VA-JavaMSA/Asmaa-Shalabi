
drop table if exists salesoffice;
create table if not exists salesoffice(
id serial primary key,
street varchar(50),
city varchar(30),
state varchar(30),
zip integer);
drop table if exists employee;
create table if not exists employee(
id serial primary key,
first_name varchar(30) ,
last_name varchar(30),

dOb    date,
sales_office_id  integer references SalesOffice(id)

);
drop table if exists customer;
create table if not exists customer(
id serial primary key,
c_name varchar(30),
sales_office_id integer references salesoffice(id),
employee_id integer references employee(id)
); 
