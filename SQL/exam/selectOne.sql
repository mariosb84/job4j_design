select p.name as person, c.name as company, c.id as company_id from company as c
join person p  
on p.company_id = c.id
and p.company_id != 5;