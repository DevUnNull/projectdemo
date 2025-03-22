CREATE FUNCTION dbo.F1 (@DepartmentID INT)
RETURNS INT
AS
BEGIN
    DECLARE @NumberOfPatients INT;
    
    SELECT @NumberOfPatients = COUNT(DISTINCT p.PatientID)
    FROM Patients p
    INNER JOIN Appointments a ON p.PatientID = a.PatientID
    INNER JOIN Doctors d ON a.DoctorID = d.DoctorID
    WHERE d.DepartmentID = @DepartmentID;
    
    RETURN @NumberOfPatients;
END;
GO


