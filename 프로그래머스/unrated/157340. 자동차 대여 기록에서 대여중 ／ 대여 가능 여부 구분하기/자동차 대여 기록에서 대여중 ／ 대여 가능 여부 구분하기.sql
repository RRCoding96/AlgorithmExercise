-- 코드를 입력하세요
SELECT car_id,
       CASE WHEN '2022-10-16' BETWEEN start_date AND end_date THEN '대여중'
            ELSE '대여 가능' 
        END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE end_date >= '2022-10-16'
GROUP BY 1
ORDER BY car_id DESC;
