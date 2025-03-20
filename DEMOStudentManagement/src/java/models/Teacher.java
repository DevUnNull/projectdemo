package models;

public class Teacher {
    private int teacherID; // Đổi kiểu dữ liệu từ String sang int
    private String teacherName;
    private String address;
    private long phone;
    private String email;
    private String dob; // Thêm thuộc tính ngày sinh

    public Teacher() {
    }

    public Teacher(int teacherID, String teacherName, String address, long phone, String email, String dob) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
    }

    // Getters and Setters
    public int getTeacherID() { return teacherID; }
    public void setTeacherID(int teacherID) { this.teacherID = teacherID; }
    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public long getPhone() { return phone; }
    public void setPhone(long phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDob() { return dob; } // Getter cho dob
    public void setDob(String dob) { this.dob = dob; } // Setter cho dob

    public void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}