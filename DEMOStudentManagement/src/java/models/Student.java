package models;

public class Student {
    private int studentID;
    private String studentName;
    private String address;
    private long phone;
    private String email;
    private int classID;
    private String dob;

    public Student() {
    }

    public Student(int studentID, String studentName, String address, long phone, String email, int classID, String dob) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classID = classID;
        this.dob = dob;
    }

    // Getters and Setters
    public int getId() { return studentID; }
    public void setId(int studentID) { this.studentID = studentID; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public long getPhone() { return phone; }
    public void setPhone(long phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getClassID() { return classID; }
    public void setClassID(int classID) { this.classID = classID; }
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public void setName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setClassId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}