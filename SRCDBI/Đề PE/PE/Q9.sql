CREATE TRIGGER T1
ON booking
AFTER DELETE
AS
BEGIN
    DELETE FROM baggage
    WHERE booking_id IN (SELECT deleted.id FROM deleted);
END;
