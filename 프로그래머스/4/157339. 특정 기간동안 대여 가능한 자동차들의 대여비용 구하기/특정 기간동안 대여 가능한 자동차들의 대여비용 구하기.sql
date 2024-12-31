-- 코드를 입력하세요
SELECT *
FROM (
    SELECT 
        C.CAR_ID, 
        C.CAR_TYPE, 
        ROUND(C.DAILY_FEE * (100 - D.DISCOUNT_RATE) / 100 * 30) AS FEE
    FROM 
        CAR_RENTAL_COMPANY_CAR C
        JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN D ON C.CAR_TYPE = D.CAR_TYPE
    WHERE 
        C.CAR_TYPE IN ('세단', 'SUV')
        AND D.DURATION_TYPE = '30일 이상'
        AND C.CAR_ID NOT IN (
            SELECT CAR_ID 
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01'
        )
) T
WHERE 
    FEE BETWEEN 500000 AND 1999999
ORDER BY 
    FEE DESC, 
    CAR_TYPE ASC, 
    CAR_ID DESC;

# SELECT *
# FROM(SELECT C.CAR_ID, C.CAR_TYPE, (ROUND(C.DAILY_FEE/100*(100-D.DISCOUNT_RATE) * 30)) AS FEE FROM (SELECT * FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE IN ('세단', 'SUV') AND CAR_ID NOT IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE IN ('세단', 'SUV')) AND ((YEAR(START_DATE) = 2022 AND MONTH(START_DATE) = 11) OR (YEAR(END_DATE) = 2022 AND MONTH(END_DATE) = 11) OR ((YEAR(START_DATE) = 2022 AND MONTH(START_DATE)<=11) AND (YEAR(END_DATE) = 2022 AND MONTH(END_DATE)>=11))))) AS C , (SELECT * FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE IN ('세단', 'SUV') AND DURATION_TYPE = '30일 이상') AS D WHERE C.CAR_TYPE = D.CAR_TYPE) AS T
# WHERE FEE >=500000 AND FEE <2000000
# ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;

# SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE IN ('세단', 'SUV'); -- 세단과 SUV 번호

# SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE IN ('세단', 'SUV')) AND ((MONTH(START_DATE) = 11) OR (MONTH(END_DATE) = 11) OR (MONTH(START_DATE)<=11 AND MONTH(END_DATE)>=11)); # 11월에 예약불가능한 세단과 SUV 번호

# SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE IN ('세단', 'SUV') AND CAR_ID NOT IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE IN ('세단', 'SUV')) AND (YEAR(START_DATE)=2022 AND (MONTH(START_DATE) = 11) OR (YEAR(END_DATE)=2022 AND MONTH(END_DATE) = 11) OR ((YEAR(START_DATE)=2022 AND MONTH(START_DATE)<=11) AND (YEAR(END_DATE)=2022 AND MONTH(END_DATE)>=11)))) # 11월 예약 가능한 세단과 SUV 번호

# SELECT * FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE IN ('세단', 'SUV') AND DURATION_TYPE = '30일 이상'; # 세단과 SUV 30일 할인율

# SELECT C.CAR_ID, C.CAR_TYPE, (ROUND(C.DAILY_FEE/100*(100-D.DISCOUNT_RATE) * 30)) AS FEE FROM (SELECT * FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE IN ('세단', 'SUV') AND CAR_ID NOT IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE IN ('세단', 'SUV')) AND ((YEAR(START_DATE) = 2022 AND MONTH(START_DATE) = 11) OR (YEAR(END_DATE) = 2022 AND MONTH(END_DATE) = 11) OR ((YEAR(START_DATE) = 2022 AND MONTH(START_DATE)<=11) AND (YEAR(END_DATE) = 2022 AND MONTH(END_DATE)>=11))))) AS C , (SELECT * FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE IN ('세단', 'SUV') AND DURATION_TYPE = '30일 이상') AS D WHERE C.CAR_TYPE = D.CAR_TYPE; # 11월 예약 가능한 세단과 SUV 번호, 타입, 30일치 금액