package com.poly.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[user]")
public class User {

    @Id
    @Column(name = "Id", length = 20, nullable = false)
    private String id;

    @Column(name = "Password", length = 50)
    private String password;

    @Column(name = "Fullname", length = 50)
    private String fullname;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "Admin")
    private Boolean admin;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}

