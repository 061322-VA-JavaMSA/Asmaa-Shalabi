/*create schema task_manager;
drop schema task_manager;
drop table if exists users;
create table if not exists users(
id serial primary key,
username varchar(30) unique not null check(length(username) > 2),
password varchar(30) not null
--manager_id references users(id)
);
insert into users (username, password) values ('hcocking0', 'Gox1eyM1ph');
insert into users (username, password) values ('dvalenta1', 'GcYCYy4Q');
insert into users (username, password) values ('msargerson2', 'rN3ef1EzL');
insert into users (username, password) values ('jmoorey3', 'FZfFjGnS2L8N');
insert into users (username, password) values ('bfrancomb4', 'LpMu6k1');
insert into users (username, password) values ('jkahen5', 'GNgoHXs');
insert into users (username, password) values ('rblackster6', '4ZAhhFGDUQal');
insert into users (username, password) values ('ebyng7', 'Q2ujnRtXlAe7');
insert into users (username, password) values ('tbirkenshaw8', 'thIcitV');
insert into users (username, password) values ('jabele9', 'KcKuPU0lb');
drop table if exists tasks;
create table tasks (
id serial primary key,
description text,
due_date date default current_date,
status varchar(15) default 'new', -- whenever a record is created, value should be "new"
user_assigned_id integer references users(id)
);
insert into tasks (description, user_assigned_id) values ('Networked encompassing complexity', 1);
insert into tasks (description, user_assigned_id) values ('Phased 4th generation internet solution', 2);
insert into tasks (description, user_assigned_id) values ('Down-sized zero administration standardization', 3);
insert into tasks (description, user_assigned_id) values ('Object-based multimedia core', 1);
insert into tasks (description, user_assigned_id) values ('Realigned didactic time-frame', 2);
insert into tasks (description, user_assigned_id) values ('Seamless fresh-thinking contingency', 3);
insert into tasks (description, user_assigned_id) values ('Front-line composite info-mediaries', 4);
insert into tasks (description, user_assigned_id) values ('Cross-group user-facing internet solution', 5);
insert into tasks (description, user_assigned_id) values ('Programmable intangible parallelism', 6);
insert into tasks (description, user_assigned_id) values ('Function-based even-keeled instruction set', 7);

drop table if exists teams;
create table teams(
id serial primary key,
name varchar(20)
);

drop table if exists players;
create table players(
id serial primary key,
name varchar(20),
team_id integer references teams(id)
);

drop table if exists people;
create table people(
id serial primary key,
name varchar(30)
);

drop table if exists friends;
create table friends(
	friend1_id integer references people(id),
	friend2_id integer references people(id),
	primary key (friend1_id, friend2_id)
);

insert into people (name) values ('Nikita');

insert into people (name) values ('Zaki'), ('Erik');

-- mockaroo data:
insert into people (name) values ('Blesbok');
insert into people (name) values ('Least chipmunk');
insert into people (name) values ('Lapwing, southern');
insert into people (name) values ('Pied cormorant');
insert into people (name) values ('Lizard, giant girdled');
insert into people (name) values ('Goose, andean');
insert into people (name) values ('Cockatoo, red-breasted');
insert into people (name) values ('Western patch-nosed snake');
insert into people (name) values ('Masked booby');
insert into people (name) values ('Jungle kangaroo');

insert into friends(friend1_id, friend2_id) values(1,3), (1,5);

select * from users; -- * indicates all of the fields/columns
select id, username from users;*/
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
salary integer,
dept_id integer references department(dept_id)
);
drop table if exists customer;
create table if not exists customer(
id serial primary key,
c_name varchar(30),
sales_office_id integer references salesoffice(id),
employee_id integer references employee(id)
); 
drop table if exists employee;
insert into employee (first_name, last_name, salary, dept_id) values ('Michael', 'Scott', '65', '1');
insert into employee (first_name, last_name, salary, dept_id) values ('Dwight', 'Schrute', '75', '1');
insert into employee (first_name, last_name, salary, dept_id) values ('Toby', 'Flenderson', '80', '2');
insert into employee (first_name, last_name, salary, dept_id) values ('Jim', 'Halpert', '90', '1');
insert into employee (first_name, last_name, salary, dept_id) values ('Oscar', 'Martinez', '90', '3');
insert into employee (first_name, last_name, salary, dept_id) values ('Angela', 'Martin', '75', '3');
insert into employee (first_name, last_name, salary, dept_id) values ('Kevin', 'Malone', '70', '3');
insert into employee (first_name, last_name, salary, dept_id) values ('Holly', 'Flax', '60', '2');
insert into employee (first_name, last_name, salary, dept_id) values ('Creed', 'Branton', '70', '4');
select * from employee;
select * from employee where salary > 75;
select * from employee where first_name like '%e%' or last_name like 'S%';
select first_name from employee where department != 'Accounting';
select avg(salary) from employee where last_name like 'M%';
select max(salary) from employee where department ='Sales';
select * from employee where first_name like '%e%' or last_name like 'S%'
union all 
select * from employee where salary > 75;
delete from employee where department='Accounting';
alter table employee drop column department;

drop table if exists department;
create table if not exists department(
dept_id serial primary key,
dept_name varchar(50));
insert into department (dept_name) values ('Sales');
insert into department (dept_name) values ('HR');
insert into department (dept_name) values ('Accounting');
insert into department (dept_name) values ('Quality Assurance');
select min(salary) from employee e
inner join department d
on e.id=d.employee_id
where d.dept_name='Sales';
select avg(salary) from employee e
right join 
department d 
on e.id=d.employee_id
group by d.dept_name;


