SELECT 
    p.partID, 
    p.partName, 
    SUM(up.price) AS SumOfUsedPrice
FROM Parts p
left JOIN PartsUsed up ON p.partID = up.partID
GROUP BY p.partID, p.partName;
