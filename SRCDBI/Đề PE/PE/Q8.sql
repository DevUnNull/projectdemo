CREATE PROCEDURE P1
    @passenger_id INT,
    @numberOfBookings INT OUTPUT
AS
BEGIN
    SELECT @numberOfBookings = COUNT(*)
    FROM booking
    WHERE passenger_id = @passenger_id;
END;
