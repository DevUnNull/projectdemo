SELECT
    a.id AS airline_id,
    a.name AS airlineName,
    COUNT(f.id) AS NumberOfFlights
FROM
    airline AS a
JOIN
    flight AS f ON a.id = f.airline_id
WHERE
    a.name NOT IN ('Vietnam Airlines', 'Air France', 'Lufthansa Airlines')
GROUP BY
    a.id, a.name
HAVING
    COUNT(f.id) > (
        SELECT COUNT(f2.id)
        FROM airline AS a2
        JOIN flight AS f2 ON a2.id = f2.airline_id
        WHERE a2.name IN ('Vietnam Airlines', 'Air France', 'Lufthansa Airlines')
        GROUP BY a2.id
        ORDER BY COUNT(f2.id) DESC
        OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY -- For SQL Server
    );
