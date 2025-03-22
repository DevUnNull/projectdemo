SELECT
    bp.id AS booking_platform_id,
    bp.name AS booking_platform_name,
    COUNT(DISTINCT CASE WHEN p.gender = 'Male' THEN b.passenger_id END) AS NumberOfMalePassengers,
    COUNT(DISTINCT CASE WHEN p.gender = 'Female' THEN b.passenger_id END) AS NumberOfFemalePassengers
FROM
    booking AS b
JOIN
    bookingPlatform AS bp ON b.booking_platform_id = bp.id
JOIN
    passenger AS p ON b.passenger_id = p.id
JOIN
    flight AS f ON b.flight_id = f.id
JOIN
    airport AS depAirport ON f.departing_airport = depAirport.id
WHERE
    depAirport.country = 'Germany'
GROUP BY
    bp.id, bp.name;
