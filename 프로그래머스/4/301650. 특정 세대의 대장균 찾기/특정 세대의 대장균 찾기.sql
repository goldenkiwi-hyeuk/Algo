WITH RECURSIVE ECOLI_DATA_WITH_GEN
AS
(
    SELECT ID, PARENT_ID, 1 AS GEN_ID
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL

    UNION ALL

    SELECT e.ID, e.PARENT_ID, p.GEN_ID + 1
    FROM ECOLI_DATA e
    JOIN ECOLI_DATA_WITH_GEN p ON e.PARENT_ID = p.ID
    WHERE p.GEN_ID < 3
)
SELECT ID
FROM ECOLI_DATA_WITH_GEN
WHERE GEN_ID = 3;