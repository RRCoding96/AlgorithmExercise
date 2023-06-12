-- 코드를 입력하세요
SELECT distinct a.CART_ID
from CART_PRODUCTS a
inner join CART_PRODUCTS b 
on a.CART_ID = b.CART_ID
where a.NAME like 'Milk' and b.NAME like 'Yogurt'
order by CART_ID
;