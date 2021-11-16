create table carcase(
    id serial primary key,
    name varchar(255)
);
create table engine (
    id serial primary key,
    name varchar(255)
);
create table transmission(
    id serial primary key,
    name varchar(255)
);
create table car(
    id serial primary key,
    name varchar(255),
carcase_id int references carcase(id),
engine_id int references engine (id),
transmission_id int references transmission(id)	
);