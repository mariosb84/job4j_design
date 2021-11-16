select s.name, avg(m.price)from devices_people as ss join people s  on ss.people_id = s.id 
join devices m on ss.device_id = m.id 
group by s.name
having avg(m.price) > 5000;