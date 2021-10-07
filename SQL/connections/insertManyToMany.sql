insert into sportsmen(name) values ('Ivan');
insert into sportsmen(name) values ('Kirill');
insert into sportsmen(name) values ('Roman');

insert into kindsOfSports(name) values ('Football');
insert into kindsOfSports(name) values ('Basketball');
insert into kindsOfSports(name) values ('Tennis');

insert into sportsmen_kindsOfSports(sportsman_id, kindsOfSport_id) values (1, 1);
insert into sportsmen_kindsOfSports(sportsman_id, kindsOfSport_id) values (1, 2);
insert into sportsmen_kindsOfSports(sportsman_id, kindsOfSport_id) values (1, 3);
insert into sportsmen_kindsOfSports(sportsman_id, kindsOfSport_id) values (2, 1);
insert into sportsmen_kindsOfSports(sportsman_id, kindsOfSport_id) values (2, 2);
insert into sportsmen_kindsOfSports(sportsman_id, kindsOfSport_id) values (3, 3);