-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, if(STATUS = 'SALE', "판매중", IF(STATUS = 'RESERVED', "예약중", "거래완료")) as STATUS
from USED_GOODS_BOARD
where CREATED_DATE like "2022-10-05"
order by BOARD_ID desc
;