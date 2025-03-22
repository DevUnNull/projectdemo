WITH DoctorRecords AS (
    SELECT
        d.DepartmentID,
        CONCAT(d.FirstName, ' ', d.LastName) AS DoctorFullName,
        d.DoctorID,
        COUNT(mr.RecordID) AS NumberOfRecords
    FROM
        Doctors d
    JOIN
        Appointments a ON d.DoctorID = a.DoctorID
    JOIN
        MedicalRecords mr ON a.AppointmentID = mr.AppointmentID
    GROUP BY
        d.DepartmentID, d.DoctorID, d.FirstName, d.LastName
),
MaxRecords AS (
    SELECT
        DepartmentID,
        MAX(NumberOfRecords) AS MaxRecords
    FROM
        DoctorRecords
    GROUP BY
        DepartmentID
)
SELECT
    dr.DepartmentID,
    dep.Name AS DepartmentName,
    dr.DoctorID,
    dr.DoctorFullName,
    dr.NumberOfRecords
FROM
    DoctorRecords dr
JOIN
    MaxRecords mr ON dr.DepartmentID = mr.DepartmentID AND dr.NumberOfRecords = mr.MaxRecords
JOIN
    Departments dep ON dr.DepartmentID = dep.DepartmentID
ORDER BY
    dr.DepartmentID, dr.DoctorID;
