SELECT
    f.id AS flight_id,
    f.departure_time,
    f.arrival_time,
    a.name AS airlineName,
    depAirport.name AS departingAirportName,
    depAirport.country AS departingCountry,
    arrAirport.name AS arrivingAirportName,
    arrAirport.country AS arrivingCountry
FROM
    flight AS f
JOIN
    airline AS a ON f.airline_id = a.id
JOIN
    airport AS depAirport ON f.departing_airport = depAirport.id
JOIN
    airport AS arrAirport ON f.arriving_airport = arrAirport.id
WHERE
    f.departure_time >= '2023-01-01'
    AND f.departure_time < '2023-07-01'
    AND depAirport.country = arrAirport.country;
