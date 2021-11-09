select p.name as продукт_тип_сыр 
from type as t 
join product p 
on p.type_id = t.id
where t.name LIKE '%СЫР%';
select p.name as продукт_мороженное 
from product as p 
where p.name LIKE '%Мороженое%';
select * 
from product 
where expired_date < current_date;
select max(p.price) as самый_дорогой_продукт
from product as p;
select t.name, count(p.name) 
from type as t 
join product p 
on p.type_id = t.id
group by t.name;
select t.name as тип, p.name as название 
from type as t 
join product p 
on p.type_id = t.id
where t.name LIKE '%СЫР%' 
or t.name LIKE '%МОЛОКО%'; 
select t.name as тип_меньше_10_штук
from type as t 
join product p 
on p.type_id = t.id 
group by t.name
having count(p.name) < 10;
select p.name as название_продукта, t.name as тип_продукта 
from product as p 
join type t 
on p.type_id = t.id;