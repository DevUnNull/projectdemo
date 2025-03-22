SELECT DISTINCT P.PatientID, P.FirstName, P.LastName, P.DateOfBirth, P.Email
FROM Patients P
JOIN Appointments A ON P.PatientID = A.PatientID
JOIN Doctors D ON A.DoctorID = D.DoctorID
JOIN Departments DP ON D.DepartmentID = DP.DepartmentID
WHERE DP.Name = 'Cardiology'
AND YEAR(A.AppointmentDate) BETWEEN 2021 AND 2024
ORDER BY P.PatientID;

-- PID, FN , LN , Date , Email