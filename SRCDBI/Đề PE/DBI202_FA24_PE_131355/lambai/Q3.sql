SELECT A.AppointmentID, A.AppointmentDate, A.DoctorID, D.FirstName, D.LastName, A.Reason
FROM Appointments A
JOIN Doctors D ON A.DoctorID = D.DoctorID
WHERE D.FirstName = 'Linda' AND D.LastName = 'Brown';
