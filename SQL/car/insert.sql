insert into carcase(name) values ('седан'), ('лифтбэк'), ('универсал'), ('купе');
insert into engine(name) values ('бензиновый'), ('дизельный'), ('электический'), ('гибридный');
insert into transmission(name) values ('механическая'), ('автоматическая'), ('робот'), ('вариатор');
insert into car(name, carcase_id, engine_id, transmission_id) values 
('мазда', 1, 1, 1),
('мерседес', 2, 2, 2),
('тесла', 1, 3, 2),
('лада', 3, 1, 3),
(null, 4, 4, 4);