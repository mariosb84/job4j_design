 create table sportsmen(
     id serial primary key,
     name varchar(255)
 );
 
 create table kindsOfSports(
     id serial primary key,
     name varchar(255)
 );
 
 create table sportsmen_kindsOfSports(
     id serial primary key,
     sportsman_id int references sportsmen(id),
     kindsOfSport_id int references kindsOfSports(id)
 );