
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


