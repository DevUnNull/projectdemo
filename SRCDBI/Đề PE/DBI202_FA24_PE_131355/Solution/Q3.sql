SELECT 
    a.AppointmentID,
    a.AppointmentDate,
    a.DoctorID,
    d.FirstName,
    d.LastName,
    a.Reason
FROM 
    Appointments a
INNER JOIN 
    Doctors d ON a.DoctorID = d.DoctorID
WHERE 
    d.FirstName = 'Linda' AND d.LastName = 'Brown';
