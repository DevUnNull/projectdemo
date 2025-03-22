SELECT
    f.id AS flight_id,
    f.departing_airport,
    f.arriving_airport,
    f.departure_time,
    f.arrival_time,
    a.name AS airlineName
FROM
    flight AS f
JOIN
    airline AS a ON f.airline_id = a.id
WHERE
    a.name = 'Vietnam Airlines';
