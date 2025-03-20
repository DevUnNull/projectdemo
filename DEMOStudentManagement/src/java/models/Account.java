package models;

public class Account {
    private int id;
    private String username;
    private String password;
    private int role;
    private String name;
    private String email;

    // Constructor có tham số
    public Account(int id, String name, String email, String password, int role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    // Constructor mặc định (có thể không có)
    public Account() {
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}