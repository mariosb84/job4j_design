insert into carcase(name) values ('седан'), ('лифтбэк'), ('универсал'), (null);
insert into engine(name) values ('бензиновый'), ('дизельный'), ('электический'), (null);
insert into transmission(name) values ('механическая'), ('автоматическая'), ('робот'), (null);
insert into car(name, carcase_id, engine_id, transmission_id) values 
('мазда', 1, 1, 1),
('мерседес', 2, 2, 2),
('тесла', 1, 3, 2),
('лада', 3, 1, 3),
(null, null, null, null);