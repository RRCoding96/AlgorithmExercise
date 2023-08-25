# Write your MySQL query statement below
select a.stock_name as stock_name,
    sum(a.price) as capital_gain_loss 
from (
    select stock_name,
        operation,
        operation_day,
        if(operation = 'Buy', -price, price) as price
    from Stocks s
    order by stock_name, operation_day
) a
group by stock_name
;