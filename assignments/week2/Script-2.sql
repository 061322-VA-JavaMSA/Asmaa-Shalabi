drop table if exists payments;
create table if not exists payments(
id serial primary key,
customer_id i);
drop table if exists employee;

create table if not exists employee(
id serial  primary key,
username varchar(50) NOT NULL UNIQUE,
password varchar(30) not null,
first_name varchar(100),
last_name varchar(100),
email varchar(150),
e_role integer
);
drop table if exists customer;
create table if not exists customer(
id serial primary key,
username varchar(50) NOT NULL UNIQUE,
password varchar(30) not null,
balance integer
);
select * from employee  ;
drop table if exists rem;
create table if not exists rem(
id serial primary key,
amount integer,
description varchar(250),
employee_id integer,
submitted_date date,
resolved_date date,
status varchar(20),
ressolvedId integer

);
delete from items where i_name = 'pen';
drop table if exists items;
delete from items where i_name='Bread - Roll, Whole Wheat';

create table if not exists items(
id serial primary key,
i_name varchar(50),
price integer,
owned_state boolean,
customer_id integer references customer(id)
);
insert into rem (amount,description,employee_id,status) values(345,'keda kteeer',4,'pending');
insert into rem (amount,description,employee_id,status) values(345,'keda kteeer',4,'pending');
insert into rem (amount,description,employee_id,status) values(345,'keda kteeer',7,'pending');
insert into rem (amount,description,employee_id,status) values(345,'keda kteeer',4,'pending');
select i.i_name  from items i join offer o on i.customer_id = o.c_id ;
select * from items where customer_id= 1;
select c.id, c.i_name, c.owned_state from offer t join items c on t.c_id = c.customer_id where c.customer_id = 1;
select t.id, t.i_id,  t.c_id  from offer t join items c on t.c_id = c.id where c.id = 1;
update employee set username='aliaa',password='12345',first_name='aliaa' ,last_name='shalabi' ,email='asd.dff.com' where id=2;

select * from employee;
select t.id, t.i_name, t.owned_state, t.customer_id , c.username from items t join customer c on t.customer_id = c.id where c.id = 2;
insert into items (i_name, price) values ('hcocking0', '9876');
insert into items (i_name, price) values ('dvalenta1', '45678');
select * from customer;
insert into employee (username, password) values ('aliaa', '12345');
select * from offer;
select amount from offer where offer_date >'2022-06-22' and offer_date <= DATEADD(now()  , -7,'2022-06-22' );
select sum(amount) as total from offer where accepted = true;

select * from customer where id = 1;

