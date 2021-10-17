create table profession (
    id serial primary key,
    name varchar(255),
	salaryValue int
);

create table people (
    id serial primary key,
    name varchar(255),
    profession_id int references profession(id)
);