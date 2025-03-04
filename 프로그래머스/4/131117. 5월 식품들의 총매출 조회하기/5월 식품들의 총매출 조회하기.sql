-- 코드를 입력하세요
SELECT T1.PRODUCT_ID, T1.PRODUCT_NAME, SUM(T1.PRICE*T2.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT AS T1, (SELECT * FROM FOOD_ORDER WHERE YEAR(PRODUCE_DATE) = 2022 AND MONTH(PRODUCE_DATE) = 5) AS T2
WHERE T1.PRODUCT_ID = T2.PRODUCT_ID
GROUP BY T1.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, T1.PRODUCT_ID ASC
# SELECT * FROM FOOD_ORDER WHERE YEAR(PRODUCE_DATE) = 2022 AND MONTH(PRODUCE_DATE) = 5; # 생산일자가 5월인 식품정보