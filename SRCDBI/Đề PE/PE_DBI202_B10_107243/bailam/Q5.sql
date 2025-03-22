SELECT m.mechanicID, SUM(s.hours) AS sumHours 
FROM Mechanic m
JOIN ServiceMehanic s ON m.mechanicID = s.mechanicID
GROUP BY m.mechanicID
HAVING SUM(s.hours) < 7;
