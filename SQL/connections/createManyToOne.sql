
create table studentsName(
    id serial primary key,
    name varchar(255)
);
create table students(
    id serial primary key,
    name varchar(255),
students_id int references students(id)
);


