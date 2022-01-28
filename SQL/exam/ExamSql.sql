CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values 
(1, 'SomeCompanyOne'),
(2, 'SomeCompanyTwo'),
(3, 'SomeCompanyThree'),
(4, 'SomeCompanyFour'),
(5, 'SomeCompanyFive');
insert into person(id, name, company_id) values
(1, 'SomePersonOne', 1),
(2, 'SomePersonTwo', 2),
(3, 'SomePersonThree', 3),
(4, 'SomePersonFour', 4), 
(5, 'SomePersonFive', 2),
(6, 'SomePersonSix', 2), 
(7, 'SomePersonSeven', 1),
(8, 'SomePersonEight', 1),
(9, 'SomePersonNine', 3), 
(10, 'SomePersonTen', 1),
(11, 'SomePersonEleven', 5);

select p.name as person, c.name as company, c.id as company_id from company as c
join person p  
on p.company_id = c.id
and p.company_id != 5;

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