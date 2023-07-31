# Write your MySQL query statement below
select round( (a.immediate / b.total) * 100.0, 2) as immediate_percentage 
from (
    select count(*) as immediate 
     from delivery 
     where order_date = customer_pref_delivery_date
    ) as a,
(select count(*) as total 
 from delivery) as b
