select * from emploers e left join departments d 
on e.departments_id = d.id;

select * from departments d right join emploers e 
on d.id = e.departments_id;

select * from emploers e full join departments d 
on e.departments_id = d.id;

select * from emploers e cross join departments d;

select * from emploers e left join departments d 
on e.departments_id = d.id
where e.name is null;

select d.name as департамент, e.name as сотрудник, e.departments_id as департамент_id
from emploers e 
left join departments d
on e.departments_id = d.id;

select d.name as департамент, e.name as сотрудник, e.departments_id as департамент_id
from departments d 
right join emploers e
on d.id = e.departments_id;