select n1.name as "1",n2.name as "2" from teens n1 cross join teens n2
where n1.gender!= n2.gender;
