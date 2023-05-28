-- 코드를 입력하세요
SELECT o.ANIMAL_ID as ANIMAL_ID, o.NAME as NAME
from ANIMAL_OUTS o
left join ANIMAL_INS i on o.ANIMAL_ID = i.ANIMAL_ID
where i.DATETIME is null
order by ANIMAL_ID
;