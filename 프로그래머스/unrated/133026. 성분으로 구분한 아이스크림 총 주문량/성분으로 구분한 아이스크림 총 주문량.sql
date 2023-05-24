-- 코드를 입력하세요
SELECT I.INGREDIENT_TYPE, SUM(H.TOTAL_ORDER) AS TOTAL_ORDER
FROM ICECREAM_INFO I
LEFT JOIN FIRST_HALF H ON I.FLAVOR = H.FLAVOR
GROUP BY INGREDIENT_TYPE
ORDER BY TOTAL_ORDER
;