-- 코드를 입력하세요
SELECT DATE_FORMAT(o.SALES_DATE, '%Y') as YEAR,
        DATE_FORMAT(o.SALES_DATE, '%m') as MONTH,
        u.GENDER as GENDER,
        count(distinct U.USER_ID) as USERS
from USER_INFO u
inner join ONLINE_SALE o on u.USER_ID = o.USER_ID
where u.GENDER is not null
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER
;