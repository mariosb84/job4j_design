insert into role(name) values ('admin');
insert into users(name, role_id) VALUES ('Igor', 1);
insert into rules(name) VALUES ('All acces');
insert into role_rules(role_id, rules_id) VALUES (1, 1);
insert into item(name, users_id) VALUES ('IgorWeekJob', 1);
insert into comments(name, item_id) VALUES ('In work', 1);
insert into attachs(name, item_id) VALUES ('File.txt', 1);
insert into category(name) values ('VeryImportant');
insert into state(name) values ('OnPerfomance');