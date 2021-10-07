create table studentsFive(
    id serial primary key,
    name varchar(255)
);

create table studentsFiveName(
    id serial primary key,
    name varchar(255),
    studentsFive_id int references studentsFive(id)
);

