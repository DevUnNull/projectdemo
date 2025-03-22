INSERT INTO flight (id, airline_id, departing_airport, arriving_airport, departing_gate, arriving_gate, departure_time, arrival_time)
VALUES (400, (SELECT id FROM airline WHERE name = 'Vietnam Airlines'), 
        (SELECT id FROM airport WHERE code = 'HAN'), 
        (SELECT id FROM airport WHERE code = 'CDG'),
        NULL, NULL, 
        '2024-03-17 23:15:00', '2024-03-18 06:30:00');
