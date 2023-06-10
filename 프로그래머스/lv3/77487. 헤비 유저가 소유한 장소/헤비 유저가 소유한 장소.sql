-- 코드를 입력하세요
SELECT *
from PLACES
where HOST_ID IN (select p.HOST_ID
     from PLACES p
     group by p.HOST_ID
     having count(*) >= 2)
order by ID
;