create table departments(
    id serial primary key,
    name varchar(255)
);
create table emploers(
    id serial primary key,
    name varchar(255),
departments_id int references departments(id)
);