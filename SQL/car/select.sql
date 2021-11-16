select c.name as марка,
cs.name as кузов,
e.name as двигатель,
t.name as коробка
from car as c
join carcase cs
on c.carcase_id = cs.id
join engine e
on c.engine_id = e.id
join transmission t
on c.transmission_id = t.id;

select  cs.name as кузов
from carcase cs
left join car c
on cs.id = c.carcase_id
where c.carcase_id is null;
select  e.name as двигатель
from engine e
left join car c
on e.id = c.engine_id
where c.engine_id is null;
select  t.name as коробка
from transmission t
left join car c
on t.id = c.transmission_id
where c.transmission_id is null;
