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

select  cs.name as неиспользуемый_тип_кузова
from carcase cs
join car c
on cs.id = c.carcase_id
where c.name is null;
select  e.name as неиспользуемый_тип_двигателя
from engine e
join car c
on e.id = c.engine_id
where c.name is null;
select  t.name as неиспользуемый_тип_коробки
from transmission t
join car c
on t.id = c.transmission_id
where c.name is null;