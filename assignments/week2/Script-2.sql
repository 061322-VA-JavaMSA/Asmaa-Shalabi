drop table if exists employee;

create table if not exists employee(
id serial primary key,
username varchar(50),
password varchar(30)
);
drop table if exists customer;
create table if not exists customer(
id serial primary key,
username varchar(50),
password varchar(30)
);
drop table if exists items;

create table if not exists items(
id serial primary key,
i_name varchar(50),
quantity integer,
price integer,
owned_state boolean,
customer_id integer references customer(id)
);
drop table if exists offer;
create table if not exists offer(
c_id integer references customer(id),
i_id integer references items(id),
amount integer 
);
select * from employee;