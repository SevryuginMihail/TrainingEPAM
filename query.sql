-- поиск products по title
select *
from products p
where title = 'ACADEMY ACADEMY';
--поиск products по price = 9.99 и category = 8 и отсортировать по category и price
select *
from products
where price = '9.99'
	and category = '8'
order by category, price;
--поиск products у которых category = 8 или 15
select *
from products
where category = '8'
	or category = '15';
--поиск products у которых price между 10 и 20 (используйте BETWEEN)
select *
from products
where price
	between '10' and '20'
order by price;
--поиск orders у которых orderdate между 2004-01-05 и 2004-02-05
select *
from orders
where orderdate
    between to_date('2004-01-05', 'YYYY-MM-DD') and to_date('2004-02-05', 'YYYY-MM-DD');
order by orderdate;
--сгруппировать данные в orders по полю customerid и посчитать количество относительно каждого customerid
select customerid ,count(*)
from orders
group by customerid
order by customerid;
--сгруппировать данные в orders по полям customerid и orderdate и просуммировать totalamount, при этом сумма
--totalamount должна быть больше 100
select customerid ,orderdate ,sum(totalamount)
from orders
group by customerid ,orderdate
having sum(totalamount)>100;
--Написать запрос к таблицам customer, orders, orderlines и products с использованием JOIN
--и вывести firstname, lastname, title, orderdate
select c.firstname,c.lastname, p.title ,o1.orderdate
from customers c
	join orders o on c.customerid = o.customerid
	join orderlines o1 on o.orderdate = o1.orderdate
	join products p on p.prod_id = o1.prod_id