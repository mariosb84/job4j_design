create table fingerPrint(
    id serial primary key,
    print int
);
create table people(
    id serial primary key,
    name varchar(255),
    fingerPrint_id int references fingerPrint(id) unique
);