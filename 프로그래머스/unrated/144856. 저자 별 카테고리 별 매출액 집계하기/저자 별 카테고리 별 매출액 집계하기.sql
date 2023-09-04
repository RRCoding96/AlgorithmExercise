-- 코드를 입력하세요
SELECT b.AUTHOR_ID as AUTHOR_ID,
        a.AUTHOR_NAME as AUTHOR_NAME,
        b.CATEGORY as CATEGORY,
        sum(b.PRICE * bs.SALES) as TOTAL_SALES
from BOOK_SALES bs
join BOOK b on bs.BOOK_ID = b.BOOK_ID
join AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID
where bs.SALES_DATE between '2022-01-01' and '2022-01-31'
group by b.AUTHOR_ID , b.CATEGORY
order by AUTHOR_ID, CATEGORY desc
;