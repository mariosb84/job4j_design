
create table studentsGroup(
    id serial primary key,
    name varchar(255)
);
create table students(
    id serial primary key,
    name varchar(255),
studentsGroup_id int references studentsGroup(id)
);


