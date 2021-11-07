select t.name as тип_меньше_10_штук from type as t join product p on p.type_id = t.id and p.type_id < 10
group by t.name;