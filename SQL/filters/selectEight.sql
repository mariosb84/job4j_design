select p.name as название_продукта, t.name as тип_продукта from product as p join type t on p.type_id = t.id;