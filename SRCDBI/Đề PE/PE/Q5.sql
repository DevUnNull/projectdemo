SELECT
    a.id AS airline_id,
    a.name,
    COALESCE(COUNT(CASE WHEN MONTH(b.booking_time) = 1 AND YEAR(b.booking_time) = 2023 THEN b.id END), 0) AS NumberOfBookings
FROM
    airline AS a
LEFT JOIN
    booking AS b ON a.id = b.booking_platform_id
GROUP BY
    a.id, a.name
ORDER BY
    NumberOfBookings DESC,
    a.id ASC;
