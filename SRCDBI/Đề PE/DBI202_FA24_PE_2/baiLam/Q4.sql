select p.PatientID,p.FirstName,p.LastName,p.DateOfBirth,p.Email from Patients p
join Appointments a on p.PatientID = a.PatientID
join Doctors d on a.DoctorID = d.DoctorID
join Departments dp on d.DepartmentID = dp.DepartmentID
where dp.Name = 'Cardiology' and
year(a.AppointmentDate) between 2021 and 2024
order by p.PatientID
-- patientID, FN, LN,DOB,E