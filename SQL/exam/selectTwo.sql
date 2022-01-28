select c.name 
as company_max_person,
count(p.company_id)
as person_count
from company as c
join person p 
on p.company_id = c.id
group by c.name
having count(p.company_id) = 
(select count(p.company_id) 
from person p
group by p.company_id
order by 1 desc limit 1);







