insert into devices(name, price) values ('Айфон', 100000), ('Самсунг', 80000), ('Сяоми', 30000);
insert into people(name) values ('Маша'), ('Рома'), ('Иван');
insert into devices_people(device_id, people_id) values (1, 1), (1, 2);
insert into devices_people(device_id, people_id) values (2, 1);
insert into devices_people(device_id, people_id) values (3, 3);