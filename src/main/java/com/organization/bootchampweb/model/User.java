package com.organization.bootchampweb.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Email cannot be null")
    @Email(message = "invalid email format")
    private String email;
    @NotNull(message = "Username cannot be null")
    @Size(min = 5, max = 50, message
            = "About Me must be between 5 and 50 characters")
    private String userName;
    @NotNull(message = "Password cannot be null")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}